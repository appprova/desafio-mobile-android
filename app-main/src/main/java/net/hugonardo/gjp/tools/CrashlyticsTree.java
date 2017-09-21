package net.hugonardo.gjp.tools;

import com.crashlytics.android.Crashlytics;

import lombok.RequiredArgsConstructor;
import timber.log.Timber;

import static android.util.Log.WARN;

@RequiredArgsConstructor
public class CrashlyticsTree extends Timber.Tree {

    @Override protected boolean isLoggable(String tag, int priority) {
        return priority >= WARN;
    }

    @Override protected void log(int priority, String tag, String message, Throwable t) {
        Crashlytics.log(message);
        if (t != null) {
            Crashlytics.logException(t);
        }
    }
}
