package com.codex.aposta.controller;

import com.codex.aposta.model.dto.ApostaIn;
import com.codex.aposta.model.dto.ApostaOut;
import com.codex.aposta.service.ApostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class ApostaController {

    private final ApostaService apostaService;

    @PostMapping("/aposta")
    public ResponseEntity<ApostaOut> salvaAposta(@RequestBody ApostaIn apostaIn){
        ApostaOut apostaOut = apostaService.salvaAposta(apostaIn);

        return ResponseEntity.status(CREATED).body(apostaOut);
    }
}
