package net.hugonardo.gjp.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;

@Getter
public class ApiResponse<T> {
    private static final Pattern LINK_PATTERN = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"");
    private static final Pattern PAGE_PATTERN = Pattern.compile("page=(\\d)+");
    private static final String NEXT_LINK = "next";

    private final int mCode;
    @Nullable private final T mBody;
    @Nullable private final String mErrorMessage;
    @NonNull private final Map<String, String> mLinks;

    public ApiResponse(Throwable error) {
        mCode = 500;
        mBody = null;
        mErrorMessage = error.getMessage();
        mLinks = Collections.emptyMap();
    }

    public ApiResponse(Response<T> response) {
        mCode = response.code();
        if (response.isSuccessful()) {
            mBody = response.body();
            mErrorMessage = null;
        } else {
            String message = null;
            ResponseBody errorBody = response.errorBody();
            if (errorBody != null) {
                try {
                    message = errorBody.string();
                } catch (IOException ignored) {
                    Timber.e(ignored, "error while parsing response");
                }
            }
            if (message == null || message.trim().length() == 0) {
                message = response.message();
            }
            mErrorMessage = message;
            mBody = null;
        }
        String linkHeader = response.headers().get("link");
        if (linkHeader == null) {
            mLinks = Collections.emptyMap();
        } else {
            mLinks = new ArrayMap<>();
            Matcher matcher = LINK_PATTERN.matcher(linkHeader);

            while (matcher.find()) {
                int count = matcher.groupCount();
                if (count == 2) {
                    mLinks.put(matcher.group(2), matcher.group(1));
                }
            }
        }
    }

    public boolean successful() {
        return mCode >= 200 && mCode < 300;
    }

    public Integer nextPage() {
        String next = mLinks.get(NEXT_LINK);
        if (next == null) {
            return null;
        }
        Matcher matcher = PAGE_PATTERN.matcher(next);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return null;
        }
        try {
            return Integer.parseInt(matcher.group(1));
        } catch (NumberFormatException ex) {
            Timber.w("cannot parse next page from %s", next);
            return null;
        }
    }
}
