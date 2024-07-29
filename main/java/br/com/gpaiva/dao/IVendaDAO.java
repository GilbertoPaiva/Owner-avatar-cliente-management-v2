package br.com.gpaiva.dao;

import br.com.gpaiva.dao.generics.IGenericDAO;
import br.com.gpaiva.domain.Venda;
import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
