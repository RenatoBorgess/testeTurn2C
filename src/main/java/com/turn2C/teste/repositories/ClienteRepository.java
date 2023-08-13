package com.turn2C.teste.repositories;

import com.turn2C.teste.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
