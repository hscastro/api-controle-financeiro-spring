package br.financeiro.hscastro.dao;

import java.util.List;

public interface ContaDao<T> {
	
	public void save(T t);
	
	public void update(T t);
	
	public void delete(Long id);
	
	public T findById(Long id);

	public List<T> findAll();
}


