package me.dio.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Receita;
import me.dio.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> findById(@PathVariable Long id) {
        var receita = receitaService.findById(id);
        return ResponseEntity.ok(receita);
    }

    @PostMapping
    public ResponseEntity<Receita> create(@RequestBody Receita receitaToCreate) {
        var receitaCreated = receitaService.create(receitaToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(receitaCreated.getId())
        .toUri();
        return ResponseEntity.created(location).body(receitaCreated);
    }
}
