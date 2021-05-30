package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Status_task;
import java.util.List;

public interface Status_taskRepository {
    public Status_task createStatus_task(Status_task status_task);
    public List<Status_task> getAllStatus();
    public void deleteStatus(int id);

}