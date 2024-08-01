package com.example.selecaocasapopular.service.criterios;


import com.example.selecaocasapopular.Entity.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Criterio3DependentesOuMaisTest {

    private Criterio3DependentesOuMais criterio;
    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        criterio = new Criterio3DependentesOuMais();
        pessoa = mock(Pessoa.class);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 3 quando a pessoa tem 3 dependentes menores de idade.
     */
    @Test
    void testCalcularPontuacao_3Dependentes() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(3);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(3, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 3 quando a pessoa tem mais de 3 dependentes menores de idade.
     */
    @Test
    void testCalcularPontuacao_MaisDe3Dependentes() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(4);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(3, pontuacao);
    }

    /**
     * Verifica se o método calcularPontuacao retorna 0 quando a pessoa tem menos de 3 dependentes menores de idade.
     */
    @Test
    void testCalcularPontuacao_MenosDe3Dependentes() {
        when(pessoa.getDependentesMenoresIdade()).thenReturn(2);

        int pontuacao = criterio.calcularPontuacao(pessoa);

        assertEquals(0, pontuacao);
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
}
