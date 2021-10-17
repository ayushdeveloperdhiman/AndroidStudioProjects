package com.ayush.bodymassindexcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
EditText height,weight;
Button calculate;
String result;
Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate=findViewById(R.id.buttonCalculate);
        height=findViewById(R.id.editTextHeight);
        weight=findViewById(R.id.editTextWeight);
        toolBar=findViewById(R.id.myToolbar);
        setSupportActionBar(toolBar);
        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                if(!height.getText().toString().equals("")&&!weight.getText().toString().equals("")){
                    double bmi=Double.parseDouble(weight.getText().toString())/(Double.parseDouble(height.getText().toString())*Double.parseDouble(height.getText().toString()));
                    if(bmi<=18.5){
                        result="Under Weight";
                    }else if(bmi>18.5&&bmi<=24.9){
                        result="Normal Weight";
                    }else if(bmi>24.9&&bmi<=29.9){
                        result="Over Weight";
                    }else{
                        result="Obesity";
                    }
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogStyle);
                    alertDialog.setTitle("BMI").setMessage("BMI = "+bmi+" Kg/m2.\n"+result)
                            .setIcon(R.drawable.bmi)
                            .setPositiveButtonIcon(getDrawable(android.R.drawable.ic_delete))
                            .setCancelable(false).show();
                    alertDialog.create();
                }else{
                    Toast.makeText(getApplicationContext(),"Enter all fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this,R.style.AlertDialogStyle);
        alertDialog.setTitle("Quit").setMessage("Are you sure to exit?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setIcon(R.drawable.download)
                .setCancelable(false).show();
        alertDialog.create();
    }

}