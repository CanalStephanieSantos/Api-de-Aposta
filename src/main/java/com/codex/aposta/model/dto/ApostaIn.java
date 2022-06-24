package com.codex.aposta.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApostaIn {

    @NotNull
    private Long idApostador;
}
