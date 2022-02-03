package com.luciano.helpdesk.services;

import com.luciano.helpdesk.entities.Chamado;
import com.luciano.helpdesk.entities.Cliente;
import com.luciano.helpdesk.entities.Tecnico;
import com.luciano.helpdesk.entities.enums.Prioridade;
import com.luciano.helpdesk.entities.enums.Status;
import com.luciano.helpdesk.repositories.ChamadoRepository;
import com.luciano.helpdesk.repositories.ClienteRepository;
import com.luciano.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean
    public void instanciaDB() {

        Tecnico t1 = new Tecnico(null, "Luciano Franca", "395.126.690-21", "(41) 99999-1234");
        Tecnico t2 = new Tecnico(null, "Renan Senne", "737.395.290-91", "(41) 98888-1234");
        Tecnico t3 = new Tecnico(null, "Alison de Franca", "542.951.880-85", "(41) 97777-1234");

        Cliente c1 = new Cliente(null, "Barbara evelyn", "287.471.760-67", "(41) 99988-1234");
        Cliente c2 = new Cliente(null, "Marcio de Souza", "706.647.120-29", "(41) 98899-4567");
        Cliente c3 = new Cliente(null, "Celia Lima", "740.185.500-30", "(41) 98912-4321");


        Chamado os1 = new Chamado(null, Prioridade.ALTA, "Moldem não liga", Status.ANDAMENTO, t1, c1);
        Chamado os2 = new Chamado(null, Prioridade.MEDIA, "Sem sinal virtua", Status.ABERTO, t3, c2);
        Chamado os3 = new Chamado(null, Prioridade.BAIXA, "Imagem quadriculando", Status.ABERTO, t2, c3);

        t1.getChamados().add(os1);
        c1.getChamados().add(os1);
        t2.getChamados().add(os3);
        c3.getChamados().add(os3);
        c2.getChamados().add(os2);
        t3.getChamados().add(os2);

        tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3));
        clienteRepository.saveAll(Arrays.asList(c1, c2, c3));

        chamadoRepository.saveAll(Arrays.asList(os1, os2, os3));
    }
}
