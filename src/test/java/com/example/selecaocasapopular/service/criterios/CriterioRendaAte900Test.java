package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CriterioRendaAte900Test {

    private CriterioRendaAte900 criterio;
    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        criterio = new CriterioRendaAte900();
        pessoa = mock(Pessoa.class);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 5 quando a renda total da família é exatamente 900.
     */
    @Test
    void testCalcularPontuacao_RendaIgual900() {
        when(pessoa.getRendaTotalFamilia()).thenReturn(BigDecimal.valueOf(900));

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(5, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 5 quando a renda total da família é menor que 900.
     */
    @Test
    void testCalcularPontuacao_RendaMenor900() {
        when(pessoa.getRendaTotalFamilia()).thenReturn(BigDecimal.valueOf(800));

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(5, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 0 quando a renda total da família é maior que 900.
     */
    @Test
    void testCalcularPontuacao_RendaMaior900() {
        when(pessoa.getRendaTotalFamilia()).thenReturn(BigDecimal.valueOf(1000));

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(0, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 0 quando a renda total da família é nula.
     */
    @Test
    void testCalcularPontuacao_RendaNula() {
        when(pessoa.getRendaTotalFamilia()).thenReturn(null);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(0, pontuacao);
    }
}
