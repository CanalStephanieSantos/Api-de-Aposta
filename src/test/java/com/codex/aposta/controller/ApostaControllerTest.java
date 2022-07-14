package com.codex.aposta.controller;

import com.codex.aposta.controller.ApostaController;
import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.model.dto.ApostaOut;
import com.codex.aposta.model.dto.ApostasOut;
import com.codex.aposta.service.ApostaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
class ApostaControllerTest {

    @InjectMocks
    private ApostaController apostaController;

    @Mock
    private ApostaService apostaService;
    private ApostaIn apostaIn;
    private ApostaOut apostaOut;
    private ResponseEntity<ApostaOut> respostaApostaSucesso;
    private List<ApostasOut> listaApostaOut;

    @BeforeEach
    void setup() {
        apostaIn = new ApostaIn(1L);
        apostaOut = new ApostaOut("123456", "Stephanie Santos", "stephanie@gmail.com");
        respostaApostaSucesso = ResponseEntity.status(CREATED).body(apostaOut);
        listaApostaOut = List.of(new ApostasOut("123456", 1L));
    }

    @Test
    void deveSalvarAposta() {
        when(apostaService.salvaAposta(apostaIn)).thenReturn(apostaOut);
        var response = assertDoesNotThrow(() -> apostaController.salvaAposta(apostaIn));
        assertNotNull(response);
        assertEquals(respostaApostaSucesso, response);
    }

    @Test
    void deveBuscarApostasPorIdApostador() {
        when(apostaService.buscaApostasPorIdApostador(1L)).thenReturn(listaApostaOut);
        var response = assertDoesNotThrow(() -> apostaController.buscaApostasPorIdApostador(1L));
        assertNotNull(response);
    }
}