package com.ayush.contactroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ayush.contactroom.model.Contact;
import com.ayush.contactroom.model.ContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_ACTIVITY_REQUEST_CODE = 1;
    private ContactViewModel viewModel;
private TextView textView;
private FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        add=findViewById(R.id.button_add);
        StringBuilder builder=new StringBuilder();
        viewModel=new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(ContactViewModel.class);
        viewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                for(Contact contact:contacts){
                    builder.append(" - ").append(contact.getName()).append(" ").append(contact.getOccupation());
                }
                textView.setText(builder.toString());

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,NewContact.class);
                startActivityForResult(i,NEW_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==NEW_ACTIVITY_REQUEST_CODE && resultCode==RESULT_OK){
            assert data!=null;
            Contact contact =new Contact(data.getStringExtra(NewContact.NAME_REPLY),data.getStringExtra(NewContact.OCCUPATION_REPLY));
            ContactViewModel.insert(contact);
        }
    }
}