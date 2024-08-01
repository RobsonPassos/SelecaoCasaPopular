package com.example.selecaocasapopular.service;


import com.example.selecaocasapopular.Entity.Pessoa;
import com.example.selecaocasapopular.repository.PessoaRepository;
import com.example.selecaocasapopular.service.criterios.ICriterioPontuacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private List<ICriterioPontuacao> criterios;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Verifica se o método save do PessoaService chama o método save do PessoaRepository e retorna o objeto salvo corretamente.
     * O cálculo da pontuação é simulado como zero.
     */
    @Test
    void testSave() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);
        // Mock the criteria calculation
        ICriterioPontuacao criterio = mock(ICriterioPontuacao.class);
        when(criterio.calcularPontuacao(any(Pessoa.class))).thenReturn(0);
        criterios = Arrays.asList(criterio);
        pessoaService = new PessoaService(pessoaRepository, criterios);

        Pessoa result = pessoaService.save(pessoa);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    /**
     * Verifica se o método findAll do PessoaService retorna a lista de todas as Pessoas corretamente.
     */
    @Test
    void testFindAll() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);
        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> result = pessoaService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(pessoaRepository, times(1)).findAll();
    }

    /**
     * Verifica se o método findById do PessoaService retorna a Pessoa corretamente quando encontrada.
     */
    @Test
    void testFindById() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoa));

        Pessoa result = pessoaService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(pessoaRepository, times(1)).findById(anyLong());
    }

    /**
     * Verifica se o método findById do PessoaService retorna null quando a Pessoa não é encontrada.
     */
    @Test
    void testFindByIdNotFound() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());

        Pessoa result = pessoaService.findById(1L);

        assertNull(result);
        verify(pessoaRepository, times(1)).findById(anyLong());
    }

    /**
     * Verifica se o método deleteById do PessoaService chama o método deleteById do PessoaRepository para excluir a Pessoa.
     */
    @Test
    void testDeleteById() {
        doNothing().when(pessoaRepository).deleteById(anyLong());

        pessoaService.deleteById(1L);

        verify(pessoaRepository, times(1)).deleteById(anyLong());
    }

    /**
     * Verifica se o método findByPontosAptoGanharCasaGreaterThan do PessoaService retorna uma página de Pessoas corretamente com base nos pontos fornecidos.
     */
    @Test
    void testFindByPontosAptoGanharCasaGreaterThan() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);
        Page<Pessoa> page = new PageImpl<>(pessoas);
        when(pessoaRepository.findByPontosAptoGanharCasaGreaterThanOrderByPontosAptoGanharCasaDesc(anyInt(), any(Pageable.class)))
                .thenReturn(page);

        Page<Pessoa> result = pessoaService.findByPontosAptoGanharCasaGreaterThan(5, PageRequest.of(0, 10));

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        verify(pessoaRepository, times(1)).findByPontosAptoGanharCasaGreaterThanOrderByPontosAptoGanharCasaDesc(anyInt(), any(Pageable.class));
    }

    /**
     * Verifica se o método calcularPontuacao do PessoaService calcula a pontuação corretamente com base nos critérios fornecidos.
     */
    @Test
    void testCalcularPontuacao() {
        Pessoa pessoa = new Pessoa();
        ICriterioPontuacao criterio = mock(ICriterioPontuacao.class);
        when(criterio.calcularPontuacao(any(Pessoa.class))).thenReturn(5);
        criterios = Arrays.asList(criterio);
        pessoaService = new PessoaService(pessoaRepository, criterios);

        int pontos = pessoaService.calcularPontuacao(pessoa);

        assertEquals(5, pontos);
    }
}
