package com.ayush.contactroom.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ayush.contactroom.data.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    private static ContactRepository repository;
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
    public static void delete(Contact contact){
        repository.delete(contact);
    }
    public LiveData<Contact> get(int id){
        return repository.get(id);
    }
    public static void update(Contact contact){
        repository.update(contact);
    }
}
