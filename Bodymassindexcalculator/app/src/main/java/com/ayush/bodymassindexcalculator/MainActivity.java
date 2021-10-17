package com.ayush.bodymassindexcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText height,weight;
Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate=findViewById(R.id.buttonCalculate);
        height=findViewById(R.id.editTextHeight);
        weight=findViewById(R.id.editTextWeight);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!height.getText().toString().equals("")&&!weight.getText().toString().equals("")){
                    double bmi=Double.parseDouble(weight.getText().toString())/(Double.parseDouble(height.getText().toString())*Double.parseDouble(height.getText().toString()));
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogStyle);
                    alertDialog.setTitle("BMI").setMessage("BMI = "+bmi+" Kg/m2.")
                            .setIcon(R.drawable.bmi)
                            .setCancelable(true).show();
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