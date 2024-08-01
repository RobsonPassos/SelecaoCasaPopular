package com.example.selecaocasapopular.controller;

import com.example.selecaocasapopular.Entity.Endereco;
import com.example.selecaocasapopular.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        Endereco savedEndereco = enderecoService.save(endereco);
        return ResponseEntity.ok(savedEndereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoService.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id);
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<Endereco>> getEnderecoByDetails(@RequestParam String estado,
                                                               @RequestParam String cidade,
                                                               @RequestParam String logradouro,
                                                               @RequestParam String numero) {
        List<Endereco> enderecos = enderecoService.findByEstadoAndCidadeAndLogradouroAndNumero(estado, cidade, logradouro, numero);
        return ResponseEntity.ok(enderecos);
    }
}
