package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Task_skill;
import java.util.List;

public interface EmergencyRepository {
    public void updateTask_skill(Task_skill task_skill, int id);
    public List<Task_skill> getAllTask_skill();
    public Task_skill createTask_skill(Task_skill task_skill);
    public void deleteTask_skill(int id);
}