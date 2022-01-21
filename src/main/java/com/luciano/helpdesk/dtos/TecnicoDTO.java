package com.luciano.helpdesk.dtos;

import com.luciano.helpdesk.entities.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public class TecnicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    @CPF
    private String cpf;
    private String telefone;

    public TecnicoDTO() {
        super();
    }

    public TecnicoDTO(Tecnico dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.telefone = dto.getTelefone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
