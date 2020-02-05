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
import com.surittec.api.models.Endereco;
import com.surittec.api.repositories.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	private EnderecoRepository enderecos;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ENDERECO')")
	public ResponseEntity<?> listar() {
		List<Endereco> resultado = enderecos.findAll();
		return !resultado.isEmpty() ? ResponseEntity.ok(resultado) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ENDERECO')")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Optional<Endereco> busca = enderecos.findById(id);
		return busca != null ? ResponseEntity.ok(busca) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ENDERECO')")
	public ResponseEntity<Endereco> adicionar(@Valid @RequestBody Endereco Endereco, HttpServletResponse response) {
		Endereco salvo = enderecos.save(Endereco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ENDERECO')")
	public ResponseEntity<Endereco> atualizarNome(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
		Optional<Endereco> old = enderecos.findById(id);	
		if (old.isPresent()) {
			Endereco atualizado = old.get();
			atualizado.setCep(endereco.getCep());
			atualizado.setLogradouro(endereco.getLogradouro());
			atualizado.setBairro(endereco.getBairro());
			atualizado.setCidade(endereco.getCidade());
			enderecos.save(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.notFound().build();
	}
}
