package com.ayush.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ayush.contactmanager.data.DatabaseHandler;
import com.ayush.contactmanager.model.Contact;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        contactArrayList=new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
       /*db.addContact(new Contact("Ayush Dhiman","7018515995"));
        db.addContact(new Contact("Raja","658412264"));
        db.addContact(new Contact("Ayush","41551"));
        db.addContact(new Contact("Anshu","701895"));
        db.addContact(new Contact("Arvind","7015"));
        db.addContact(new Contact("Sumit","44487"));
        db.addContact(new Contact("Ram","747484"));
        db.addContact(new Contact("Don","7018"));
        db.addContact(new Contact("Ayu","185995"));
        db.addContact(new Contact("Dhiman","7155"));
        Log.d("Count", "" + db.getContactCount());*/


        List<Contact> contactList = db.contacts();
        for (Contact contact : contactList) {
            Log.d("AllContact", "" + contact.getName());
            contactArrayList.add(contact.getName());
        }
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contactArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("TAG", "onItemClick: "+i);
            }
        });
    }
}