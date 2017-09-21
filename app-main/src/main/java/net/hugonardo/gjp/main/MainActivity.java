package net.hugonardo.gjp.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import net.hugonardo.gjp.R;
import net.hugonardo.gjp.databinding.MainActivityBinding;
import net.hugonardo.gjp.tools.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private MainActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        mBinding.setHandler(this);
        setSupportActionBar(mBinding.toolbar);
    }

    public void onClickFab(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
