package com.app.desafio_mobile_android.presentation.pull;


import com.app.desafio_mobile_android.presentation.base.BasePresenter;
import com.app.desafio_mobile_android.presentation.base.BaseView;

public class PullContract {

    interface View extends BaseView<PullContract.Presenter> {
        void updateList(PullAdapter adapter);
        void showPage(String url);
        void showHeader(int closed, int opened);
    }

    interface Presenter extends BasePresenter {
        void callPullListService();
    }

}
