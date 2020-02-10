package com.surittec.api.controllers;

import java.util.ArrayList;
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
import com.surittec.api.models.Cliente;
import com.surittec.api.models.EmailCliente;
import com.surittec.api.models.TelefoneCliente;
import com.surittec.api.repositories.ClienteRepository;
import com.surittec.api.repositories.EmailRepository;
import com.surittec.api.repositories.TelefoneRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clientes;
	
	@Autowired
	private TelefoneRepository telefones;
	
	@Autowired
	private EmailRepository emails;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE')")
	public ResponseEntity<?> listar() {
		List<Cliente> resultado = clientes.findAll();
		return !resultado.isEmpty() ? ResponseEntity.ok(resultado) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE')")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
		Optional<Cliente> busca = clientes.findById(id);
		return busca.isPresent() ? ResponseEntity.ok(busca) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/telefones")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE')")
	public List<TelefoneCliente> buscarTelefones(@PathVariable Long id) {
		List<TelefoneCliente> resultado = new ArrayList<>();
		Optional<Cliente> buscarCliente = clientes.findById(id);
		if (buscarCliente.isPresent()) {
			Cliente cliente = buscarCliente.get();
			List<TelefoneCliente> lista = telefones.findAll();
			for (TelefoneCliente fone : lista) {
				if (fone.getCliente().equals(cliente)) {
					resultado.add(fone);
				}
			} return resultado;
		}
		
		return null;
		
	}
	
	@GetMapping("/{id}/emails")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE')")
	public List<EmailCliente> buscarEmails(@PathVariable Long id) {
		List<EmailCliente> resultado = new ArrayList<>();
		Optional<Cliente> buscarCliente = clientes.findById(id);
		if (buscarCliente.isPresent()) {
			Cliente cliente = buscarCliente.get();
			List<EmailCliente> lista = emails.findAll();
			for (EmailCliente email : lista) {
				if (email.getCliente().equals(cliente)) {
					resultado.add(email);
				}
			} return resultado;
		}
		
		return null;
		
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLIENTE')")
	public ResponseEntity<Cliente> adicionar(@Valid @RequestBody Cliente Cliente, HttpServletResponse response) {
		Cliente salvo = clientes.save(Cliente);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLIENTE')")
	public ResponseEntity<Cliente> atualizarNome(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Optional<Cliente> old = clientes.findById(id);	
		if (old.isPresent()) {
			Cliente atualizado = old.get();
			atualizado.setNome(cliente.getNome());
			atualizado.setCpf(cliente.getCpf());
			atualizado.setEndereco(cliente.getEndereco());
			clientes.save(atualizado);
			return ResponseEntity.ok(atualizado);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_DELETAR_CLIENTE')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		List<TelefoneCliente> listaFones = buscarTelefones(id);
		for (TelefoneCliente fone : listaFones) {
			telefones.deleteById(fone.getId());
		}
		List<EmailCliente> listaEmails = buscarEmails(id);
		for (EmailCliente email : listaEmails) {
			emails.deleteById(email.getId());
		}
		clientes.deleteById(id);
	}
}
