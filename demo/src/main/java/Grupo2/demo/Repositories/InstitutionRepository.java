package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Institution;
import java.util.List;

public interface InstitutionRepository {
    public void updateInstitution(Institution institution, int id);
    public List<Institution> getAllInstitution();
    public Institution createInstitution(Institution institution);
    public void deleteInstitution(int id);
}