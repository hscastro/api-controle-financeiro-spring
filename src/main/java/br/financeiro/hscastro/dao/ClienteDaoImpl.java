package br.financeiro.hscastro.dao;

import org.springframework.stereotype.Repository;
import br.financeiro.hscastro.domain.Cliente;


@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao<Cliente> {
	   //Não precisa de implementação
}
