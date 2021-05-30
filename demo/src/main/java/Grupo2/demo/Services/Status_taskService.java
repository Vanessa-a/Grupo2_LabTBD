package Grupo2.demo.Services;

import Grupo2.demo.Models.Status_task;
import Grupo2.demo.Repositories.Status_taskRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class Status_taskService {
    private final Status_taskRepository Status_taskRepository;
    Status_taskService(Status_taskRepository Status_taskRepository){
        this.Status_taskRepository = Status_taskRepository;
    }

    @GetMapping("/statustasks")
    public List<Status_task> getAllStatus(){
        return Status_taskRepository.getAllStatus();
    }

    @PostMapping("/statustasks")
    @ResponseBody
    public Status_task createStatus_task(@RequestBody Status_task status_task){
        Status_task result = Status_taskRepository.createStatus_task(status_task);
        return result;
    }

    @GetMapping("/statustasks/delete/{id}")
    @ResponseBody
    public List<Status_task> deleteStatus(@PathVariable int id){
        Status_taskRepository.deleteStatus(id);
        return Status_taskRepository.getAllStatus();
    }
}