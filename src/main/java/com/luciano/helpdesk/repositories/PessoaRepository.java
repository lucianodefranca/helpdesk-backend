package com.luciano.helpdesk.repositories;

import com.luciano.helpdesk.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query(value = "SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
    Pessoa findByCpf(@Param(value = "cpf") String cpf);
}
