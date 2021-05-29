package Grupo2.demo.Services;

import Grupo2.demo.Models.Emergency;
import Grupo2.demo.Repositories.EmergencyRepository;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmergencyService {

    private final EmergencyRepository EmergencyRepository;
    EmergencyService(EmergencyRepository EmergencyRepository){
        this.EmergencyRepository = EmergencyRepository;
    }


    @GetMapping("/emergencies")
    public List<Emergency> getAllEmergency(){
        return EmergencyRepository.getAllEmergency();
    }

    @GetMapping("/emergencies/changeState/{id}")
    public List<Emergency> changeState(@PathVariable int id){
        EmergencyRepository.changeState(id);
        return EmergencyRepository.getAllEmergency();
    }
    @PostMapping("/emergencies")
    @ResponseBody
    public Emergency createEmergency(@RequestBody Emergency emergency){
        Emergency result = EmergencyRepository.createEmergency(emergency);
        return result;
    }
}
