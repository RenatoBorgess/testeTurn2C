package com.turn2C.teste.controllers;

import com.turn2C.teste.dto.ClienteDTO;
import com.turn2C.teste.dto.EnderecoDTO;
import com.turn2C.teste.dto.EnderecoEditDTO;
import com.turn2C.teste.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/enderecos")
public class EnderecoController {
    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDTO createRoutine(@RequestBody  EnderecoDTO enderecoDTO) {
        EnderecoDTO enderecoSalvo = enderecoService.cadastrarEndereco(enderecoDTO);
        return enderecoSalvo;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        EnderecoDTO enderecoDTO = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping(path = "/cliente")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorCliente(Long id) {
        EnderecoDTO enderecoDTO = enderecoService.buscarEnderecoPorCliente(id);
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping
    public List<EnderecoDTO> listarEndereco(){
        return enderecoService.listarEndereco();
    }

    @PutMapping()
    public ResponseEntity<EnderecoEditDTO> atualizarCliente(Long id, @RequestBody EnderecoEditDTO enderecoDTO){
        EnderecoEditDTO enderecoatualizado = enderecoService.atualizarEndereco(id ,enderecoDTO);
        return ResponseEntity.ok(enderecoatualizado);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarEndereço(Long id){
        enderecoService.deletarEndereco(id);
    }
}
