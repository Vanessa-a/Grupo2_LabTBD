package Grupo2.demo.Services;

import Grupo2.demo.Models.Emergency;
import Grupo2.demo.Repositories.EmergencyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmergencyService {

    private final EmergencyRepository EmergencyRepository;
    EmergencyService(EmergencyRepository EmergencyRepository){
        this.EmergencyRepository = EmergencyRepository;
    }


    @GetMapping("/Emergencys")
    public String showName(){
        Integer total = EmergencyRepository.showName();
        return String.format("%s", total);
    }
}
