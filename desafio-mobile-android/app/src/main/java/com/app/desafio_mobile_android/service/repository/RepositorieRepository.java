package com.app.desafio_mobile_android.service.repository;

import com.app.desafio_mobile_android.intrastructure.Constants;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.intrastructure.util.NetworkUtil;
import com.app.desafio_mobile_android.intrastructure.util.ServiceListener;
import com.app.desafio_mobile_android.service.Api;
import com.app.desafio_mobile_android.service.model.repositorie.Repositorie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositorieRepository extends BaseRepository {
    private final static String SORT_TYPE = "stars";

    private Api mApiInstance;
    private NetworkUtil mNetworkUtil;

    public RepositorieRepository(Api apiInstance, NetworkUtil networkUtil) {
        this.mApiInstance = apiInstance;
        this.mNetworkUtil = networkUtil;
    }

    public void requestRepositoryList(int page, final ServiceListener<Repositorie> callback) {
        final OperationError operationError = checkNetwork(mNetworkUtil);

        if (operationError != null) {
            callback.onServiceError(operationError);
            return;
        }

        Call<Repositorie> call = mApiInstance.getRepositorieList(SORT_TYPE, page);
        call.enqueue(new Callback<Repositorie>() {
            @Override
            public void onResponse(Call<Repositorie> call, Response<Repositorie> response) {
                callback.onServiceSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Repositorie> call, Throwable t) {
                operationError.setErrorType(Constants.ErrorType.SERVICE_ERROR);
                callback.onServiceError(operationError);
            }
        });
    }
}
