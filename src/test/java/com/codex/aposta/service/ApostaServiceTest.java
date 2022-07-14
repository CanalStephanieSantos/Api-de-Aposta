package com.codex.aposta.service;

import com.codex.aposta.model.Aposta;
import com.codex.aposta.model.Apostador;
import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.repository.ApostaRepository;
import com.codex.aposta.repository.ApostadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApostaServiceTest {

    @InjectMocks
    private ApostaService apostaService;

    @Mock
    private ApostaRepository apostaRepository;

    @Mock
    private ApostadorRepository apostadorRepository;

    private ApostaIn apostaIn;

    private Aposta aposta;

    private Apostador apostador;

    private List<Aposta> listaAposta;

    @BeforeEach
    void setup() {
        apostaIn = new ApostaIn(1L);
        apostador = new Apostador(1L, "Stephanie Santos", "stephanie@gmail.com");
        aposta = new Aposta("123456", apostador);
        listaAposta = Arrays.asList(aposta, aposta);
    }

    @Test
    void deveSalvarAposta() {
        when(apostadorRepository.findById(1L)).thenReturn(Optional.of(apostador));
        var response = assertDoesNotThrow(() -> apostaService.salvaAposta(apostaIn));
        assertNotNull(response);
    }

    @Test
    void deveLancarExceptionCasoIdApostadorInexistente() {
        var response = assertThrows(ResponseStatusException.class, () -> apostaService.salvaAposta(apostaIn));
        assertEquals("404 NOT_FOUND", response.getMessage());
    }

    @Test
    void deveBuscarApostasPorIdApostador() {
        when(apostaRepository.findByIdApostador(1L)).thenReturn(listaAposta);
        var response = assertDoesNotThrow(() -> apostaService.buscaApostasPorIdApostador(1L));
        assertFalse(response.isEmpty());
    }
}
