package Grupo2.demo.Repositories;


import Grupo2.demo.Models.Voluntary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;




@Repository
public class VoluntaryRepositoryImp implements VoluntaryRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Voluntary createVoluntary(Voluntary voluntary){
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO voluntary (name, disponibilidad) values (:volName, :volDisp)", true)
                    .addParameter("volName", voluntary.getName())
                    .addParameter("volDisp", voluntary.getDisponibilidad())
                    .executeUpdate().getKey();
            voluntary.setId_voluntary(insertedId);
            return voluntary;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    @Override
    public List<Voluntary> getAllVoluntary(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntary")
                    .executeAndFetch(Voluntary.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteVoluntary(int id) {
            String deleteSql ="DELETE FROM voluntary WHERE id_voluntary = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(deleteSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void updateVoluntary(Voluntary voluntary, int id) {
        String updateSql = "update voluntary set name = :voluntaryName, disponibilidad =:disp where id_voluntary = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("voluntaryName", voluntary.getName())
                    .addParameter("disp", voluntary.getDisponibilidad())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


