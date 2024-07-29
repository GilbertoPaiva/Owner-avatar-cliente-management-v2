package br.com.gpaiva.services;

import br.com.gpaiva.dao.IClienteDAO;
import br.com.gpaiva.domain.Cliente;


import br.com.gpaiva.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {



    public ClienteService(IClienteDAO clienteDAO){
        super (clienteDAO);
    }


    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }

}
