package com.ayush.contactroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ayush.contactroom.adapter.RecyclerViewAdapter;
import com.ayush.contactroom.model.Contact;
import com.ayush.contactroom.model.ContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_ACTIVITY_REQUEST_CODE = 1;
    private ContactViewModel viewModel;
    private FloatingActionButton add;
    private RecyclerViewAdapter adapter;
    private LiveData<List<Contact>> contactList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add = findViewById(R.id.button_add);

        viewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.
                this.getApplication())
                .create(ContactViewModel.class);

        viewModel.getAllContacts().observe(this, contacts -> {
            adapter=new RecyclerViewAdapter(this,contacts);
            recyclerView.setAdapter(adapter);
                });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewContact.class);
                startActivityForResult(i, NEW_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            assert data != null;
            Contact contact = new Contact(data.getStringExtra(NewContact.NAME_REPLY), data.getStringExtra(NewContact.OCCUPATION_REPLY));
            ContactViewModel.insert(contact);
        }
    }
}