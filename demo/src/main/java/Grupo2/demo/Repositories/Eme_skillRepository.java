
package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Eme_skill;
import java.util.List;


public interface Eme_skillRepository {
    public List<Eme_skill> getAlleme_skill();
    public Eme_skill createEme_skill(Eme_skill eme_skill);
    public void deleteEme_skill(int id);
    public void updateEme_skill(Eme_skill eme_skill, int id);
}
