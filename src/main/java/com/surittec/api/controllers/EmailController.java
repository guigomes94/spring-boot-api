package com.surittec.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.surittec.api.event.RecursoCriadoEvent;
import com.surittec.api.models.EmailCliente;
import com.surittec.api.repositories.EmailRepository;

@RestController
@RequestMapping("/emails")
public class EmailController {
	@Autowired
	private EmailRepository emails;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMAIL')")
	public ResponseEntity<?> listar() {
		List<EmailCliente> resultado = emails.findAll();
		return !resultado.isEmpty() ? ResponseEntity.ok(resultado) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_EMAIL')")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Optional<EmailCliente> busca = emails.findById(id);
		return busca.isPresent() ? ResponseEntity.ok(busca) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMAIL')")
	public ResponseEntity<EmailCliente> adicionar(@Valid @RequestBody EmailCliente EmailCliente, HttpServletResponse response) {
		EmailCliente salvo = emails.save(EmailCliente);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_EMAIL')")
	public ResponseEntity<EmailCliente> atualizarNome(@PathVariable Long id, @Valid @RequestBody EmailCliente email) {
		Optional<EmailCliente> old = emails.findById(id);	
		if (old.isPresent()) {
			EmailCliente atualizado = old.get();
			atualizado.setEmail(email.getEmail());
			atualizado.setCliente(email.getCliente());
			emails.save(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_EMAIL')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		emails.deleteById(id);
	}
}
