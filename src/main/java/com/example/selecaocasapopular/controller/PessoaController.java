package com.example.selecaocasapopular.controller;

import com.example.selecaocasapopular.Entity.Pessoa;
import com.example.selecaocasapopular.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa savedPessoa = pessoaService.save(pessoa);
        return ResponseEntity.ok(savedPessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        if (pessoa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pontos/{pontos}")
    public ResponseEntity<Page<Pessoa>> getPessoasByPontos(
            @PathVariable int pontos,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Pessoa> pessoas = pessoaService.findByPontosAptoGanharCasaGreaterThan(pontos, PageRequest.of(page, size));
        return ResponseEntity.ok(pessoas);
    }
}
