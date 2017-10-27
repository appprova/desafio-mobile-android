package com.felipemiranda.desafioappprova.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.felipemiranda.desafioappprova.R;
import com.felipemiranda.desafioappprova.model.response.GenericErrorResponse;
import com.felipemiranda.desafioappprova.ui.home.HomeActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by felipemiranda on 26/10/17.
 */

public abstract class BaseFragment extends Fragment implements BaseLoadingView {

    public abstract BaseLoadingPresenter getPresenter();

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = onCreateViewBinder(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        getPresenter().bindView(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }

    public void setFragmentContent(Fragment fragment, String tagBackStack) {

        ((HomeActivity) getActivity()).addFragmentDefaultAnim(fragment, fragment.getClass().getName(), tagBackStack);
    }

    @Override
    public void showLoading() {
        ((HomeActivity) getActivity()).showLoading();
    }

    @Override
    public void hideLoading() {
        ((HomeActivity) getActivity()).hideLoading();
    }

    @Override
    public void notifyError(GenericErrorResponse error) {
        if (error != null) {
            Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), getString(R.string.sorry_unable_to_process), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void retryLastRequest() {
        getPresenter().retryLastRequest();
    }
}
