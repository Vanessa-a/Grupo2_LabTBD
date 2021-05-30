package Grupo2.demo.Services;

import Grupo2.demo.Models.Task;
import Grupo2.demo.Repositories.TaskRepository;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}