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
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico t1 = new Tecnico(null, "Luciano Franca", "395.126.690-21", "(41) 99999-1234");
		Cliente c1 = new Cliente(null, "Barbara evelyn", "287.471.760-67", "(41) 98888-1234");

		Chamado os1 = new Chamado(null, Prioridade.ALTA, "Teste criacao OS", Status.ANDAMENTO, t1, c1);

		t1.getChamados().add(os1);
		c1.getChamados().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));

		chamadoRepository.saveAll(Arrays.asList(os1));

	}
}
