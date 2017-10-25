package com.app.desafio_mobile_android.presentation.home.repositorielist;

import android.content.Context;

import com.app.desafio_mobile_android.business.RepositorieBusiness;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.intrastructure.util.ServiceListener;
import com.app.desafio_mobile_android.service.model.repositorie.Repositorie;
import com.app.desafio_mobile_android.service.model.repositorie.RepositorieItem;

import java.util.List;

public class RepositorieListPresenter implements RepositorieListContract.Presenter {
    private final static int FIRST_PAGE_REPOSITORIE = 1;

    private RepositorieListContract.View mView;
    private RepositorieBusiness mRepositorieBusiness;
    private int mPageRequest;
    private RepositorieListAdapter mAdapter;
    private List<RepositorieItem> mRepositorieItemList;
    private Context mContext;

    public RepositorieListPresenter(Context context, RepositorieListContract.View view) {
        this.mView = view;
        mContext = context;
        mRepositorieBusiness = new RepositorieBusiness(mContext);
        mPageRequest = FIRST_PAGE_REPOSITORIE;
    }

    @Override
    public void start() {
        callService();
    }

    @Override
    public void callService() {
        mView.setLoading(true);
        mRepositorieBusiness.callServiceRepositorie(mPageRequest, new RequestRepositoriesCallback());
    }

    @Override
    public void refreshList() {
        mPageRequest += 1;
        callService();
    }

    public class RequestRepositoriesCallback extends ServiceListener<Repositorie> {

        @Override
        public void onServiceSuccess(Repositorie repositorie) {
            mView.setLoading(false);
            mView.updatePageSize(repositorie.getItems().size());
            if (mAdapter == null) {
                configAdapter(repositorie.getItems());
            } else {
                notifyMoreItens(repositorie.getItems());
            }
        }

        @Override
        public void onServiceError(OperationError error) {
            mView.setLoading(false);
            mView.showError(error);
        }

        private void configAdapter(List<RepositorieItem> items) {
            mRepositorieItemList = items;
            mAdapter = new RepositorieListAdapter(mContext, mRepositorieItemList, new RepositorieCallback());
            mView.updateList(mAdapter);
        }

        private void notifyMoreItens(List<RepositorieItem> items) {
            mAdapter.addAll(items);
        }
    }


    public class RepositorieCallback implements RepositorieListListener {

        @Override
        public void onItemSelected(int position) {
            RepositorieItem repositorieItem = mRepositorieItemList.get(position);
            mView.showPullRequest(repositorieItem.getOwner().getLogin(),
                    repositorieItem.getName());
        }
    }

    interface RepositorieListListener {
        void onItemSelected(int position);
    }
}
