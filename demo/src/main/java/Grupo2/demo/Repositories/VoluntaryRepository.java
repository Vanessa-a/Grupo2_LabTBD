
package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Voluntary;
import java.util.List;


public interface VoluntaryRepository {
    public List<Voluntary> getAllVoluntary();
    public Voluntary createVoluntary(Voluntary voluntary);
    public void deleteVoluntary(int id);
    public void updateVoluntary(Voluntary voluntary, int id);

}
