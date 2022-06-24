package com.codex.aposta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class ApostadorIn {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
}
