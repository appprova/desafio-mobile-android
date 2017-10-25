package com.app.desafio_mobile_android.presentation.pull;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.util.ActivityUtils;
import com.app.desafio_mobile_android.presentation.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PullActivity extends BaseActivity {
    private final static String KEY_OWNER = "KEY_OWNER";
    private final static String KEY_REPO = "KEY_REPO";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        ButterKnife.bind(this);

        inflateFragment();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void inflateFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        PullFragment fragment = (PullFragment) fragmentManager.findFragmentById(R.id.framelayout_pull);
        if (fragment == null) {
            fragment = PullFragment.newInstance();
            ActivityUtils.addFragmentToActivity(fragmentManager, fragment, R.id.framelayout_pull);
        }

        String owner = getIntent().getExtras().getString(KEY_OWNER);
        String repo = getIntent().getExtras().getString(KEY_REPO);

        initToolbar(mToolbar, repo, true);
        fragment.setPresenter(new PullPresenter(this, owner, repo, fragment));
    }

    public static Intent getLaunchIntent(Context context, String owner, String repo) {
        Intent intent = new Intent(context, PullActivity.class);
        intent.putExtra(KEY_OWNER, owner);
        intent.putExtra(KEY_REPO, repo);
        return intent;
    }
}
