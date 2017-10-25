package com.app.desafio_mobile_android.intrastructure.util;

import com.app.desafio_mobile_android.intrastructure.error.OperationError;

public abstract class ServiceListener<TResult> {

    public abstract void onServiceSuccess(final TResult result);

    public abstract void onServiceError(final OperationError error);
}
