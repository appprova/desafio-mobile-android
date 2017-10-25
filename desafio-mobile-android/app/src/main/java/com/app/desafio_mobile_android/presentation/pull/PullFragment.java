package com.app.desafio_mobile_android.presentation.pull;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.presentation.base.BaseFragment;
import com.app.desafio_mobile_android.presentation.dialog.ErrorDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PullFragment extends BaseFragment implements PullContract.View {
    @BindView(R.id.recyclerview_pull)
    RecyclerView mRecyclerview;
    @BindView(R.id.textview_pull_header)
    TextView mTextviewHeader;

    private Unbinder unbinder;
    private PullContract.Presenter mPresenter;
    private PullActivity mActivity;


    public static PullFragment newInstance() {

        Bundle args = new Bundle();

        PullFragment fragment = new PullFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (PullActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pull, container, false);
        unbinder = ButterKnife.bind(this, view);
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
    public void setPresenter(@NonNull PullContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(OperationError error) {
        mActivity.showError(error, new ErroClickListener());
    }

    @Override
    public void updateList(PullAdapter adapter) {
        mRecyclerview.setAdapter(adapter);
    }

    @Override
    public void setLoading(boolean isLoading) {
        if (isLoading) {
            mActivity.showProgress();
        } else {
            mActivity.hideProgress();
        }
    }

    @Override
    public void showPage(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    @Override
    public void showHeader(int closed, int opened) {
        String header = String.format(getString(R.string.pull_header), opened, closed);
        Spannable wordtoSpan = new SpannableString(header);
        wordtoSpan.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mActivity, R.color.yellow_info)),
                0, header.indexOf("/"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextviewHeader.setText(wordtoSpan);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        mRecyclerview.setLayoutManager(linearLayoutManager);
    }

    private class ErroClickListener implements ErrorDialogFragment.MyOnErrorClick {

        @Override
        public void clickTryAgain() {
            mActivity.hideProgress();
            mPresenter.callPullListService();
        }
    }
}
