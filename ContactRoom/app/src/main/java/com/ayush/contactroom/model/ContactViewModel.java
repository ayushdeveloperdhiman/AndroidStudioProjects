package com.ayush.contactroom.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ayush.contactroom.data.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    public static ContactRepository repository;
    public LiveData<List<Contact>> liveData;
    public ContactViewModel(@NonNull Application application) {
        super(application);
        repository=new ContactRepository(application);
        liveData=repository.getAllContacts();
    }
    public LiveData<List<Contact>> getAllContacts(){
        return liveData;
    }
    public static void insert(Contact contact){repository.insert(contact);}
}
