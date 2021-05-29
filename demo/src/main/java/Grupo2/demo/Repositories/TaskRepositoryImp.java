package Grupo2.demo.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import org.json.JSONObject;



public class TaskRepositoryImp implements TaskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public JSONObject getTotalTasks(){
        JSONObject total;
        String sql = "SELECT get_active_task()";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(JSONObject.class);
        }
        return total;
    }    
}


