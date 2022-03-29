package com.codex.aposta.service;

import com.codex.aposta.model.Apostador;
import com.codex.aposta.model.dto.ApostadorIn;
import com.codex.aposta.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApostadorService {

    private final ApostadorRepository apostadorRepository;
    private final ModelMapper modelMapper;

    public void salvaApostador(ApostadorIn apostadorIn) {
        Apostador apostador = modelMapper.map(apostadorIn, Apostador.class);
        apostadorRepository.save(apostador);
    }
}
