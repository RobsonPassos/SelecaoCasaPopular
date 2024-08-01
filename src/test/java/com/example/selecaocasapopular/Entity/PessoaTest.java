package com.example.selecaocasapopular.Entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    @Test
    void testGettersAndSetters() {
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();

        // Define valores
        pessoa.setId(1L);
        pessoa.setNome("João");
        pessoa.setCpf("12345678900");
        pessoa.setDependentesMenoresIdade(2);
        pessoa.setQntPessoasFamilia(4);
        pessoa.setRendaTotalFamilia(BigDecimal.valueOf(1000));
        pessoa.setTemCasaPropria(true);
        pessoa.setPontosAptoGanharCasa(10);
        pessoa.setContempladoCasa(false);
        pessoa.setEndereco(endereco);

        // Verifica os valores definidos
        assertEquals(1L, pessoa.getId());
        assertEquals("João", pessoa.getNome());
        assertEquals("12345678900", pessoa.getCpf());
        assertEquals(2, pessoa.getDependentesMenoresIdade());
        assertEquals(4, pessoa.getQntPessoasFamilia());
        assertEquals(BigDecimal.valueOf(1000), pessoa.getRendaTotalFamilia());
        assertEquals(true, pessoa.isTemCasaPropria());
        assertEquals(10, pessoa.getPontosAptoGanharCasa());
        assertEquals(false, pessoa.isContempladoCasa());
        assertEquals(endereco, pessoa.getEndereco());
    }
}
