package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Vol_skill;
import java.util.List;


public interface Vol_skillRepository {
    public List<Vol_skill> getAllVol_skill();
    public Vol_skill createVol_skill(Vol_skill vol_skill);
    public void deleteVol_skill(int id);
    public void updateVol_skill(Vol_skill vol_skill, int id);

}