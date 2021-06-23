package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> countryName = new ArrayList<>();
    private ArrayList<String> countryNameDetails = new ArrayList<>();
    private ArrayList<Integer> imagelist = new ArrayList<>();
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryName.add("India");
        countryName.add("America");
        countryName.add("Spain");
        countryNameDetails.add("India Flag");
        countryNameDetails.add("America Flag");
        countryNameDetails.add("Spain Flag");
        imagelist.add(R.drawable.india);
        imagelist.add(R.drawable.america);
        imagelist.add(R.drawable.spain);
adapter=new RecyclerAdapter(countryName,countryNameDetails,imagelist,this);
recyclerView.setAdapter(adapter);
    }
}