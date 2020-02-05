package com.surittec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surittec.api.models.TelefoneCliente;

public interface TelefoneRepository extends JpaRepository<TelefoneCliente, Long> {

}
