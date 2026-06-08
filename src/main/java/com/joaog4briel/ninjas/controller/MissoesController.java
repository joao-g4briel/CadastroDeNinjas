package com.joaog4briel.ninjas.controller;

import com.joaog4briel.ninjas.entity.MissoesEntity;
import com.joaog4briel.ninjas.service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    @GetMapping
    public List<MissoesEntity> listarTodos() {
        return missoesService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissoesEntity> buscarPorId(@PathVariable Long id) {
        return missoesService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<MissoesEntity> criar(@RequestBody MissoesEntity missoes) {
        return ResponseEntity.ok(missoesService.salvar(missoes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissoesEntity> atualizar(@PathVariable Long id) {
        missoesService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
