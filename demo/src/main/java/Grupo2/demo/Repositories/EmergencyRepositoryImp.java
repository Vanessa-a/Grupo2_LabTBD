package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Emergency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class EmergencyRepositoryImp implements EmergencyRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Integer showName() {
        Integer total = null;
        String sql = "SELECT * FROM emergency";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Emergency> getAllEmergency(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM emergency")
                    .executeAndFetch(Emergency.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}