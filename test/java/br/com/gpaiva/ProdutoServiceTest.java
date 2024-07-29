package br.com.gpaiva;

import br.com.gpaiva.dao.IProdutoDAO;
import br.com.gpaiva.domain.Produto;
import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;
import br.com.gpaiva.services.IProdutoService;
import br.com.gpaiva.services.ProdutoService;

import br.com.gpaiva.dao.ProdutoDaoMock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoServiceTest {

    private IProdutoService produtoService ;

    private Produto produto ;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService =  new ProdutoService(dao);
    }

    @Before
    public void init(){
        produto = new Produto();
        produto.setCodigo("B12");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar(){
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir(){
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        produto.setNome("Gilberto Paiva");
        produtoService.alterar(produto);
        Assert.assertEquals("Gilberto Paiva", produto.getNome());
    }
}
