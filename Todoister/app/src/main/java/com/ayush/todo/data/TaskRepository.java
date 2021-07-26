package com.ayush.todo.data;
import android.app.Application;
import androidx.lifecycle.LiveData;
import com.ayush.todo.model.Task;
import com.ayush.todo.util.TaskRoomDatabase;
import java.util.List;

public class TaskRepository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public TaskRepository(Application application) {
        TaskRoomDatabase database=TaskRoomDatabase.getDatabase(application);
        taskDao = database.TaskDao();
        allTasks =taskDao.getTask();
    }

    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }
    public void insert(Task task){
        TaskRoomDatabase.dataWriteExecutor.execute(()->{
            taskDao.insert(task);
        });
    }
    public void delete(Task task){
        TaskRoomDatabase.dataWriteExecutor.execute(()->{
            taskDao.delete(task);
        });
    }
    public void update(Task task){
        TaskRoomDatabase.dataWriteExecutor.execute(()-> {
            taskDao.update(task);
        });
    }
    public LiveData<List<Task>> get(long id){
        return taskDao.get(id);
    }
}
