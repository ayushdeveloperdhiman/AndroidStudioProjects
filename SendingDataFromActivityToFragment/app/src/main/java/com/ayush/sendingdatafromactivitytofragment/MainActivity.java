package com.ayush.sendingdatafromactivitytofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText weight,height;
Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        MyFirstFragment myFirstFragment=new MyFirstFragment();
        weight=findViewById(R.id.editTextWeight);
        height=findViewById(R.id.editTextHeight);
        calculate=findViewById(R.id.buttonCalculate);
        Bundle bundle=new Bundle();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putInt("weight",Integer.valueOf(weight.getText().toString()));
                bundle.putInt("height",Integer.valueOf(height.getText().toString()));
                myFirstFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.frame,myFirstFragment);
                fragmentTransaction.commit();
            }
        });
    }
}