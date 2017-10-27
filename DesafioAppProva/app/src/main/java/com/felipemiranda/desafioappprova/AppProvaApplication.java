package com.felipemiranda.desafioappprova;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.multidex.MultiDex;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.felipemiranda.desafioappprova.network.InternetConnection;

/**
 * Created by felipemiranda on 26/10/17.
 */

public class AppProvaApplication extends Application implements InternetConnection {

    private static AppProvaApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        MultiDex.install(this);

        mInstance = this;
    }

    public static AppProvaApplication getInstance() {
        return mInstance;
    }

    @Override
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm != null ? cm.getActiveNetworkInfo() : null;
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
