package com.app.desafio_mobile_android.business;

import android.content.Context;

import com.app.desafio_mobile_android.intrastructure.util.NetworkUtil;
import com.app.desafio_mobile_android.intrastructure.util.ServiceListener;
import com.app.desafio_mobile_android.service.Api;
import com.app.desafio_mobile_android.service.ApiInstance;
import com.app.desafio_mobile_android.service.model.repositorie.Repositorie;
import com.app.desafio_mobile_android.service.repository.RepositorieRepository;

public class RepositorieBusiness {

    private RepositorieRepository mRepositorieRepository;

    public RepositorieBusiness(Context context) {
        mRepositorieRepository = new RepositorieRepository(ApiInstance.getAPI().create(Api.class),
                new NetworkUtil(context));
    }

    public void callServiceRepositorie(int pageNumber, ServiceListener<Repositorie> callback) {
        mRepositorieRepository.requestRepositoryList(pageNumber, callback);
    }
}
