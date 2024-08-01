package com.example.selecaocasapopular.service.criterios;

import com.example.selecaocasapopular.Entity.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriterioRendaMaiorQue900Ate1500Test {

    private CriterioRendaMaiorQue900Ate1500 criterio;

    @BeforeEach
    void setUp() {
        criterio = new CriterioRendaMaiorQue900Ate1500();
    }

    /**
     * Testa se a pontuação é 3 quando a renda total da família está entre 900 e 1500.
     */
    @Test
    void testCalcularPontuacao_RendaEntre900E1500() {
        Pessoa pessoa = new Pessoa();
        pessoa.setRendaTotalFamilia(BigDecimal.valueOf(1000));  // Renda dentro do intervalo

        int resultado = criterio.calcularPontuacao(pessoa);

        assertEquals(3, resultado, "A pontuação deve ser 3 quando a renda está entre 900 e 1500.");
    }

    /**
     * Testa se a pontuação é 0 quando a renda total da família é menor que 900.
     */
    @Test
    void testCalcularPontuacao_RendaMenorQue900() {
        Pessoa pessoa = new Pessoa();
        pessoa.setRendaTotalFamilia(BigDecimal.valueOf(800));  // Renda abaixo do intervalo

        int resultado = criterio.calcularPontuacao(pessoa);

        assertEquals(0, resultado, "A pontuação deve ser 0 quando a renda é menor que 900.");
    }

    /**
     * Testa se a pontuação é 0 quando a renda total da família é maior que 1500.
     */
    @Test
    void testCalcularPontuacao_RendaMaiorQue1500() {
        Pessoa pessoa = new Pessoa();
        pessoa.setRendaTotalFamilia(BigDecimal.valueOf(1600));  // Renda acima do intervalo

        int resultado = criterio.calcularPontuacao(pessoa);

        assertEquals(0, resultado, "A pontuação deve ser 0 quando a renda é maior que 1500.");
    }

    /**
     * Testa se a pontuação é 0 quando a renda total da família é nula.
     */
    @Test
    void testCalcularPontuacao_RendaNula() {
        Pessoa pessoa = new Pessoa();
        pessoa.setRendaTotalFamilia(null);  // Renda nula

        int resultado = criterio.calcularPontuacao(pessoa);

        assertEquals(0, resultado, "A pontuação deve ser 0 quando a renda é nula.");
    }
}
