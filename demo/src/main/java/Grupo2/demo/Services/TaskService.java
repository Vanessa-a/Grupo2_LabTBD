package Grupo2.demo.Services;

import Grupo2.demo.Models.Get_active_tasks;
import Grupo2.demo.Models.Task;
import Grupo2.demo.Repositories.TaskRepository;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TaskService {

    private final TaskRepository TaskRepository;
    TaskService(TaskRepository TaskRepository){
        this.TaskRepository = TaskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return TaskRepository.getAllTasks();
    }

    @GetMapping("/totalTasks")
    public List<Get_active_tasks> getTotalTasks2(){
        return TaskRepository.getTotalTasks2();
    }

    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task task){
        Task result = TaskRepository.createTask(task);
        return result;
    }

    @GetMapping("/tasks/delete/{id}")
    @ResponseBody
    public List<Task> deleteTask(@PathVariable int id){
        TaskRepository.deleteTask(id);
        return TaskRepository.getAllTasks();
    }

    @PutMapping("/tasks/update/{id}")
    @ResponseBody
    public List<Task> updateTask(@RequestBody Task task, @PathVariable int id){
        TaskRepository.updateTask(task, id);
        return TaskRepository.getAllTasks();
    }
    
}