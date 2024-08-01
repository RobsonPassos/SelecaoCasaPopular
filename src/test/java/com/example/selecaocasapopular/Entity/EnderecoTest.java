package com.example.selecaocasapopular.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoTest {

    @Test
    void testGettersAndSetters() {
        Endereco endereco = new Endereco();

        // Define valores
        endereco.setId(1L);
        endereco.setEstado("SP");
        endereco.setCidade("São Paulo");
        endereco.setLogradouro("Rua das Flores");
        endereco.setNumero("123");

        // Verifica os valores definidos
        assertEquals(1L, endereco.getId());
        assertEquals("SP", endereco.getEstado());
        assertEquals("São Paulo", endereco.getCidade());
        assertEquals("Rua das Flores", endereco.getLogradouro());
        assertEquals("123", endereco.getNumero());
    }
}
