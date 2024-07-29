package br.com.gpaiva;

import br.com.gpaiva.dao.IProdutoDAO;
import br.com.gpaiva.dao.ProdutoDAO;
import br.com.gpaiva.domain.Produto;
import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDao;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException{
        produto = new Produto();
        produto.setCodigo("B12");
        produto.setNome("Produto 1");
        produto.setDescricao("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produtoDao.cadastrar(produto);
    }

    @Test
    public void pesquisar(){
        Produto produto = this.produtoDao.consultar(this.produto.getCodigo());
        Assert.assertNotNull(produto);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException{
        produto.setCodigo("B21");
        Boolean retorno = produtoDao.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir(){
        produtoDao.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        produto.setNome("Gilberto Paiva");
        produtoDao.alterar(produto);
        Assert.assertEquals("Gilberto Paiva", produto.getNome());
    }

    @Test
    public void buscarTodos(){
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);
    }
}
