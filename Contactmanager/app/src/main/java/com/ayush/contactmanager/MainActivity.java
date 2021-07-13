package com.ayush.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ayush.contactmanager.data.DatabaseHandler;
import com.ayush.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db=new DatabaseHandler(MainActivity.this);
       // Contact a=new Contact();

        //a.setName("Ayush");
        //a.setPhoneNumber("701");
       // db.addContact(a);
        Log.d("Count",""+db.getContactCount());

        //db.addContact(a);
        //Contact c=db.getContact(1);
        //c.setName("a");
        //c.setPhoneNumber("1");
        //db.updateContact(c);
        //a=db.getContact(1);
       // db.deleteContact(a);

        List<Contact> contactList=db.contacts();
        for(Contact contact:contactList){
            Log.d("AllContact",""+contact.getId());
        }
    }
}