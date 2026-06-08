package com.joaog4briel.ninjas.controller;

import com.joaog4briel.ninjas.entity.NinjaEntity;
import com.joaog4briel.ninjas.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping
    public List<NinjaEntity> listarTodos() {
        return ninjaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaEntity> buscarPorId(@PathVariable Long id) {
        return ninjaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NinjaEntity> criar(@RequestBody NinjaEntity ninja) {
        return ResponseEntity.ok(ninjaService.salvar(ninja));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaEntity> atualizar(@PathVariable Long id, @RequestBody NinjaEntity ninja) {
        return ResponseEntity.ok(ninjaService.atualizar(id, ninja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ninjaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{ninjaId}/missao/{missaoId}")
    public ResponseEntity<NinjaEntity> atribuirMissao(
            @PathVariable Long ninjaId,
            @PathVariable Long missaoId) {
        return ResponseEntity.ok(ninjaService.atribuirMissao(ninjaId, missaoId));
    }
}
