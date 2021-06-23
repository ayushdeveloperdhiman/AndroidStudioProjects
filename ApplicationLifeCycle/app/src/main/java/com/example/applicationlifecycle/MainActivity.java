package com.example.applicationlifecycle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
Button button1;
Button button2;
int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText(""+counter);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i);
            }
        });
        Log.d("message","First activity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message","First activity onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","First activity nPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","First activity onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","First activity onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","First activity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("message","First activity onRestart");
    }
}