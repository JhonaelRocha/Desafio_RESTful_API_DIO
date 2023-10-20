package me.dio.service;


import me.dio.domain.model.Receita;

public interface ReceitaService {

    Receita findById(Long id);

    Receita create(Receita receitaToCreate);
}
