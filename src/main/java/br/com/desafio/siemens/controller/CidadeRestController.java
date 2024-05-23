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
public class CidadeRestController {
	
	@CrossOrigin(origins = "*")
	@PostMapping("/Cidade")
	public ResponseEntity<?> inserir(@RequestBody  Cidade cidade) {		
		try {
			Fachada.getCurrentInstance().inserirCidade(cidade);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao cadastrar cidade.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/Cidade")
	public ResponseEntity<?> alterar(@RequestBody Cidade cidade) {		
		try {			
			Fachada.getCurrentInstance().alterarCidade(cidade);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao alterar cidade.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Cidade/{idCidade}")
	public ResponseEntity<Cidade> lerId(@PathVariable("idCidade") int idCidade) {	
		
		Cidade cidade;
		
		try {			
			cidade = Fachada.getCurrentInstance().lerCidadePorId(idCidade);
			
			return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao buscar cidade.");
		}		
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/Cidade/nome/{nomeCidade}")	
	public ResponseEntity<List<Cidade>> lerNome(@PathVariable("nomeCidade") String nomeCidade) {	
		
		List<Cidade> cidades;
		
		try {			
			cidades = Fachada.getCurrentInstance().lerCidadePorNome(nomeCidade);
			
			return new ResponseEntity<List<Cidade>>(cidades, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao buscar cidade.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Cidade/estado/{estado}")	
	public ResponseEntity<List<Cidade>> lerEstado(@PathVariable("estado") String estado) {	
		
		List<Cidade> cidades;
		
		try {			
			cidades = Fachada.getCurrentInstance().lerCidadePorEstado(estado);
			
			return new ResponseEntity<List<Cidade>>(cidades, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao buscar cidade.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/Cidade/{idCidade}")
	public ResponseEntity<Cidade> deletar(@PathVariable("idCidade") int idCidade) {		
		try {			
			Fachada.getCurrentInstance().deletarCidade(idCidade);
			
			return new ResponseEntity<Cidade>(HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao deletar cidade.");
		}		
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Cidades")
	public ResponseEntity<List<Cidade>> lerTodos() {	
		
		List<Cidade> cidades;
		
		try {			
			cidades = Fachada.getCurrentInstance().ListarCidades();
			
			return new ResponseEntity<List<Cidade>>(cidades, HttpStatus.OK);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha ao listar cidades.");
		}		
	}
	
}
