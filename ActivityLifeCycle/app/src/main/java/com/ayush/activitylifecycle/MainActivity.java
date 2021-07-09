package com.ayush.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button guessButton;
private EditText guessEditText;
private final int REQUEST_CODE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessButton=findViewById(R.id.guess_button);
        guessEditText=findViewById(R.id.guessText);

        //Toast.makeText(this,"onCreate method called",Toast.LENGTH_LONG).show();
        Log.d("Cycle","onCreate");
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!guessEditText.getText().toString().isEmpty()){
                    Intent intent=new Intent(MainActivity.this,ShowGuess.class);
                    intent.putExtra("guess",guessEditText.getText().toString());
                    startActivityForResult(intent,REQUEST_CODE);
                    //startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Enter Guess First",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            assert data!=null;
            String result=data.getStringExtra("message_back");
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
        }
    }


    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart method called",Toast.LENGTH_LONG).show();
        Log.d("Cycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume method called",Toast.LENGTH_LONG).show();
        Log.d("Cycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause method called",Toast.LENGTH_SHORT).show();
        Log.d("Cycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop method called",Toast.LENGTH_LONG).show();
        Log.d("Cycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy method called",Toast.LENGTH_LONG).show();
        Log.d("Cycle","onDestroy");
    }*/
}