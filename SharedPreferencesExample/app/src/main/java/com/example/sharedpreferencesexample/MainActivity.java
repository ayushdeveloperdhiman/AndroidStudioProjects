package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText userName,userMessage;
Button counter;
CheckBox remember;
String name;
String message;
boolean isChecked;
int count=0;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userMessage=findViewById(R.id.editTextTextMultiLine);
        userName=findViewById(R.id.editTextTextPersonName);
        counter=findViewById(R.id.button);
        remember=findViewById(R.id.checkBox);
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                counter.setText(""+count);
            }
        });
        retrieveData();

    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();

    }
    public void saveData(){
        sharedPreferences=getSharedPreferences("s", Context.MODE_PRIVATE);
        name=userName.getText().toString();
        message=userMessage.getText().toString();
        if(remember.isChecked()){
            isChecked=true;
        }else{
            isChecked=false;
        }
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("key name",name);
        editor.putString("key message",message);
        editor.putBoolean("key remember",isChecked);
        editor.putInt("key count",count);
        editor.commit();
        Toast.makeText(getApplicationContext(),"Data saved",Toast.LENGTH_LONG).show();
    }
    public void retrieveData(){
        sharedPreferences=getSharedPreferences("s",Context.MODE_PRIVATE);
        name=sharedPreferences.getString("key name",null);
        message=sharedPreferences.getString("key message",null);
        count=sharedPreferences.getInt("key count",0);
        isChecked=sharedPreferences.getBoolean("key remember",false);
        userName.setText(name);
        userMessage.setText(message);
        counter.setText(""+count);
        if(isChecked){
            remember.setChecked(true);
        }else{
            remember.setChecked(false);
        }

    }
}