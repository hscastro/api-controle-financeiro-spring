package br.financeiro.hscastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.financeiro.hscastro.dao.ClienteDao;
import br.financeiro.hscastro.domain.Cliente;


@Service @Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService<Cliente> {
	
	@Autowired
	private ClienteDao<Cliente> dao;

	@Override
	public void salvar(Cliente c) {
		
		dao.save(c);
	}

	@Override
	public void editar(Cliente c) {
		
		dao.update(c);
	}

	@Override
	public void excluir(Long id) {
		
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
	
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cliente> listar() {
		
		return dao.findAll();
	}

}
