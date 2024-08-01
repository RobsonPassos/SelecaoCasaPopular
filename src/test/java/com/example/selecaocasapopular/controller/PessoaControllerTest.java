package com.example.selecaocasapopular.controller;

import com.example.selecaocasapopular.Entity.Pessoa;
import com.example.selecaocasapopular.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    public PessoaControllerTest() {
        MockitoAnnotations.openMocks(this);
    }


    /**
     * Verifica se a criação de uma Pessoa retorna a resposta correta e o corpo esperado.
     */
    @Test
    void testCreatePessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João Silva");
        pessoa.setCpf("12345678901");
        pessoa.setDependentesMenoresIdade(2);
        pessoa.setQntPessoasFamilia(4);
        pessoa.setRendaTotalFamilia(BigDecimal.valueOf(800));
        pessoa.setTemCasaPropria(false);
        pessoa.setPontosAptoGanharCasa(5);
        pessoa.setContempladoCasa(false);

        when(pessoaService.save(any(Pessoa.class))).thenReturn(pessoa);

        ResponseEntity<Pessoa> response = pessoaController.createPessoa(pessoa);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(pessoa, response.getBody());
    }

    /**
     * Verifica se a lista de todas as pessoas é retornada corretamente.
     */
    @Test
    void testGetAllPessoas() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        when(pessoaService.findAll()).thenReturn(pessoas);

        ResponseEntity<List<Pessoa>> response = pessoaController.getAllPessoas();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(pessoas, response.getBody());
    }

    /**
     * Verifica se uma Pessoa é retornada corretamente quando o ID é encontrado.
     */
    @Test
    void testGetPessoaById() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);

        when(pessoaService.findById(anyLong())).thenReturn(pessoa);

        ResponseEntity<Pessoa> response = pessoaController.getPessoaById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(pessoa, response.getBody());
    }

    /**
     * Verifica se a resposta 404 é retornada quando a Pessoa não é encontrada.
     */
    @Test
    void testGetPessoaByIdNotFound() {
        when(pessoaService.findById(anyLong())).thenReturn(null);

        ResponseEntity<Pessoa> response = pessoaController.getPessoaById(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

    /**
     * Verifica se o status de resposta 204 (No Content) é retornado após a exclusão.
     */
    @Test
    void testDeletePessoa() {
        ResponseEntity<Void> response = pessoaController.deletePessoa(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Verifica se a lista de pessoas com pontos maiores que um determinado valor é retornada corretamente e paginada.
     */
    @Test
    void testGetPessoasByPontos() {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setPontosAptoGanharCasa(6);
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setPontosAptoGanharCasa(7);
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        Page<Pessoa> page = new PageImpl<>(pessoas);

        when(pessoaService.findByPontosAptoGanharCasaGreaterThan(anyInt(), any(PageRequest.class))).thenReturn(page);

        ResponseEntity<Page<Pessoa>> response = pessoaController.getPessoasByPontos(5, 0, 10);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(page, response.getBody());
    }
}
