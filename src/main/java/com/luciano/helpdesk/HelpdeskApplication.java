package com.luciano.helpdesk;

import com.luciano.helpdesk.entities.Chamado;
import com.luciano.helpdesk.entities.Cliente;
import com.luciano.helpdesk.entities.Tecnico;
import com.luciano.helpdesk.entities.enums.Prioridade;
import com.luciano.helpdesk.entities.enums.Status;
import com.luciano.helpdesk.repositories.ChamadoRepository;
import com.luciano.helpdesk.repositories.ClienteRepository;
import com.luciano.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}
}
