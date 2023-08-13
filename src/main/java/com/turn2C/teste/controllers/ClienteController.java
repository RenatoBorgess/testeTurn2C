package com.turn2C.teste.controllers;

import com.turn2C.teste.dto.ClienteDTO;
import com.turn2C.teste.dto.EnderecoDTO;
import com.turn2C.teste.services.ClienteService;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ClienteDTO cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        ClienteDTO infoClienteSalvo = clienteService.cadastrarCliente(clienteDTO);
        return infoClienteSalvo;
    }
    @GetMapping
    public List<ClienteDTO> listarClientes(){
        return clienteService.listarClientes();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(clienteDTO);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteDTO> buscarClientePorEmail(@PathVariable @Email String email) {
        ClienteDTO clienteDTO = clienteService.buscarClientePorEmail(email);
        return ResponseEntity.ok(clienteDTO);
    }
    @PutMapping()
    public ResponseEntity<ClienteDTO> atualizarCliente(Long id, @RequestBody @Valid ClienteDTO clienteDTO){
        ClienteDTO clienteatualizado = clienteService.atualizerCliente(id ,clienteDTO);
        return ResponseEntity.ok(clienteatualizado);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarCliente(Long id){
        clienteService.deletarCliente(id);
    }
}

