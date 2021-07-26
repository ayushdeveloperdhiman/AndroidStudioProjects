package com.ayush.todo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ayush.todo.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);
    @Query("Delete from task_table")
    void deleteAll();
    @Query("Select * from task_table")
    LiveData<List<Task>> getTask();
    @Query("Select * from task_table where task_table.task_id==:id")
    LiveData<List<Task>> get(long id);
    @Update
    void update(Task task);
    @Delete
    void delete(Task task);

}
