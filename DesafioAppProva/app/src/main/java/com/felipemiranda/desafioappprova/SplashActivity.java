package com.felipemiranda.desafioappprova;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.felipemiranda.desafioappprova.ui.home.HomeActivity;
import com.felipemiranda.desafioappprova.utils.Utils;

import butterknife.BindView;

/**
 * Created by felipemiranda on 27/10/17.
 */

public class SplashActivity extends AppCompatActivity {

    private static final long DELAY = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(this::openHomeActivity, DELAY);
    }

    private void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }
}
