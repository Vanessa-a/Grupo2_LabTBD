package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Ranking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class RankingRepositoryImp implements RankingRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Ranking createRanking(Ranking ranking) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO ranking (numRanking, id_voluntary) values (:numeroRanking, :ranking_id_voluntary )", true)
            .addParameter("numeroRanking", ranking.getNumRanking())
            .addParameter("ranking_id_voluntary", ranking.getId_voluntary())
            .executeUpdate().getKey();
            ranking.setId_ranking(insertedId);
            return ranking;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> getAllRanking(){   
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM ranking")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteRanking(int id) {
            String deleteSql ="DELETE FROM ranking WHERE id_ranking = :id";
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
    public void updateRanking(Ranking ranking, int id) {
        String updateSql = "update ranking set numRanking = :numeroRanking, id_voluntary = :ranking_id_voluntary where id_ranking = :id";
        try(Connection conn = sql2o.open()){
                    conn.createQuery(updateSql)
                    .addParameter("numeroRanking", ranking.getNumRanking())
                    .addParameter("ranking_id_voluntary", ranking.getId_voluntary())
                    .addParameter("id", id)
                    .executeUpdate();
            return;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
