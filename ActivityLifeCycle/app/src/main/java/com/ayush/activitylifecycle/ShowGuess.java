package com.ayush.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
TextView guessTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        guessTextview=findViewById(R.id.received_textView);
        if(getIntent().getStringExtra("guess")!=null) {
            guessTextview.setText(getIntent().getStringExtra("guess"));
        }
        guessTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                intent.putExtra("message_back","From second activity.");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}