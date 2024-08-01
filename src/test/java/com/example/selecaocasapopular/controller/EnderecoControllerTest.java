package com.example.selecaocasapopular.controller;

import com.example.selecaocasapopular.Entity.Endereco;
import com.example.selecaocasapopular.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class EnderecoControllerTest {

    @Mock
    private EnderecoService enderecoService;

    @InjectMocks
    private EnderecoController enderecoController;

    public EnderecoControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Verifica se a criação de um Endereco retorna a resposta correta e o corpo esperado.
     */
    @Test
    void testCreateEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setEstado("SP");
        endereco.setCidade("São Paulo");
        endereco.setLogradouro("Avenida Paulista");
        endereco.setNumero("1000");

        when(enderecoService.save(any(Endereco.class))).thenReturn(endereco);

        ResponseEntity<Endereco> response = enderecoController.createEndereco(endereco);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(endereco, response.getBody());
    }

    /**
     * Verifica se a lista de todos os endereços é retornada corretamente.
     */
    @Test
    void testGetAllEnderecos() {
        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco1);
        enderecos.add(endereco2);

        when(enderecoService.findAll()).thenReturn(enderecos);

        ResponseEntity<List<Endereco>> response = enderecoController.getAllEnderecos();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(enderecos, response.getBody());
    }

    /**
     * Verifica se um Endereco é retornado corretamente quando o ID é encontrado.
     */
    @Test
    void testGetEnderecoById() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);

        when(enderecoService.findById(anyLong())).thenReturn(endereco);

        ResponseEntity<Endereco> response = enderecoController.getEnderecoById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(endereco, response.getBody());
    }

    /**
     * Verifica se a resposta 404 é retornada quando o Endereco não é encontrado.
     */
    @Test
    void testGetEnderecoByIdNotFound() {
        when(enderecoService.findById(anyLong())).thenReturn(null);

        ResponseEntity<Endereco> response = enderecoController.getEnderecoById(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

    /**
     *  Verifica se o status de resposta 204 (No Content) é retornado após a exclusão.
     */
    @Test
    void testDeleteEndereco() {
        ResponseEntity<Void> response = enderecoController.deleteEndereco(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    /**
     * Verifica se a lista de endereços filtrados é retornada corretamente com base nos parâmetros fornecidos.
     */
    @Test
    void testGetEnderecoByDetails() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);

        when(enderecoService.findByEstadoAndCidadeAndLogradouroAndNumero(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(enderecos);

        ResponseEntity<List<Endereco>> response = enderecoController.getEnderecoByDetails("SP", "São Paulo", "Avenida Paulista", "1000");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(enderecos, response.getBody());
    }
}
