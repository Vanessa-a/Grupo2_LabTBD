package Grupo2.demo.Services;

import Grupo2.demo.Models.Eme_skill;
import Grupo2.demo.Repositories.Eme_skillRepository;

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
public class Eme_skillService {
    private final Eme_skillRepository Eme_skillRepository;
    Eme_skillService(Eme_skillRepository Eme_skillRepository){
        this.Eme_skillRepository = Eme_skillRepository;
    }

    @GetMapping("/eme_skills")
    public List<Eme_skill> getAllEme_skill(){
        return Eme_skillRepository.getAllEme_skill();
    }

    @PostMapping("/eme_skills")
    @ResponseBody
    public Eme_skill createEme_skill(@RequestBody Eme_skill eme_skill){
        Eme_skill result = Eme_skillRepository.createEme_skill(Eme_skill);
        return result;
    }

    @GetMapping("/eme_skills/delete/{id}")
    @ResponseBody
    public List<Eme_skill> deleteEme_skill(@PathVariable int id){
        Eme_skillRepository.deleteEme_skill(id);
        return Eme_skillRepository.getAllEme_skill();
    }

    @PutMapping("/eme_skills/update/{id}")
    @ResponseBody
    public List<Eme_skill> updateEme_skill(@RequestBody Eme_skill eme_skill, @PathVariable int id){
        Eme_skillRepository.updateEme_skill(Eme_skill, id);
        return Eme_skillRepository.getAllEme_skill();
    }

}