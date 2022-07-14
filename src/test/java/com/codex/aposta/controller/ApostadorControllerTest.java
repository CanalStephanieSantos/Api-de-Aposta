package com.codex.aposta.controller;

import com.codex.aposta.model.dto.ApostadorIn;
import com.codex.aposta.service.ApostadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
class ApostadorControllerTest {

    @InjectMocks
    private ApostadorController apostadorController;

    @Mock
    private ApostadorService apostadorService;

    private ApostadorIn apostadorIn;

    private ResponseEntity<Object> statusCriadoComSucesso;

    @BeforeEach
    void setup() {
        apostadorIn = new ApostadorIn("Stephanie Santos", "stephanie@gmail.com");
        statusCriadoComSucesso = ResponseEntity.status(CREATED).build();
    }

    @Test
    void deveSalvarApostador() {
        var response = assertDoesNotThrow(() -> apostadorController.salvarApostador(apostadorIn));
        assertNotNull(response);
        assertEquals(statusCriadoComSucesso, response);
    }
}
