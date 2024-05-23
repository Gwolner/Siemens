package br.com.desafio.siemens.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.desafio.siemens.model.classes.Cidade;
import br.com.desafio.siemens.model.classes.Cliente;
import br.com.desafio.siemens.model.repositorios.Fachada;

@RestController
public class ClienteRestController {
	
	@CrossOrigin(origins = "*")
	@PostMapping("/Cliente")
	public ResponseEntity<?> inserir(@RequestBody Cliente cliente) {	
		
		Cidade cidade;
		
		try {
			cidade = Fachada.getCurrentInstance().lerCidadePorId(cliente.getCidade().getIdCidade());
			
			cliente.setCidade(cidade);
			
			Fachada.getCurrentInstance().inserirCliente(cliente);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao cadastrar Cliente.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/Cliente")
	public ResponseEntity<?> alterar(@RequestBody Cliente cliente) {		
		try {			
			Fachada.getCurrentInstance().alterarCliente(cliente);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar cliente.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Cliente/{idCliente}")
	public ResponseEntity<Cliente> lerId(@PathVariable("idCliente") int idCliente) {	
		
		Cliente cliente;
		
		try {			
			cliente = Fachada.getCurrentInstance().lerClientePorId(idCliente);
			
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao buscar cliente.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Cliente/nome/{nomeCompleto}")	
	public ResponseEntity<List<Cliente>> lerNome(@PathVariable("nomeCompleto") String nomeCompleto) {	
		
		List<Cliente> clientes;
		
		try {			
			clientes = Fachada.getCurrentInstance().lerClientePorNome(nomeCompleto);
			
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao buscar cliente.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/Cliente/{idCliente}")
	public ResponseEntity<Cliente> deletar(@PathVariable("idCliente") int idCliente) {		
		try {			
			Fachada.getCurrentInstance().deletarCliente(idCliente);
			
			return new ResponseEntity<Cliente>(HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar cliente.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Clientes")
	public ResponseEntity<List<Cliente>> lerTodos() {	
		
		List<Cliente> clientes;
		
		try {			
			clientes = Fachada.getCurrentInstance().ListarClientes();
			
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao listar cliente.");
		}		
	}
}
