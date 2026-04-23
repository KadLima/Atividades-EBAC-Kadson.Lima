package com.example.tarefas.controller;

import com.example.tarefas.model.Tarefa;
import com.example.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTodas();
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody Tarefa tarefa) {
        return tarefaService.adicionar(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        boolean removida = tarefaService.remover(id);

        if (removida) {
            return ResponseEntity.ok("Tarefa removida com sucesso.");
        }

        return ResponseEntity.notFound().build();
    }
}