package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.dto.AnimalRecebedorDTO;
import br.com.ebac.animal_service.entity.Animal;
import br.com.ebac.animal_service.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    private List<Animal> findAll(){
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/recebedores/ano/{ano}")
    private List<AnimalRecebedorDTO> getAnimaisPorRecebedorNoAno(@PathVariable int ano){
        return repository.countAnimaisPorRecebedorNoAno(ano);
    }

    @GetMapping("/recebedores/adotados/ano/{ano}")
    private List<AnimalRecebedorDTO> getAnimaisAdotadosPorRecebedorNoAno(@PathVariable int ano){
        return repository.countAnimaisAdotadosPorRecebedorNoAno(ano);
    }
}
