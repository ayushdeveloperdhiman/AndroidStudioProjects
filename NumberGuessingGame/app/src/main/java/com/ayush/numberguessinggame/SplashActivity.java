package com.ayush.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
private ImageView imageView;
private TextView textView;
private Animation imageAnimation,textAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView=findViewById(R.id.textView2);
        imageView=findViewById(R.id.imageView);
        imageAnimation= AnimationUtils.loadAnimation(this,R.anim.image_animation);
        textAnimation=AnimationUtils.loadAnimation(this,R.anim.text_animation);
        imageView.setAnimation(imageAnimation);
        textView.setAnimation(textAnimation);
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }.start();
    }
}