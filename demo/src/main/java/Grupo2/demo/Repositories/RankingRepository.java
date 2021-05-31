package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Ranking;
import java.util.List;

public interface RankingRepository {
    public void updateRanking(Ranking Ranking, int id);
    public List<Ranking> getAllRanking();
    public Ranking createRanking(Ranking Ranking);
    public void deleteRanking(int id);
}
