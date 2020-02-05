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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surittec.api.event.RecursoCriadoEvent;
import com.surittec.api.models.Estado;
import com.surittec.api.repositories.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	@Autowired
	private EstadoRepository estados;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESTADO')")
	public ResponseEntity<?> listar() {
		List<Estado> resultado = estados.findAll();
		return !resultado.isEmpty() ? ResponseEntity.ok(resultado) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ESTADO')")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Optional<Estado> busca = estados.findById(id);
		return busca != null ? ResponseEntity.ok(busca) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESTADO')")
	public ResponseEntity<Estado> adicionar(@Valid @RequestBody Estado estado, HttpServletResponse response) {
		Estado salvo = estados.save(estado);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@PutMapping("/{id}/nome")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESTADO')")
	public ResponseEntity<Estado> atualizarNome(@PathVariable Long id, @Valid @RequestBody String nome) {
		Optional<Estado> old = estados.findById(id);	
		if (old.isPresent()) {
			Estado atualizado = old.get();
			atualizado.setNome(nome);
			estados.save(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
