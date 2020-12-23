package br.financeiro.hscastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.financeiro.hscastro.dao.ContaDao;
import br.financeiro.hscastro.domain.Conta;

@Service @Transactional(readOnly = false)
public class ContaServiceImpl implements ContaService<Conta> {
	
	@Autowired
	private ContaDao<Conta> dao;

	@Override
	public void salvar(Conta c) {
		
		dao.save(c);
	}

	@Override
	public void editar(Conta c) {
		
		dao.update(c);
	}

	@Override
	public void excluir(Long id) {
		
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Conta buscarPorId(Long id) {
	
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Conta> listar() {
		
		return dao.findAll();
	}

	@Override
	public Conta getContaPorNumero(String numero) {
		Conta conta = dao.findByNumero(numero);
		
		if(conta.getNumero().isEmpty()) {
			return null;
		}
		return conta;
	}
	
	@Override
	public double getNovoSaldo(Conta conta, double valor) {
		double saldo = conta.getSaldo();
		saldo+=valor;		
		return saldo;
	}
	
}
