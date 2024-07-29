package br.com.gpaiva;

import br.com.gpaiva.dao.ClienteDAO;
import br.com.gpaiva.dao.IClienteDAO;
import br.com.gpaiva.domain.Cliente;
import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(70221908447L);
        cliente.setNome("Gilberto");
        cliente.setCidade("Mossoró");
        cliente.setEnd("End");
        cliente.setEstado("RN");
        cliente.setNumero(11);
        cliente.setTel(1199999999L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setCpf(44444444444L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Gilberto Paiva");
        clienteDao.alterar(cliente);
        Assert.assertEquals("Gilberto Paiva", cliente.getNome());
    }

    @Test
    public void buscarTodos(){
        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);
    }
}
