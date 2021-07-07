package com.ayush.makeitrain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.icu.util.Currency;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private TextView textViewMoney;
private int moneyCounter=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewMoney=findViewById(R.id.textViewMoneyValue);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setCurrency(Currency.getInstance(Locale.CANADA));
        moneyCounter += 1000;
        textViewMoney.setText(numberFormat.format(moneyCounter));
        switch (moneyCounter){
            case 20000:
                textViewMoney.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.purple_700));
                break;
            case 30000:
                textViewMoney.setTextColor(Color.MAGENTA);
                break;
            case 40000:
                textViewMoney.setTextColor(Color.RED);
                break;
            default:
                textViewMoney.setTextColor(Color.WHITE);
        }
    }

    public void showInfo(View view) {
        //Toast.makeText(MainActivity.this,R.string.app_info,Toast.LENGTH_SHORT).show();
        Snackbar.make(textViewMoney,R.string.app_info,Snackbar.LENGTH_SHORT).setAction("more", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("snack", "onClick: SnackBar");
            }
        }).show();
    }
}