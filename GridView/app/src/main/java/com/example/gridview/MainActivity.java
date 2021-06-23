package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gridView;
ArrayList<String> name=new ArrayList<>();
ArrayList<Integer> image=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        fillArray();
        GridAdapter gridAdapter=new GridAdapter(this,name,image);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You selected "+name.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void fillArray(){
        name.add("Bird");
        name.add("Cat");
        name.add("Chicken");
        name.add("Dog");
        name.add("Fish");
        name.add("Monkey");
        name.add("Rabbit");
        name.add("Sheep");
        name.add("Lion");

        image.add(R.drawable.bird);
        image.add(R.drawable.cat);
        image.add(R.drawable.chicken);
        image.add(R.drawable.dog);
        image.add(R.drawable.fish);
        image.add(R.drawable.monkey);
        image.add(R.drawable.rabbit);
        image.add(R.drawable.sheep);
        image.add(R.drawable.lion);

    }
}