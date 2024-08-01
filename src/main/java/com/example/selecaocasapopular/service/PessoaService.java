package com.example.selecaocasapopular.service;

import com.example.selecaocasapopular.Entity.Pessoa;
import com.example.selecaocasapopular.repository.PessoaRepository;
import com.example.selecaocasapopular.service.criterios.ICriterioPontuacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, List<ICriterioPontuacao> criterios) {
        this.pessoaRepository = pessoaRepository;
        this.criterios = criterios;
    }

    public Pessoa save(Pessoa pessoa) {
        calcularPontuacao(pessoa);
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Page<Pessoa> findByPontosAptoGanharCasaGreaterThan(int pontos, Pageable pageable) {
        return pessoaRepository.findByPontosAptoGanharCasaGreaterThanOrderByPontosAptoGanharCasaDesc(pontos, pageable);
    }

    private final List<ICriterioPontuacao> criterios;


    public int calcularPontuacao(Pessoa pessoa) {
        return criterios.stream().mapToInt(criterio -> criterio.calcularPontuacao(pessoa)).sum();
    }
}
