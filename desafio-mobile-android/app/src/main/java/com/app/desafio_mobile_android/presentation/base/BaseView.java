package com.app.desafio_mobile_android.presentation.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.app.desafio_mobile_android.intrastructure.error.OperationError;

public interface BaseView<T extends BasePresenter> {

    Context getContext();

    void setPresenter(@NonNull T presenter);

    void showError(OperationError error);

    void setLoading(boolean isLoading);
}
