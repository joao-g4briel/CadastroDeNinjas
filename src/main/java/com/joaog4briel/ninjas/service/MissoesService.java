package com.joaog4briel.ninjas.service;

import com.joaog4briel.ninjas.entity.MissoesEntity;
import com.joaog4briel.ninjas.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    public List<MissoesEntity> listarTodas() {
        return missoesRepository.findAll();
    }

    public Optional<MissoesEntity> buscarPorId(Long id) {
        return missoesRepository.findById(id);
    }

    public MissoesEntity salvar(MissoesEntity missao) {
        return missoesRepository.save(missao);
    }

    public MissoesEntity atualizar(Long id, MissoesEntity dadosNovos) {
        MissoesEntity missao = missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missão não encontrada: " + id));

        missao.setNome(dadosNovos.getNome());
        missao.setDificuldade(dadosNovos.getDificuldade());

        return missoesRepository.save(missao);
    }

    public void deletar(Long id) {
        missoesRepository.deleteById(id);
    }
}