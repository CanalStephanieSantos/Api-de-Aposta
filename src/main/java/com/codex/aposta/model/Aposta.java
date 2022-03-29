package com.codex.aposta.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aposta {

    @Id @NotBlank
    private String numeroAposta;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Apostador apostador;
}
