package com.ayush.kidsmathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
TextView result;
Button exit,playAgain;
int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=findViewById(R.id.textViewResult);
        exit=findViewById(R.id.buttonExit);
        playAgain=findViewById(R.id.buttonPlayAgain);
        Intent i=getIntent();
        score=i.getIntExtra("score",0);
        String userScore=String.valueOf(score);
        result.setText("You Score "+userScore);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Result.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}