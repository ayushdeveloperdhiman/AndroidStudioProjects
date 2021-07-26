package com.ayush.todo.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ayush.todo.data.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private static TaskRepository repository;
    private LiveData<List<Task>> allTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }
    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }
    public static void insert(Task task){
        repository.insert(task);
    }
    public static void get(long id){
        repository.get(id);
    }
    public static void delete(Task task){
        repository.delete(task);
    }
    public static void update(Task task){
        repository.update(task);
    }
}
