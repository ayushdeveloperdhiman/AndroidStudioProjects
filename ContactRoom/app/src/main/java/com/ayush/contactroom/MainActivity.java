package com.ayush.contactroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

import com.ayush.contactroom.adapter.RecyclerViewAdapter;
import com.ayush.contactroom.model.Contact;
import com.ayush.contactroom.model.ContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnContactClickListener {
    private static final int NEW_ACTIVITY_REQUEST_CODE = 1;
    private static final String TAG ="Clicked" ;
    private ContactViewModel viewModel;
    public static final String CONTACT_ID="contact_id";
    private FloatingActionButton add;
    private RecyclerViewAdapter adapter;
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
            adapter=new RecyclerViewAdapter(this,contacts,this);
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

    @Override
    public void onContactClick(int position) {
        Contact contact= Objects.requireNonNull(viewModel.liveData.getValue()).get(position);
        Intent intent=new Intent(MainActivity.this,NewContact.class);
        intent.putExtra(CONTACT_ID,contact.getId());
        startActivity(intent);
    }
}