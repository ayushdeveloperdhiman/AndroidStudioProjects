package com.ayush.sendingdatafromfragmentstoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        MyFirstFragment myFirstFragment=new MyFirstFragment();
        fragmentTransaction.add(R.id.linear,myFirstFragment);
        fragmentTransaction.commit();
    }
    public void takeData(String name,String email){
        this.name=findViewById(R.id.textViewName);
        this.email=findViewById(R.id.textViewEmail);
        this.name.setText(name);
        this.email.setText(email);
    }
}