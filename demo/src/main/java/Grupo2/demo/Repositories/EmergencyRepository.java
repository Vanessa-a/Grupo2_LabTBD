package Grupo2.demo.Repositories;

import Grupo2.demo.Models.Emergency;
import java.util.List;

public interface EmergencyRepository {
    public void changeState(int id);
    public void updateEmergency(Emergency emergency, int id);
    public List<Emergency> getAllEmergency();
    public Emergency createEmergency(Emergency emergency);
    public void deleteEmergency(int id);
}

