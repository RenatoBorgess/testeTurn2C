package com.turn2C.teste.dto;

import com.turn2C.teste.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO {

    private Cliente cliente;
    private String bairro;
    private String logradouro;
    private Long cep;
    private Long numero;
    private String cidade;
    private String uf;

}
