package br.com.ebac.carros.controller;

import br.com.ebac.carros.entity.Marca;
import br.com.ebac.carros.repository.MarcaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    private final MarcaRepository repository;

    public MarcaController(MarcaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Marca> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Marca create(@RequestBody Marca marca) {
        return repository.save(marca);
    }
}