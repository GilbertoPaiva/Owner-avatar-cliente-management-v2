package br.com.gpaiva;

import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;

import br.com.gpaiva.dao.ClienteDaoMock;

import br.com.gpaiva.dao.IClienteDAO;
import br.com.gpaiva.domain.Cliente;
import br.com.gpaiva.services.ClienteService;
import br.com.gpaiva.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(70221908447L);
        cliente.setNome("Gilberto");
        cliente.setCidade("Mossoró");
        cliente.setEnd("End");
        cliente.setEstado("RN");
        cliente.setNumero(11);
        cliente.setTel(84999588387L);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }
    
    @Test
    public void salvarCliente()throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente()throws TipoChaveNaoEncontradaException{
        cliente.setNome("Gilberto Paiva");
        clienteService.alterar(cliente);

        Assert.assertEquals("Gilberto Paiva", cliente.getNome());
    }
}
