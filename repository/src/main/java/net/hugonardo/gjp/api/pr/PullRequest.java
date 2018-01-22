package net.hugonardo.gjp.api.pr;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import net.hugonardo.gjp.api.user.User;

@AutoValue
public abstract class PullRequest implements Parcelable {
    @SerializedName("id") public abstract Long id();
    @SerializedName("number") public abstract Long number();
    @SerializedName("title") public abstract String title();
    @SerializedName("body") public abstract String body();
    @SerializedName("user") public abstract User user();

    public static TypeAdapter<PullRequest> typeAdapter(Gson gson) {
        return new AutoValue_PullRequest.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_PullRequest.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(Long id);
        public abstract Builder number(Long number);
        public abstract Builder title(String title);
        public abstract Builder body(String body);
        public abstract Builder user(User user);
        public abstract PullRequest build();
    }
}
