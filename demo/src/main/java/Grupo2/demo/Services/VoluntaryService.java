package Grupo2.demo.Services;

import Grupo2.demo.Models.Voluntary;
import Grupo2.demo.Repositories.VoluntaryRepository;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VoluntaryService {
    private final VoluntaryRepository VoluntaryRepository;
    VoluntaryService(VoluntaryRepository VoluntaryRepository){
        this.VoluntaryRepository = VoluntaryRepository;
    }

    @GetMapping("/voluntaries")
    public List<Voluntary> getAllVoluntary(){
        return VoluntaryRepository.getAllVoluntary();
    }

    @PostMapping("/voluntaries")
    @ResponseBody
    public Voluntary createVoluntary(@RequestBody Voluntary voluntary){
        Voluntary result = VoluntaryRepository.createVoluntary(voluntary);
        return result;
    }

    @GetMapping("/voluntaries/delete/{id}")
    @ResponseBody
    public List<Voluntary> deleteVoluntary(@PathVariable int id){
        VoluntaryRepository.deleteVoluntary(id);
        return VoluntaryRepository.getAllVoluntary();
    }

    @PutMapping("/voluntaries/update/{id}")
    @ResponseBody
    public List<Voluntary> updateVoluntary(@RequestBody Voluntary voluntary, @PathVariable int id){
        VoluntaryRepository.updateVoluntary(voluntary, id);
        return VoluntaryRepository.getAllVoluntary();
    }

}