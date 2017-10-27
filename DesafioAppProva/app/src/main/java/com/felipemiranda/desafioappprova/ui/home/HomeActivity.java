package com.felipemiranda.desafioappprova.ui.home;

import android.support.annotation.AnimRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.felipemiranda.desafioappprova.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle(getString(R.string.github_java));

        ButterKnife.bind(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit();
    }

    public void showLoading(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading(){
        progressBar.setVisibility(View.GONE);
    }

    public void addFragmentDefaultAnim(Fragment fragment, String tag, String tagBackStack) {
        addFragment(fragment, tag, R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right, tagBackStack);
    }

    private void addFragment(Fragment fragment, String tag,
                             @AnimRes int enter, @AnimRes int exit,
                             @AnimRes int popEnter, @AnimRes int popExit,
                             String tagBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        transaction.setCustomAnimations(enter, exit, popEnter, popExit);
        transaction.replace(R.id.content, fragment, tag);
        transaction.addToBackStack(tagBackStack);
        transaction.commit();
    }
}
