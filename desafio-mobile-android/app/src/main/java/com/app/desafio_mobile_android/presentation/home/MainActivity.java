package com.app.desafio_mobile_android.presentation.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.app.desafio_mobile_android.R;
import com.app.desafio_mobile_android.intrastructure.Constants;
import com.app.desafio_mobile_android.intrastructure.util.ActivityUtils;
import com.app.desafio_mobile_android.presentation.base.BaseActivity;
import com.app.desafio_mobile_android.presentation.home.repositorielist.RepositorieListFragment;
import com.app.desafio_mobile_android.presentation.home.repositorielist.RepositorieListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        configDrawer();
        showHome();
    }

    private void configDrawer() {
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            showHome();
        } else if (id == R.id.nav_about) {
            showAbout();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showHome() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        RepositorieListFragment fragment = (RepositorieListFragment) fragmentManager.findFragmentById(R.id.framelayout_main);
        if(fragment == null) {
            fragment = RepositorieListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(fragmentManager, fragment, R.id.framelayout_main);
        }

        fragment.setPresenter(new RepositorieListPresenter(this, fragment));
    }

    private void showAbout() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.ABOUT_URL)));
    }
}
