package com.app.desafio_mobile_android.service.repository;

import com.app.desafio_mobile_android.intrastructure.Constants;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.intrastructure.util.NetworkUtil;

public class BaseRepository {

    public OperationError checkNetwork(NetworkUtil networkUtil) {
        final OperationError operationError = null;

        if (!networkUtil.isNetworkAvailable()) {
            operationError.setErrorType(Constants.ErrorType.NETWORK_ERROR);
        }
        return operationError;
    }
}
