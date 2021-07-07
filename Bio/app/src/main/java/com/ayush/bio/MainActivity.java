package com.ayush.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.ayush.bio.data.Bio;
import com.ayush.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Bio bio=new Bio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        bio.setName("Ayush Dhiman");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(view -> {
            if(!binding.enterHobbies.getText().toString().isEmpty()){
                bio.setHobbies(String.format("Hobbies: %s", binding.enterHobbies.getText().toString()));
                binding.setBio(bio);
                binding.textviewHobbies.setVisibility(View.VISIBLE);
                binding.invalidateAll();
                //hide keyboard
                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }

        });
    }
}