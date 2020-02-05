package com.surittec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surittec.api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
