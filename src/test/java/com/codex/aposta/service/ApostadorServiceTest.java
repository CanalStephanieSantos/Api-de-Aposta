package com.codex.aposta.service;

import com.codex.aposta.model.dto.ApostadorIn;
import com.codex.aposta.repository.ApostadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class ApostadorServiceTest {

    @InjectMocks
    private ApostadorService apostadorService;

    @Mock
    private ApostadorRepository apostadorRepository;

    @Mock
    private ModelMapper modelMapper;

    private ApostadorIn apostadorIn;

    @BeforeEach
    void setup() {
        apostadorIn = new ApostadorIn("Stephanie Santos", "stephanie@gmail.com");
    }

    @Test
    void deveSalvarApostador() {
        assertDoesNotThrow(() -> apostadorService.salvaApostador(apostadorIn));
    }
}
