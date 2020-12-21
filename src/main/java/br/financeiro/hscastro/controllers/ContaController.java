package br.financeiro.hscastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.financeiro.hscastro.domain.Conta;
import br.financeiro.hscastro.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService serviceConta;
	
	

	@GetMapping("/editar/{id}")
	public Conta getContaPorId(@PathVariable Long id) {
		
		return (Conta) serviceConta.buscarPorId(id);
	}

	
	@GetMapping("/listar")
	public List<Conta> getConta() {
		
		return serviceConta.listar();
	}
}
