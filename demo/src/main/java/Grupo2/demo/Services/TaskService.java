package Grupo2.demo.Services;

import Grupo2.demo.Models.Get_active_tasks;
import Grupo2.demo.Models.Task;
import Grupo2.demo.Repositories.TaskRepository;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskService {

    private final TaskRepository TaskRepository;
    TaskService(TaskRepository TaskRepository){
        this.TaskRepository = TaskRepository;
    }

    @GetMapping("/tasks")
    public List<String> getTotalTasks(){
        return TaskRepository.getTotalTasks();
    }

    @GetMapping("/tasks2")
    public List<Get_active_tasks> getTotalTasks2(){
        return TaskRepository.getTotalTasks2();
    }

    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task task){
        Task result = TaskRepository.createTask(task);
        return result;
    }
}