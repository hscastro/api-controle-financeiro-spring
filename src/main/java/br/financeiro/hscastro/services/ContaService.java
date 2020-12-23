package br.financeiro.hscastro.services;

import java.util.List;

import br.financeiro.hscastro.domain.Conta;

public interface ContaService<Conta> {

	public void salvar(Conta c);
	
	public void editar(Conta c);
	
	public void excluir(Long id);
	
	public Conta buscarPorId(Long id);
	
	public List<Conta> listar();
	
	public Conta getContaPorNumero(String numero);	
	
	public double getNovoSaldo(Conta conta, double valor);

}
