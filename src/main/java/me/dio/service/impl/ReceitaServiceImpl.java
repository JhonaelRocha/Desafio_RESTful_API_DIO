package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Receita;
import me.dio.domain.repository.ReceitaRepository;
import me.dio.service.ReceitaService;

@Service
public class ReceitaServiceImpl implements ReceitaService{

    private final ReceitaRepository receitaRepository;

    public ReceitaServiceImpl(ReceitaRepository receitaRepository){
        this.receitaRepository = receitaRepository;
    }


    @Override
    public Receita findById(Long id) {
        return receitaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Receita create(Receita receitaToCreate) {
        if (receitaToCreate.getId() != null && receitaRepository.existsById(receitaToCreate.getId())){
            throw new IllegalArgumentException("This User ID already exists");
        }
        return receitaRepository.save(receitaToCreate);
    }

}