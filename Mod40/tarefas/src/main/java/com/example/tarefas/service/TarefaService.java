package com.example.tarefas.service;

import com.example.tarefas.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final List<Tarefa> tarefas = new ArrayList<>();
    private Long proximoId = 1L;

    public List<Tarefa> listarTodas() {
        return tarefas;
    }

    public Tarefa adicionar(Tarefa tarefa) {
        tarefa.setId(proximoId++);
        tarefas.add(tarefa);
        return tarefa;
    }

    public boolean remover(Long id) {
        return tarefas.removeIf(t -> t.getId().equals(id));
    }
}