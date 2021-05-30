package Grupo2.demo.Repositories;



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
        String sql = "SELECT get_active_task()";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeAndFetch(String.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return total;
    }    
}


