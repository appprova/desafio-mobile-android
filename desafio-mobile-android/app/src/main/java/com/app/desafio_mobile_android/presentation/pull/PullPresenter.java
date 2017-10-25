package com.app.desafio_mobile_android.presentation.pull;

import android.content.Context;

import com.app.desafio_mobile_android.business.PullBusiness;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.intrastructure.util.ServiceListener;
import com.app.desafio_mobile_android.service.model.pull.Pull;

import java.util.List;

public class PullPresenter implements PullContract.Presenter {
    private String mOwnerName;
    private String mRepoName;
    private Context mContext;
    private PullContract.View mView;
    private PullBusiness mPullBusiness;
    private RequestPullCallback mRequestPullCallback;
    private List<Pull> mPullList;

    public PullPresenter(Context context, String ownerName, String repoName, PullContract.View view) {
        this.mOwnerName = ownerName;
        this.mRepoName = repoName;
        this.mContext = context;
        this.mView = view;
        mPullBusiness = new PullBusiness(context);
        mRequestPullCallback = new RequestPullCallback();
    }

    @Override
    public void start() {
        callPullListService();
    }

    @Override
    public void callPullListService() {
        mView.setLoading(true);
        mPullBusiness.callPullList(mOwnerName, mRepoName, mRequestPullCallback);
    }

    private class RequestPullCallback extends ServiceListener<PullViewModel> {

        @Override
        public void onServiceSuccess(PullViewModel pullViewModel) {
            mPullList = pullViewModel.getPullList();
            mView.showHeader(pullViewModel.getClosed(), pullViewModel.getOpened());
            mView.setLoading(false);
            mView.updateList(new PullAdapter(mView.getContext(), mPullList, new OnPullListCallback()));
        }

        @Override
        public void onServiceError(OperationError error) {
            mView.setLoading(false);
            mView.showError(error);
        }
    }

    private class OnPullListCallback implements PullListListener {

        @Override
        public void onItemClick(int position) {
            mView.showPage(mPullList.get(position).getUrl());
        }
    }

    interface PullListListener {
        void onItemClick(int position);
    }
}
