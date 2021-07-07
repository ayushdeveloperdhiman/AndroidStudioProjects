package com.ayush.sendingdatafromactivitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText editTextName,editTextEmail,editTextPhoneNumber;
Button buttonSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName=findViewById(R.id.editTextName);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPhoneNumber=findViewById(R.id.editTextPhoneNumber);
        buttonSignUp=findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);

                i.putExtra("name",editTextName.getText().toString());
                i.putExtra("email",editTextEmail.getText().toString());
                i.putExtra("phoneNumber",Long.valueOf(editTextPhoneNumber.getText().toString()));
                startActivity(i);
            }
        });
    }
}