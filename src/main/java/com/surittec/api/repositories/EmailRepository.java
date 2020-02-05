package com.surittec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surittec.api.models.EmailCliente;

public interface EmailRepository  extends JpaRepository<EmailCliente, Long>{

}
