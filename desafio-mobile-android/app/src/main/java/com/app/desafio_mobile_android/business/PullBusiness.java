package com.app.desafio_mobile_android.business;

import android.content.Context;

import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.intrastructure.util.NetworkUtil;
import com.app.desafio_mobile_android.intrastructure.util.ServiceListener;
import com.app.desafio_mobile_android.presentation.pull.PullAdapter;
import com.app.desafio_mobile_android.presentation.pull.PullPresenter;
import com.app.desafio_mobile_android.presentation.pull.PullViewModel;
import com.app.desafio_mobile_android.service.Api;
import com.app.desafio_mobile_android.service.ApiInstance;
import com.app.desafio_mobile_android.service.model.pull.Pull;
import com.app.desafio_mobile_android.service.repository.PullRepository;

import java.util.List;

public class PullBusiness {
    private PullRepository mPullRepository;
    private ServiceListener<PullViewModel> mCallback;

    public PullBusiness(Context context) {
        mPullRepository = new PullRepository(ApiInstance.getAPI().create(Api.class),
                new NetworkUtil(context));
    }

    public void callPullList(String owner, String repo, ServiceListener<PullViewModel> callback) {
        mCallback = callback;
        mPullRepository.requestRepositoryList(owner, repo, new RequestPullCallback());
    }

    private void processResult(List<Pull> pullList) {
        int opened = 0;
        int closed = 0;
        for (Pull pull : pullList) {
            if (pull.isClosed()) {
                closed++;
            } else {
                opened++;
            }
        }
        mCallback.onServiceSuccess(new PullViewModel(pullList, opened, closed));
    }

    private class RequestPullCallback extends ServiceListener<List<Pull>> {

        @Override
        public void onServiceSuccess(List<Pull> pullList) {
            processResult(pullList);
        }

        @Override
        public void onServiceError(OperationError error) {
            mCallback.onServiceError(error);
        }
    }
}
