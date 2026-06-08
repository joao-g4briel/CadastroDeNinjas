package com.joaog4briel.ninjas.service;

import com.joaog4briel.ninjas.entity.MissoesEntity;
import com.joaog4briel.ninjas.entity.NinjaEntity;
import com.joaog4briel.ninjas.repository.MissoesRepository;
import com.joaog4briel.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public List<NinjaEntity> listarTodos() {
        return ninjaRepository.findAll();
    }

    public Optional<NinjaEntity> buscarPorId(Long id) {
        return ninjaRepository.findById(id);
    }

    public NinjaEntity salvar(NinjaEntity ninja) {
        return ninjaRepository.save(ninja);
    }

    public NinjaEntity atualizar(Long id, NinjaEntity dadosNovos) {
        NinjaEntity ninja = ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado: " + id));

        ninja.setNome(dadosNovos.getNome());
        ninja.setEmail(dadosNovos.getEmail());
        ninja.setIdade(dadosNovos.getIdade());
        ninja.setMissoes(dadosNovos.getMissoes());

        return ninjaRepository.save(ninja);
    }

    public void deletar(Long id) {
        ninjaRepository.deleteById(id);
    }

    @Autowired
    private MissoesRepository missoesRepository;

    public NinjaEntity atribuirMissao(Long ninjaId, Long missaoId) {
        NinjaEntity ninja = ninjaRepository.findById(ninjaId)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        MissoesEntity missao = missoesRepository.findById(missaoId)
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));

        ninja.setMissoes(missao);
        return ninjaRepository.save(ninja);
    }
}