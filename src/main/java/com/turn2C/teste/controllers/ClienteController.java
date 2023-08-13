package com.turn2C.teste.controllers;

import com.turn2C.teste.dto.ClienteDTO;
import com.turn2C.teste.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/api/clientes")
public class ClienteController {

    private ClienteService clienteService;
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO infoClienteSalvo = clienteService.cadastrarCliente(clienteDTO);
        return infoClienteSalvo;
    }
}
