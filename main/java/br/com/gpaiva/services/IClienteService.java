package br.com.gpaiva.services;

import br.com.gpaiva.domain.Cliente;
import br.com.gpaiva.exception.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente)throws TipoChaveNaoEncontradaException;
}
