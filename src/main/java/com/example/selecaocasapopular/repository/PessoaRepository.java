package com.example.selecaocasapopular.repository;


import com.example.selecaocasapopular.Entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByPontosAptoGanharCasaGreaterThanOrderByPontosAptoGanharCasaDesc(int pontos, Pageable pageable);
}
