package com.turn2C.teste.controllers;

import com.turn2C.teste.dto.EnderecoDTO;
import com.turn2C.teste.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/api/enderecos")
public class EnderecoController {
    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDTO createRoutine(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        EnderecoDTO enderecoSalvo = enderecoService.cadastrarEndereco(enderecoDTO);
        return enderecoSalvo;

    }
}
