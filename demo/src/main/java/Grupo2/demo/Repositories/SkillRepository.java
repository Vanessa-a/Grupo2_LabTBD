package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Skill;
import java.util.List;

public interface SkillRepository {
    public Skill createSkill(Skill skill);
    public List<Skill> getAllSkill();
    public void updateSkill(Skill skill, int id);
    public void deleteSkill(int id);
}

