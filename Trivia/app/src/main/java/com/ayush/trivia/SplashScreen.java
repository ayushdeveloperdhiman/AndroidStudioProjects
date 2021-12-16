package com.ayush.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
ImageView imageView;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);


        final Animation fade_in=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        final Animation blink=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);


        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);

        textView.setAnimation(blink);
        imageView.setAnimation(fade_in);


        new CountDownTimer(5000,1000){
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED||connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED){
                    Intent i=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(SplashScreen.this,"No network",Toast.LENGTH_SHORT).show();
                }
            }
        }.start();

    }
}