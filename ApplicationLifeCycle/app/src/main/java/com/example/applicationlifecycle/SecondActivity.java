package com.example.applicationlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        Log.d("message","Second activity onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message","Second activity onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","Second activity nPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","Second activity onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","Second activity onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","Second activity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("message","Second activity onRestart");
    }
}