package com.app.desafio_mobile_android.service.repository;

import com.app.desafio_mobile_android.intrastructure.Constants;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.intrastructure.util.NetworkUtil;
import com.app.desafio_mobile_android.intrastructure.util.ServiceListener;
import com.app.desafio_mobile_android.service.Api;
import com.app.desafio_mobile_android.service.model.pull.Pull;
import com.app.desafio_mobile_android.service.model.repositorie.Repositorie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PullRepository extends BaseRepository {
    private final static String STATE_SELECTED = "all";

    private Api mApiInstance;
    private NetworkUtil mNetworkUtil;

    public PullRepository(Api apiInstance, NetworkUtil networkUtil) {
        this.mApiInstance = apiInstance;
        this.mNetworkUtil = networkUtil;
    }

    public void requestRepositoryList(String owner, String repo, final ServiceListener<List<Pull>> callback) {
        final OperationError operationError = checkNetwork(mNetworkUtil);

        if (operationError != null) {
            callback.onServiceError(operationError);
            return;
        }

        Call<List<Pull>> call = mApiInstance.getPullList(owner, repo, STATE_SELECTED);
        call.enqueue(new Callback<List<Pull>>() {
            @Override
            public void onResponse(Call<List<Pull>> call, Response<List<Pull>> response) {
                callback.onServiceSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Pull>> call, Throwable t) {
                operationError.setErrorType(Constants.ErrorType.SERVICE_ERROR);
                callback.onServiceError(operationError);
            }
        });
    }
}
