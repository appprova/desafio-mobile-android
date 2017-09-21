package net.hugonardo.gjp;

import android.app.Application;
import android.support.annotation.CallSuper;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

import io.fabric.sdk.android.Fabric;

public abstract class GjpFabricApplication extends Application {

    @CallSuper @Override public void onCreate() {
        super.onCreate();
        setupFabricKits();
    }

    private void setupFabricKits() {
        Crashlytics crashlytics = new Crashlytics.Builder()
                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                .build();

        Fabric.with(this, crashlytics);
    }
}
