package com.ayush.contactroom.util;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ayush.contactroom.data.ContactDao;
import com.ayush.contactroom.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Contact.class},version = 1,exportSchema = false)
public abstract class ContactRoomDatabase extends RoomDatabase {
    private static final int NUMBER_OF_THREADS = 4;
    public abstract ContactDao contactDao();
    private static volatile ContactRoomDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static ContactRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ContactRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContactRoomDatabase.class, "Contact_database")
                            .addCallback(sRoomDataBaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }
    public static final RoomDatabase.Callback sRoomDataBaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                ContactDao contactDao=INSTANCE.contactDao();
                contactDao.deleteAll();
            });
        }
    };
}
