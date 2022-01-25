package com.luciano.helpdesk.services;

import com.luciano.helpdesk.dtos.ChamadoDTO;
import com.luciano.helpdesk.dtos.TecnicoDTO;
import com.luciano.helpdesk.entities.Chamado;
import com.luciano.helpdesk.entities.Cliente;
import com.luciano.helpdesk.entities.Tecnico;
import com.luciano.helpdesk.entities.enums.Prioridade;
import com.luciano.helpdesk.entities.enums.Status;
import com.luciano.helpdesk.repositories.ChamadoRepository;
import com.luciano.helpdesk.repositories.ClienteRepository;
import com.luciano.helpdesk.repositories.TecnicoRepository;
import com.luciano.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamado = repository.findById(id);
        return chamado.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + " ,Tipo: " + Chamado.class.getName()));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO obj) {
        return fromDTO(obj);
    }

    private Chamado fromDTO(ChamadoDTO obj) {

        Chamado newObj = new Chamado();
        newObj.setId(obj.getId());
        newObj.setObservacoes(obj.getObservacoes());
        newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        newObj.setStatus(Status.toEnum(obj.getStatus()));

        Tecnico tec = tecnicoService.findById(obj.getTecnico());
        Cliente cli = clienteService.findById(obj.getCliente());

        newObj.setTecnico(tec);
        newObj.setCliente(cli);

        return repository.save(newObj);
    }
}
