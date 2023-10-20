package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita,Long> {
    
}
