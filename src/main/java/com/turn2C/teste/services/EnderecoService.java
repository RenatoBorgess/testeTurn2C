package com.turn2C.teste.services;

import com.turn2C.teste.domain.Cliente;
import com.turn2C.teste.domain.Endereco;
import com.turn2C.teste.dto.EnderecoDTO;
import com.turn2C.teste.repositories.ClienteRepository;
import com.turn2C.teste.repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;

    }
    @Autowired
    ClienteRepository clienteRepository;



    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco novoEndereco = new Endereco();

        BeanUtils.copyProperties(enderecoDTO, novoEndereco);


        Optional<Cliente> cliente = clienteRepository.findById(enderecoDTO.getCliente().getId());

        novoEndereco.setCliente(cliente.get());

        Endereco enderecoSalvo = enderecoRepository.save(novoEndereco);

        EnderecoDTO enderecoSalvoDTO = new EnderecoDTO();
        BeanUtils.copyProperties(enderecoSalvo, enderecoSalvoDTO);

        return enderecoSalvoDTO;
    }

}
