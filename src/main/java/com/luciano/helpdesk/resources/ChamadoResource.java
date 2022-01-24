package com.luciano.helpdesk.resources;

import com.luciano.helpdesk.dtos.ChamadoDTO;
import com.luciano.helpdesk.entities.Chamado;
import com.luciano.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

    @Autowired
    private ChamadoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        ChamadoDTO obj = new ChamadoDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }
}
