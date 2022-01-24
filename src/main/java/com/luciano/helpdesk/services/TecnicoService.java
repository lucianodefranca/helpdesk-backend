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

    public Tecnico update(Integer id, TecnicoDTO objDTO) {
        Tecnico oldObj = findById(id);

        if (findByCpf(objDTO) != null && findByCpf(objDTO).getId() != id) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }

        oldObj.setNome(objDTO.getNome());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setTelefone(objDTO.getTelefone());

        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Tecnico obj = findById(id);

        if (obj.getChamados().size() > 0) {
            throw new DataIntegratyViolationException("Técnico possui ordens de serviço, não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private Tecnico findByCpf(TecnicoDTO objDTO) {
        Tecnico obj = repository.findByCpf(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }


}
