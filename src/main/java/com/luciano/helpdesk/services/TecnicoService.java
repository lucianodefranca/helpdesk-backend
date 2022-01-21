package com.luciano.helpdesk.services;

import com.luciano.helpdesk.dtos.TecnicoDTO;
import com.luciano.helpdesk.entities.Tecnico;
import com.luciano.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
