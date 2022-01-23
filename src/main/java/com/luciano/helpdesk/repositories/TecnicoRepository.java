package com.luciano.helpdesk.repositories;

import com.luciano.helpdesk.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

    @Query(value = "SELECT obj FROM Tecnico obj WHERE obj.cpf =:cpf")
    Tecnico findByCpf(@Param(value = "cpf") String cpf);
}
