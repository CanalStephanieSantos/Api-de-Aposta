package com.codex.aposta.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ApostadorIn {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
}
