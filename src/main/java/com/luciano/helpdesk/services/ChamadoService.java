package com.luciano.helpdesk.services;

import com.luciano.helpdesk.entities.Chamado;
import com.luciano.helpdesk.repositories.ChamadoRepository;
import com.luciano.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamado = repository.findById(id);
        return chamado.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + " ,Tipo: " + Chamado.class.getName()));
    }
}
