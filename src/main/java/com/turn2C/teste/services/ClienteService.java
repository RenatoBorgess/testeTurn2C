package com.turn2C.teste.services;

import com.turn2C.teste.domain.Cliente;
import com.turn2C.teste.dto.ClienteDTO;
import com.turn2C.teste.repositories.ClienteRepository;
import com.turn2C.teste.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente novoCliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, novoCliente);
        Cliente clienteCadastrado = clienteRepository.save(novoCliente);
        ClienteDTO clienteSalvoDTO = new ClienteDTO();
        BeanUtils.copyProperties(clienteCadastrado, clienteSalvoDTO);

        return clienteSalvoDTO;
    }

    public ClienteDTO buscarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new EntityNotFoundException("Cliente nao encontrado com Id: " + id);
        } else {
            ClienteDTO clienteEncontrado = new ClienteDTO();
            BeanUtils.copyProperties(clienteOptional.get(), clienteEncontrado);

            return clienteEncontrado;
        }
    }
   public ClienteDTO buscarClientePorEmail(String email) {
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(email);
        if (clienteOptional.isEmpty()) {
            throw new EntityNotFoundException("Cliente nao encontrado com email: " + email);
        } else {
            ClienteDTO clienteEncontrado = new ClienteDTO();
            BeanUtils.copyProperties(clienteOptional.get(), clienteEncontrado);

            return clienteEncontrado;
        }
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientesExistentes = new ArrayList<>();
        List<Cliente> listaDeClientes = clienteRepository.findAll();
        for (Cliente cliente : listaDeClientes
        ) {
            ClienteDTO clienteListado = new ClienteDTO();
            BeanUtils.copyProperties(cliente, clienteListado);
            clientesExistentes.add(clienteListado);
        }
        return clientesExistentes;
    }


    @Transactional
    public ClienteDTO atualizerCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new EntityNotFoundException("Cliente nao encontrado com Id: " + id);
        } else {
            Cliente clienteEncontrado = clienteOptional.get();
            BeanUtils.copyProperties(clienteDTO, clienteEncontrado);

            Cliente clienteSalvo = clienteRepository.save(clienteEncontrado);

            ClienteDTO clienteSalvoDTO = new ClienteDTO();

            BeanUtils.copyProperties(clienteSalvo, clienteSalvoDTO);

            return clienteSalvoDTO;
        }
    }
    @Transactional
    public void deletarCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new EntityNotFoundException("Cliente nao encontrado com Id: " + id);
        } else {
            Cliente clienteEncontrado = clienteOptional.get();
            enderecoRepository.deleteByCliente(clienteEncontrado);
            clienteRepository.delete(clienteEncontrado);
        }
    }
}

