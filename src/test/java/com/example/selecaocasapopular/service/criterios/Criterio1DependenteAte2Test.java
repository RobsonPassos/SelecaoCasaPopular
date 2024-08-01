package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Criterio1DependenteAte2Test {

    private Criterio1DependenteAte2 criterio;
    private Pessoa pessoa;

    /**
     * Inicializamos a instância de Criterio1DependenteAte2 e criamos um mock de Pessoa.
     */
    @BeforeEach
    void setUp() {
        criterio = new Criterio1DependenteAte2();
        pessoa = mock(Pessoa.class);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 2 quando a pessoa tem 1 dependente menor de idade.
     */
    @Test
    void testCalcularPontuacao_1Dependente() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(1);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(2, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 2 quando a pessoa tem 2 dependentes menores de idade.
     */
    @Test
    void testCalcularPontuacao_2Dependentes() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(2);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(2, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 0 quando a pessoa não tem dependentes menores de idade.
     */
    @Test
    void testCalcularPontuacao_SemDependentes() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(0);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(0, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 0 quando a pessoa tem mais de 2 dependentes menores de idade.
     */
    @Test
    void testCalcularPontuacao_MaisDe2Dependentes() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(3);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(0, pontuacao);
    }
}
