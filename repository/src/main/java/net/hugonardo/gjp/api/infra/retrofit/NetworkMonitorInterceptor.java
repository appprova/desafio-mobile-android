package net.hugonardo.gjp.api.infra.retrofit;

import net.hugonardo.java.commons.network.NetworkException;
import net.hugonardo.java.commons.network.NetworkMonitor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class NetworkMonitorInterceptor implements Interceptor {

    private final NetworkMonitor mNetworkMonitor;

    public NetworkMonitorInterceptor(NetworkMonitor networkMonitor) {
        mNetworkMonitor = networkMonitor;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (mNetworkMonitor.isConnected()) {
            return chain.proceed(chain.request());
        } else {
            throw new NetworkException();
        }
    }
}
