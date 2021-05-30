package Grupo2.demo.Repositories;


import Grupo2.demo.Models.Get_active_tasks;
import Grupo2.demo.Models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class TaskRepositoryImp implements TaskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<String> getTotalTasks(){
        List<String> total = null;
        String sql = "SELECT get_active_task2()";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeAndFetch(String.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(total);
        return total;
    }

    @Override
    public Task createTask(Task task) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO task (name, id_status_task, id_emergency) values (:taskName, :taskEstado, :taskEmergency)", true)
                    .addParameter("taskName", task.getName())
                    .addParameter("taskEstado", task.getId_status_task())
                    .addParameter("taskEmergency", task.getId_emergency())
                    .executeUpdate().getKey();
            task.setId_task(insertedId);
            return task;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Get_active_tasks> getTotalTasks2(){
        String sql = "SELECT * FROM get_active_task1()";
        List<Get_active_tasks> total = null;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeAndFetch(Get_active_tasks.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return total;
    }        
}


