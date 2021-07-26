package com.ayush.todo.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.ayush.todo.data.TaskDao;
import com.ayush.todo.model.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Task.class},version = 1,exportSchema = false)
@TypeConverters(Converter.class)
public abstract class TaskRoomDatabase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS=4;
    public abstract TaskDao TaskDao();
    private static volatile TaskRoomDatabase INSTANCE;
    public static final ExecutorService dataWriteExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static final RoomDatabase.Callback sRoomDatabaseCallback =new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            dataWriteExecutor.execute(()->{
                TaskDao taskDao=INSTANCE.TaskDao();
                taskDao.deleteAll();
            });
        }
    };
    public static TaskRoomDatabase getDatabase(final Context context){
        if(INSTANCE==null) {
            synchronized (TaskRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TaskRoomDatabase.class,
                            "task_databse").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
