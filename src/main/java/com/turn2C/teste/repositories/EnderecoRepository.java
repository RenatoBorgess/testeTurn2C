package com.turn2C.teste.repositories;

import com.turn2C.teste.domain.Cliente;
import com.turn2C.teste.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    void deleteByCliente(Cliente cliente);
    Optional<Endereco> findByCliente(Cliente cliente);

}
