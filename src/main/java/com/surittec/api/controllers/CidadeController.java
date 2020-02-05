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
import com.surittec.api.models.Cidade;
import com.surittec.api.repositories.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	@Autowired
	private CidadeRepository cidades;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CIDADE')")
	public ResponseEntity<?> listar() {
		List<Cidade> resultado = cidades.findAll();
		return !resultado.isEmpty() ? ResponseEntity.ok(resultado) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CIDADE')")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Optional<Cidade> busca = cidades.findById(id);
		return busca != null ? ResponseEntity.ok(busca) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CIDADE')")
	public ResponseEntity<Cidade> adicionar(@Valid @RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade salvo = cidades.save(cidade);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@PutMapping("/{id}/nome")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CIDADE')")
	public ResponseEntity<Cidade> atualizarNome(@PathVariable Long id, @Valid @RequestBody String nome) {
		Optional<Cidade> old = cidades.findById(id);	
		if (old.isPresent()) {
			Cidade atualizado = old.get();
			atualizado.setNome(nome);
			cidades.save(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.notFound().build();
	}

}
