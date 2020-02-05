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
import com.surittec.api.models.TelefoneCliente;
import com.surittec.api.repositories.TelefoneRepository;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
	@Autowired
	private TelefoneRepository telefones;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TELEFONE')")
	public ResponseEntity<?> listar() {
		List<TelefoneCliente> resultado = telefones.findAll();
		return !resultado.isEmpty() ? ResponseEntity.ok(resultado) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TELEFONE')")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Optional<TelefoneCliente> busca = telefones.findById(id);
		return busca != null ? ResponseEntity.ok(busca) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TELEFONE')")
	public ResponseEntity<TelefoneCliente> adicionar(@Valid @RequestBody TelefoneCliente TelefoneCliente, HttpServletResponse response) {
		TelefoneCliente salvo = telefones.save(TelefoneCliente);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TELEFONE')")
	public ResponseEntity<TelefoneCliente> atualizarNome(@PathVariable Long id, @Valid @RequestBody TelefoneCliente telefone) {
		Optional<TelefoneCliente> old = telefones.findById(id);	
		if (old.isPresent()) {
			TelefoneCliente atualizado = old.get();
			atualizado.setTipo(telefone.getTipo());
			atualizado.setNumero(telefone.getNumero());
			atualizado.setCliente(telefone.getCliente());
			telefones.save(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_TELEFONE')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		telefones.deleteById(id);
	}
}
