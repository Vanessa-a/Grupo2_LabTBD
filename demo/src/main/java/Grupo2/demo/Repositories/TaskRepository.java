package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Get_active_tasks;
import Grupo2.demo.Models.Task;
import java.util.List;

public interface TaskRepository {
    public List<String>  getTotalTasks();  
    public List<Get_active_tasks>  getTotalTasks2();  
    public Task createTask(Task task);
}

