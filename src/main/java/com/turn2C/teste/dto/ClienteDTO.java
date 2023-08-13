package com.turn2C.teste.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ClienteDTO {

    private String nome;
    private String email;
    private String cpf;
}
