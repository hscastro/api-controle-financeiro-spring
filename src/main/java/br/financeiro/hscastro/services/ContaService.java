package br.financeiro.hscastro.services;

import java.util.List;

public interface ContaService<Conta> {

	public void salvar(Conta c);
	
	public void editar(Conta c);
	
	public void excluir(Long id);
	
	public Conta buscarPorId(Long id);
	
	public List<Conta> listar();

}
