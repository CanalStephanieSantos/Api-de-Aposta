package com.codex.aposta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApostaOut {

    private String numeroAposta;
    private String nomeApostador;
    private String emailApostador;
}
