package com.example.selecaocasapopular.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.selecaocasapopular.Entity.Endereco;
import com.example.selecaocasapopular.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testa se salva corretamente um Endereco e o retorna.
     */
    @Test
    void testSave() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);

        Endereco result = enderecoService.save(endereco);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(enderecoRepository, times(1)).save(endereco);
    }

    /**
     * Testa se retorna a lista de Enderecos corretamente.
     */
    @Test
    void testFindAll() {
        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        List<Endereco> enderecos = Arrays.asList(endereco1, endereco2);
        when(enderecoRepository.findAll()).thenReturn(enderecos);

        List<Endereco> result = enderecoService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(enderecoRepository, times(1)).findAll();
    }

    /**
     * Testa se retorna o Endereco corretamente quando encontrado.
     */
    @Test
    void testFindById() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        when(enderecoRepository.findById(anyLong())).thenReturn(Optional.of(endereco));

        Endereco result = enderecoService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(enderecoRepository, times(1)).findById(anyLong());
    }

    /**
     * Testa se retorna null quando o Endereco não é encontrado.
     */
    @Test
    void testFindByIdNotFound() {
        when(enderecoRepository.findById(anyLong())).thenReturn(Optional.empty());

        Endereco result = enderecoService.findById(1L);

        assertNull(result);
        verify(enderecoRepository, times(1)).findById(anyLong());
    }

    /**
     * Chama o método deleteById do EnderecoRepository.
     */
    @Test
    void testDeleteById() {
        doNothing().when(enderecoRepository).deleteById(anyLong());

        enderecoService.deleteById(1L);

        verify(enderecoRepository, times(1)).deleteById(anyLong());
    }

    /**
     * Testa se retorna a lista de Enderecos corretamente com base nos parâmetros fornecidos.
     */
    @Test
    void testFindByEstadoAndCidadeAndLogradouroAndNumero() {
        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        List<Endereco> enderecos = Arrays.asList(endereco1, endereco2);
        when(enderecoRepository.findByEstadoAndCidadeAndLogradouroAndNumero(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(enderecos);

        List<Endereco> result = enderecoService.findByEstadoAndCidadeAndLogradouroAndNumero("SP", "São Paulo", "Rua A", "123");

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(enderecoRepository, times(1)).findByEstadoAndCidadeAndLogradouroAndNumero("SP", "São Paulo", "Rua A", "123");
    }
}
