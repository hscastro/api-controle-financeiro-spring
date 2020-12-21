package br.financeiro.hscastro.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.financeiro.hscastro.domain.Conta;

@Repository
public class ContaDaoImpl extends AbstractDao<Conta, Serializable> implements ContaDao<Conta> {

}
