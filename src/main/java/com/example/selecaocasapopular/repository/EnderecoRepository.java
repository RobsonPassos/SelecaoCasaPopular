package com.example.selecaocasapopular.repository;

import com.example.selecaocasapopular.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByEstadoAndCidadeAndLogradouroAndNumero(String estado, String cidade, String logradouro, String numero);
}
