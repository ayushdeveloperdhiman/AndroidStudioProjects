package com.ayush.sendingdatafromactivitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView textViewName,textViewEmail,textViewPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewName=findViewById(R.id.textViewName);
        textViewEmail=findViewById(R.id.textViewEmail);
        textViewPhoneNumber=findViewById(R.id.textViewPhoneNumber);
        Intent i=getIntent();
        textViewName.setText(""+i.getStringExtra("name"));
        textViewEmail.setText(""+i.getStringExtra("email"));
        textViewPhoneNumber.setText(""+i.getLongExtra("phoneNumber",0));
    }
}