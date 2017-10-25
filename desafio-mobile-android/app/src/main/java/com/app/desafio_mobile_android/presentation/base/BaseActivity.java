package com.app.desafio_mobile_android.presentation.base;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.error.OperationError;
import com.app.desafio_mobile_android.presentation.dialog.ErrorDialogFragment;
import com.app.desafio_mobile_android.presentation.dialog.ProgressDialogFragment;

public class BaseActivity extends AppCompatActivity {
    private static final String FRAGMENT_ALERT_ID = "FRAGMENT_ALERT_ID";
    private ProgressDialogFragment mProgressDialog;
    private ErrorDialogFragment errorDialog;

    public void showError(OperationError error, ErrorDialogFragment.MyOnErrorClick myOnErrorClick) {
        errorDialog = ErrorDialogFragment.newInstance(getErrorMsg(error));
        errorDialog.setListener(myOnErrorClick);
        errorDialog.show(getSupportFragmentManager(), FRAGMENT_ALERT_ID);
    }

    private String getErrorMsg(OperationError error) {

        switch (error.getErrorType()) {
            case NETWORK_ERROR:
                return getString(R.string.default_network_error);
            case SERVICE_ERROR:
                return getString(R.string.service_error);
            case GENERIC_ERROR:
            default:
                return getString(R.string.generic_error);
        }
    }

    public void showProgress() {
        mProgressDialog = new ProgressDialogFragment();
        mProgressDialog.show(getSupportFragmentManager(), FRAGMENT_ALERT_ID);
    }


    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    protected void initToolbar(Toolbar toolbar, String title, boolean hasHomeAsUpIndicator) {
        setTitle(title);
        setSupportActionBar(toolbar);

        if (hasHomeAsUpIndicator) {
            configureToolbarHomeAsUpIndicator();
        }
    }

    protected void configureToolbarHomeAsUpIndicator() {
        ActionBar toolbar = getSupportActionBar();

        if (toolbar != null) {
            toolbar.setHomeButtonEnabled(true);
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setDisplayShowHomeEnabled(true);
        }
    }
}
