package net.hugonardo.gjp;

import android.support.annotation.CallSuper;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;

import dagger.android.support.DaggerApplication;
import io.fabric.sdk.android.Fabric;

public abstract class GjpFabricApplication extends DaggerApplication {

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
