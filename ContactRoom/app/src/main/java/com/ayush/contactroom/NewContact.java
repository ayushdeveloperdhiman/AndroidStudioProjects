package com.ayush.contactroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayush.contactroom.data.ContactDao;
import com.ayush.contactroom.data.ContactRepository;
import com.ayush.contactroom.model.Contact;
import com.ayush.contactroom.model.ContactViewModel;
import com.google.android.material.snackbar.Snackbar;

public class NewContact extends AppCompatActivity {
    public static final String NAME_REPLY = "name_reply";
    public static final String OCCUPATION_REPLY = "occupation_reply";
    private EditText enterName, enterOccupation;
    private Button save,delete,update;
    private ContactViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        enterName = findViewById(R.id.enter_name);
        enterOccupation = findViewById(R.id.enter_occupation);
        save = findViewById(R.id.button_save);
        delete=findViewById(R.id.button_delete);
        update=findViewById(R.id.button_update);
        delete.setVisibility(View.GONE);
        update.setVisibility(View.GONE);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(NewContact.this.getApplication()).create(ContactViewModel.class);

        save.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (!TextUtils.isEmpty(enterName.getText()) && !TextUtils.isEmpty(enterOccupation.getText())) {
                String name = enterName.getText().toString();
                String occupation = enterOccupation.getText().toString();
                replyIntent.putExtra(NAME_REPLY,name);
                replyIntent.putExtra(OCCUPATION_REPLY,occupation);
                setResult(RESULT_OK,replyIntent);
            } else {
                setResult(RESULT_CANCELED,replyIntent);
            }
            finish();
        });
        Bundle data=getIntent().getExtras();
        if(data != null){
            save.setVisibility(View.GONE);
            delete.setVisibility(View.VISIBLE);
            update.setVisibility(View.VISIBLE);
            int id=data.getInt(MainActivity.CONTACT_ID);

            viewModel.get(id).observe(this, new Observer<Contact>() {
                @Override
                public void onChanged(Contact contact) {
                    if(contact!=null){
                    enterName.setText(contact.getName());
                    enterOccupation.setText(contact.getOccupation());
                }}
            });
        }
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=enterName.getText().toString();
                String occupation=enterOccupation.getText().toString();
                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(occupation)){
                    int id=data.getInt(MainActivity.CONTACT_ID);
                    Contact contact=new Contact();
                    contact.setId(id);
                    contact.setName(name);
                    contact.setOccupation(occupation);
                    ContactViewModel.update(contact);
                    finish();
                }else {
                    Snackbar.make(enterName,"Do not left any field empty",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=enterName.getText().toString();
                String occupation=enterOccupation.getText().toString();
                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(occupation)){
                    int id=data.getInt(MainActivity.CONTACT_ID);
                    Contact contact=new Contact();
                    contact.setId(id);
                    contact.setName(name);
                    contact.setOccupation(occupation);
                    ContactViewModel.delete(contact);
                    finish();
                }else {
                    Snackbar.make(enterName,"Do not left any field empty",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}