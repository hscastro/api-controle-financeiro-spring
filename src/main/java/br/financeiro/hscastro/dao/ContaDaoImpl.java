package br.financeiro.hscastro.dao;

import org.springframework.stereotype.Repository;
import br.financeiro.hscastro.domain.Conta;

@Repository
public class ContaDaoImpl extends AbstractDao<Conta, Long> implements ContaDao<Conta> {
	   //Não precisa de implementação
}
