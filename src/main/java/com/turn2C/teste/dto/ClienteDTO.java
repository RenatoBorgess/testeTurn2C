package com.turn2C.teste.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ClienteDTO {

    private String nome;
    @Email
    private String email;
    @Size(max = 11, min = 11)
    private String cpf;
}
