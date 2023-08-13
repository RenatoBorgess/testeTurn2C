package com.turn2C.teste.services;

import com.turn2C.teste.domain.Cliente;
import com.turn2C.teste.domain.Endereco;
import com.turn2C.teste.dto.ClienteDTO;
import com.turn2C.teste.dto.EnderecoDTO;
import com.turn2C.teste.dto.EnderecoEditDTO;
import com.turn2C.teste.repositories.ClienteRepository;
import com.turn2C.teste.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
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


    public EnderecoDTO buscarEnderecoPorId(@PathVariable Long id){
      Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
      if(enderecoOptional.isEmpty()){
          throw new EntityNotFoundException("Endereço nao encontrado com Id: " + id);
      } else {
          EnderecoDTO enderecoEncontrado = new EnderecoDTO();
          BeanUtils.copyProperties(enderecoOptional.get(), enderecoEncontrado);

          return enderecoEncontrado;
      }

    }

    public EnderecoEditDTO atualizarEndereco(Long id, EnderecoEditDTO enderecoDTO) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if(enderecoOptional.isEmpty()){
            throw new EntityNotFoundException("Endereço nao encontrado com Id: " + id);
        } else {
            Endereco enderecoEncontrado = enderecoOptional.get();
            BeanUtils.copyProperties(enderecoDTO, enderecoEncontrado);

            Endereco enderecoSalvo = enderecoRepository.save(enderecoEncontrado);

            EnderecoEditDTO enderecoSalvoDTO = new EnderecoEditDTO();

            BeanUtils.copyProperties(enderecoSalvo,enderecoSalvoDTO);

            return enderecoSalvoDTO;
        }
    }
    @Transactional
    public void deletarEndereco(Long id){
    Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if(enderecoOptional.isEmpty()){
        throw new EntityNotFoundException("Endereço nao encontrado com Id: " + id);
    } else {
        Endereco enderecoEncontrado = enderecoOptional.get();
        enderecoRepository.delete(enderecoEncontrado);
        }
}

    @Transactional
    public EnderecoDTO buscarEnderecoPorCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        Optional<Endereco> enderecoOptional = enderecoRepository.findByCliente(clienteOptional.get());
        Endereco enderecoEncontrado = enderecoOptional.get();
        EnderecoDTO enderecoEncontradoDTO = new EnderecoDTO();
        BeanUtils.copyProperties(enderecoEncontrado, enderecoEncontradoDTO);
        return enderecoEncontradoDTO;
    }

    public List<EnderecoDTO> listarEndereco() {

            List<EnderecoDTO> enderecosExistentes = new ArrayList<>();
            List<Endereco> listaDeEnderecos = enderecoRepository.findAll();
            for (Endereco endereco : listaDeEnderecos
            ) {
                EnderecoDTO enderecoListado = new EnderecoDTO();
                BeanUtils.copyProperties(endereco, enderecoListado);
                enderecosExistentes.add(enderecoListado);
            }
            return enderecosExistentes;
        }
    }



