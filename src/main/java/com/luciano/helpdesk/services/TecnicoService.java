package com.luciano.helpdesk.services;

import com.luciano.helpdesk.dtos.TecnicoDTO;
import com.luciano.helpdesk.entities.Tecnico;
import com.luciano.helpdesk.repositories.TecnicoRepository;
import com.luciano.helpdesk.services.exceptions.DataIntegratyViolationException;
import com.luciano.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Tecnico.class.getName()));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        if (findByCpf(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
    }

    private Tecnico findByCpf(TecnicoDTO objDTO) {
        Tecnico obj = repository.findByCpf(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }
}
