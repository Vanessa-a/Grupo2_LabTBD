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
    public void changeState(int id){
        List<String> lista_caso = null;
        try(Connection conn = sql2o.open()){
            lista_caso = conn.createQuery("SELECT estado FROM emergency WHERE id_emergency = :id")
                    .addParameter("id", id)
                    .executeAndFetch(String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        String caso = lista_caso.get(0);
        if (caso.equals("true")){
            String updateSql ="update emergency set estado = false where id_emergency = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(updateSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (caso.equals("false")){
            String updateSql ="update emergency set estado = true where id_emergency = :id";
            try(Connection conn = sql2o.open()){
                conn.createQuery(updateSql)
                .addParameter("id", id)
                .executeUpdate();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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

    @Override
    public Emergency createEmergency(Emergency emergency) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO emergency (name, estado) values (:emergencyName, :emergencyEstado)", true)
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("emergencyEstado", emergency.isEstado())
                    .executeUpdate().getKey();
            emergency.setId_emergency(insertedId);
            return emergency;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEmergency(int id) {
            String deleteSql ="DELETE FROM emergency WHERE id_emergency = :id";
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
    public void updateEmergency(Emergency emergency, int id) {
        String updateSql = "update emergency set name = :emergencyName where id_emergency = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("emergencyName", emergency.getName())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}