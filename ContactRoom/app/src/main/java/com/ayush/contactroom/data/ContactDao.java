package com.ayush.contactroom.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ayush.contactroom.model.Contact;
import java.util.List;
@Dao
public interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Contact contact);
    @Query("DELETE FROM contact_table")
    void deleteAll();
    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    LiveData<List<Contact>> getAllContacts();
    @Update
    void update(Contact contact);
    @Delete
    void delete(Contact contact);
    @Query("Select * from contact_table where contact_table.id==:id")
    LiveData<Contact> get(int id);
}
