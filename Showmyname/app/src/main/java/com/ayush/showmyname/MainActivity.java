package com.ayush.showmyname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button showNameButton;
private TextView textView;
private EditText editTextName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNameButton=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        editTextName=findViewById(R.id.editTextName);
        showNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editTextName.getText().toString());
            }
        });
    }
}