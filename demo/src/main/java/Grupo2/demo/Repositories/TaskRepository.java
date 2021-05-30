package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Get_active_tasks;
import Grupo2.demo.Models.Task;
import java.util.List;

public interface TaskRepository {
    public List<Task> getAllTasks();
    public void updateTask(Task task, int id);
    public List<Get_active_tasks>  getTotalTasks2();  
    public Task createTask(Task task);
    public void deleteTask(int id);
}

