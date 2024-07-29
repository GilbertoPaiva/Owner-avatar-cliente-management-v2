package br.com.gpaiva.dao;

import java.util.Collection;

import br.com.gpaiva.dao.IProdutoDAO;
import br.com.gpaiva.domain.Produto;
import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;


public class ProdutoDaoMock implements IProdutoDAO {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {

        return true;
    }

    @Override
    public void excluir(String valor) {


    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {


    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {

        return null;
    }

}