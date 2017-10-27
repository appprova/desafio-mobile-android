package com.felipemiranda.desafioappprova.utils;

import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;

/**
 * Created by felipemiranda on 27/10/17.
 */

public class Utils {

    public static void recyclerViewAnimationEntrance(RecyclerView recyclerView) {
        AnimationSet set = new AnimationSet(true);
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        set.addAnimation(animation);

        animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f
        );
        animation.setDuration(500);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(set, 0.1f);
        controller.setInterpolator(new AccelerateInterpolator());
        recyclerView.setLayoutAnimation(controller);
    }

    public static AlphaAnimation alphaAnimation(float fromAlpha, float toAlpha, int duration){
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);

        return alphaAnimation;
    }
}
