package com.example.razzon.login_form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
ImageView imageView;
    Animation translatex,translatey,transx2,transy2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        imageView= (ImageView) findViewById(R.id.move);

        translatex= AnimationUtils.loadAnimation(this,R.anim.translatex);

        translatey=AnimationUtils.loadAnimation(this,R.anim.translatey);
        transx2=AnimationUtils.loadAnimation(this,R.anim.transx2);
        transy2=AnimationUtils.loadAnimation(this,R.anim.transy2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(translatex);
            }
        });

        //end of 1
        translatex.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(translatey);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //end of 2
        translatex.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(translatey);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //end of 3
        translatey.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(transx2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        transx2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(transy2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
