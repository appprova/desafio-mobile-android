package com.app.desafio_mobile_android.presentation.home.repositorielist;

import com.app.desafio_mobile_android.presentation.base.BasePresenter;
import com.app.desafio_mobile_android.presentation.base.BaseView;

public class RepositorieListContract {

    interface View extends BaseView<RepositorieListContract.Presenter> {
        void updateList(RepositorieListAdapter adapter);

        void updatePageSize(int pageSize);

        void showPullRequest(String owner, String repo);
    }

    interface Presenter extends BasePresenter {
        void callService();
        void refreshList();
    }
}
