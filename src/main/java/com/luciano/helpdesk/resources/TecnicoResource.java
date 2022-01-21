package com.luciano.helpdesk.resources;

import com.luciano.helpdesk.dtos.TecnicoDTO;
import com.luciano.helpdesk.entities.Tecnico;
import com.luciano.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        TecnicoDTO objDTO = new TecnicoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
}
