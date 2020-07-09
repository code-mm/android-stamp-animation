package com.ms.stamp_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ImageView imageView;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        buttonStart = findViewById(R.id.buttonStart);

//        RotateAnimation animation = new RotateAnimation(0, 360, getContentScene().getW.getWidth()/2, imageView.getHeight()/2);
//        animation.setDuration(1000);
//        animation.setFillAfter(true);
//        imageView.startAnimation(animation);

        final AnimatorSet animatorSetsuofang = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 3f, 0.5f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 3f, 0.5f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 180f, 360f);
        // 动画时间
        animatorSetsuofang.setDuration(600);
        animatorSetsuofang.setInterpolator(new DecelerateInterpolator());
        animatorSetsuofang.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSetsuofang.play(rotate);
        animatorSetsuofang.start();


        animatorSetsuofang.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                Log.e(TAG, "onAnimationCancel: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.e(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                Log.e(TAG, "onAnimationRepeat: ");
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.e(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
                Log.e(TAG, "onAnimationPause: ");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
                Log.e(TAG, "onAnimationResume: ");
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animatorSetsuofang.start();
            }
        });
    }
}