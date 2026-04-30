package br.com.ebac.carros.controller;

import br.com.ebac.carros.entity.Acessorio;
import br.com.ebac.carros.repository.AcessorioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {
    private final AcessorioRepository repository;

    public AcessorioController(AcessorioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Acessorio> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Acessorio create(@RequestBody Acessorio acessorio) {
        return repository.save(acessorio);
    }
}