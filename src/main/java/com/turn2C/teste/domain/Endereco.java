package com.turn2C.teste.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String bairro;
    private String logradouro;
    private Long cep;
    private Long numero;
    private String cidade;
    private String uf;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
