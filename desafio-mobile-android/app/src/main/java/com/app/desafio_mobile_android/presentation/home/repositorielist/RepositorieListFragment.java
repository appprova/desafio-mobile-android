package com.app.desafio_mobile_android.presentation.home.repositorielist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.presentation.base.BaseFragment;
import com.app.desafio_mobile_android.presentation.dialog.ErrorDialogFragment;
import com.app.desafio_mobile_android.presentation.home.MainActivity;
import com.app.desafio_mobile_android.presentation.pull.PullActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RepositorieListFragment extends BaseFragment implements RepositorieListContract.View {

    @BindView(R.id.recyclerview_repositorie_list)
    RecyclerView mRecyclerview;
    Unbinder unbinder;
    private MainActivity mMainActivity;
    private RepositorieListContract.Presenter mPresenter;
    private int mPageSize;
    private boolean mIsLoading;
    private ErrorListener mErrorListener;

    public static RepositorieListFragment newInstance() {

        Bundle args = new Bundle();

        RepositorieListFragment fragment = new RepositorieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repositorie_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        mErrorListener = new ErrorListener();
        initRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(@NonNull RepositorieListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(OperationError error) {
        mMainActivity.showError(error, mErrorListener);
    }

    @Override
    public void updateList(RepositorieListAdapter adapter) {
        mRecyclerview.setAdapter(adapter);
    }

    @Override
    public void setLoading(boolean isLoading) {
        mIsLoading = isLoading;
        if (isLoading) {
            mMainActivity.showProgress();
        } else {
            mMainActivity.hideProgress();
        }
    }

    @Override
    public void updatePageSize(int pageSize) {
        mPageSize = pageSize;
    }

    @Override
    public void showPullRequest(String owner, String repo) {
        startActivity(PullActivity.getLaunchIntent(mMainActivity, owner, repo));

    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mMainActivity);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.addOnScrollListener(new RecyclerViewListener(linearLayoutManager));
    }

    public class RecyclerViewListener extends RecyclerView.OnScrollListener {

        LinearLayoutManager mLayoutManager;

        public RecyclerViewListener(LinearLayoutManager linearLayoutManager) {
            this.mLayoutManager = linearLayoutManager;
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            if (!mIsLoading) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= mPageSize) {
                    mPresenter.refreshList();
                }
            }
        }
    }

    private class ErrorListener implements ErrorDialogFragment.MyOnErrorClick {

        @Override
        public void clickTryAgain() {
            mPresenter.callService();
        }
    }
}
