package br.com.ebac.carros.controller;

import br.com.ebac.carros.entity.Acessorio;
import br.com.ebac.carros.entity.Carro;
import br.com.ebac.carros.repository.CarroRepository;
import br.com.ebac.carros.repository.MarcaRepository;
import br.com.ebac.carros.repository.AcessorioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroRepository carroRepository;
    private final MarcaRepository marcaRepository;
    private final AcessorioRepository acessorioRepository;

    public CarroController(CarroRepository carroRepository,
                           MarcaRepository marcaRepository,
                           AcessorioRepository acessorioRepository) {
        this.carroRepository = carroRepository;
        this.marcaRepository = marcaRepository;
        this.acessorioRepository = acessorioRepository;
    }

    @GetMapping
    public List<Carro> findAll() {
        return carroRepository.findAllWithDetails();
    }

    @PostMapping
    public Carro create(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @PostMapping("/{carroId}/acessorios/{acessorioId}")
    public Carro addAcessorio(@PathVariable Long carroId, @PathVariable Long acessorioId) {
        Carro carro = carroRepository.findById(carroId).orElse(null);
        Acessorio acessorio = acessorioRepository.findById(acessorioId).orElse(null);

        if (carro != null && acessorio != null) {
            carro.adicionarAcessorio(acessorio);
            return carroRepository.save(carro);
        }
        return null;
    }
}