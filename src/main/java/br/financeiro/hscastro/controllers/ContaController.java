package br.financeiro.hscastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.financeiro.hscastro.domain.Conta;
import br.financeiro.hscastro.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	
	@Autowired
	private ContaService<Conta> serviceConta;
	
	@PostMapping("/salvar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void salvar(@RequestBody Conta conta) {
		serviceConta.salvar(conta);
	}	
	
	@GetMapping("/buscar/{id}")
	public Conta getContaPorId(@PathVariable Long id) {
		
		return (Conta) serviceConta.buscarPorId(id);
	}

	@GetMapping("/saldo/{id}")
	public double getSaldo(@PathVariable Long id) {
		Conta conta = serviceConta.buscarPorId(id);
		if(conta.getNumero().isEmpty()) {
			return 0.00;
		}else {
			return conta.getSaldo();
		}
	}
	
	@GetMapping("/verificar/{numero}")
	public Conta verificaConta(@PathVariable String numero, ModelMap model) {
		Conta conta = serviceConta.getContaPorNumero(numero);
		
		if(conta.getNumero().isEmpty()) {
			//model.addAttribute("fail", "Conta não encontrada. Por favor consultar a gerência.");
			return null;
		}else {
			//model.addAttribute("success", "Conta encontrada!");
			return conta;
		}
	}
	
	@PostMapping("/depositar")
	public String setDeposito(@RequestBody Long id, double valor) {
		Conta conta = serviceConta.buscarPorId(id);
		
		if(conta.getNumero().isEmpty()) {
			return "Erro [NUMERO] Deposito não efetivado";
		}else {
			conta.setSaldo(serviceConta.getNovoSaldo(conta, valor));
			serviceConta.editar(conta);
			return "Deposito efetivado com sucesso!";
		}
	}
	
	@GetMapping("/listar")
	public List<Conta> getConta() {
		
		return serviceConta.listar();
	}
}
