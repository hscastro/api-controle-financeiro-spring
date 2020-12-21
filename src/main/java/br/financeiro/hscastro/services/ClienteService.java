package br.financeiro.hscastro.services;

import java.util.List;

public interface ClienteService<C> {

	public void salvar(C c);
	
	public void editar(C c);
	
	public void excluir(Long id);
	
	public C buscarPorId(Long id);
	
	public List<C> listar();

}
