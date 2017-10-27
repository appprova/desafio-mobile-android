package com.felipemiranda.desafioappprova.network;

import com.felipemiranda.desafioappprova.AppProvaApplication;
import com.felipemiranda.desafioappprova.model.response.GenericErrorResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by felipemiranda on 26/10/17.
 */

public abstract class RestCallback<T extends Object> implements Callback<T> {

    public abstract void onSuccess(T response);

    public abstract void onError(GenericErrorResponse error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful())
            onSuccess(response.body());
        else {
            GenericErrorResponse error = GenericErrorResponse.getResponseError(response.errorBody());
            if (error == null || error.getMessage() == null)
                error = GenericErrorResponse.getExceptionError();

            onError(error);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (!AppProvaApplication.getInstance().isOnline())
            onError(GenericErrorResponse.getConnectionError());
        else
            onError(GenericErrorResponse.getExceptionError());
    }
}
