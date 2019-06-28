package com.peopleinteractivetest.ui.splash.core.view;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.peopleinteractivetest.R;
import com.peopleinteractivetest.databinding.ActivitySplahBinding;
import com.peopleinteractivetest.utils.NavigatorUtils;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplahBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set ContentView with DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splah);

        setAnimation();
    }

    private void setAnimation() {
        scaleView(binding.ivLogo, 0f, 0.6f);
    }

    public void scaleView(final View v, float startScale, float endScale) {
        // Load the animation like this
        Animation left_to_right = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.left_to_right);

        v.startAnimation(left_to_right);

        left_to_right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                NavigatorUtils.gotoUserListActivity(SplashActivity.this);
                NavigatorUtils.exitActivity(SplashActivity.this);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
