package com.codex.aposta.service;

import com.codex.aposta.model.Aposta;
import com.codex.aposta.model.Apostador;
import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.model.dto.ApostaOut;
import com.codex.aposta.repository.ApostaRepository;
import com.codex.aposta.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApostaService {

    private final ApostadorRepository apostadorRepository;
    private final ApostaRepository apostaRepository;

    public ApostaOut salvaAposta(ApostaIn apostaIn){
        Optional<Apostador> apostador = apostadorRepository.findById(apostaIn.getIdApostador());
        String numAposta = UUID.randomUUID().toString();
        Aposta aposta = new Aposta(numAposta, apostador.get());

        apostaRepository.save(aposta);

        return new ApostaOut(numAposta, apostador.get().getNome(), apostador.get().getEmail());
    }
}
