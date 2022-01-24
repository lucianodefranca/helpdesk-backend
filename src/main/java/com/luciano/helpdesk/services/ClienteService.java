package com.luciano.helpdesk.services;

import com.luciano.helpdesk.dtos.ClienteDTO;
import com.luciano.helpdesk.entities.Cliente;
import com.luciano.helpdesk.entities.Pessoa;
import com.luciano.helpdesk.repositories.ClienteRepository;
import com.luciano.helpdesk.repositories.PessoaRepository;
import com.luciano.helpdesk.services.exceptions.DataIntegratyViolationException;
import com.luciano.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        if (findByCpf(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
    }

    public Cliente update(Integer id, ClienteDTO objDTO) {
        Cliente oldObj = findById(id);

        if (findByCpf(objDTO) != null && findByCpf(objDTO).getId() != id) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }

        oldObj.setNome(objDTO.getNome());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setTelefone(objDTO.getTelefone());

        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);

        if (obj.getChamados().size() > 0) {
            throw new DataIntegratyViolationException("Cliente possui ordens de serviço, não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private Pessoa findByCpf(ClienteDTO objDTO) {
        Pessoa obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }


}
