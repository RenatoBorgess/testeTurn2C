package com.turn2C.teste.services;

import com.turn2C.teste.domain.Cliente;
import com.turn2C.teste.dto.ClienteDTO;
import com.turn2C.teste.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    private ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }



    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente novoCliente = MODEL_MAPPER.map(clienteDTO, Cliente.class);
        Cliente clienteCadastrado = clienteRepository.save(novoCliente);
        ClienteDTO clienteSalvoDTO = MODEL_MAPPER.map(clienteCadastrado, ClienteDTO.class);

        return clienteSalvoDTO;
    }
}
