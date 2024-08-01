package com.example.selecaocasapopular.service;

import com.example.selecaocasapopular.Entity.Endereco;
import com.example.selecaocasapopular.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }

    public List<Endereco> findByEstadoAndCidadeAndLogradouroAndNumero(String estado, String cidade, String logradouro, String numero) {
        return enderecoRepository.findByEstadoAndCidadeAndLogradouroAndNumero(estado, cidade, logradouro, numero);
    }
}
