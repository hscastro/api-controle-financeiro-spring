package br.financeiro.hscastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.financeiro.hscastro.domain.Cliente;
import br.financeiro.hscastro.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService<Cliente> serviceCliente;
	
	@GetMapping	
	public String getHello() {
		return "Hello world";
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		serviceCliente.salvar(cliente);
		return new ResponseEntity<>(cliente,HttpStatus.OK); 
	}

	@GetMapping("/editar/{id}")
	public Cliente getClientePorId(@PathVariable Long id) {
		
		return serviceCliente.buscarPorId(id);
	}

	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> getCliente() {
		//System.out.println("teste");
		List<Cliente> todosClientes = serviceCliente.listar(); 
		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
	}
	
}
