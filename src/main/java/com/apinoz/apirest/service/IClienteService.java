package com.apinoz.apirest.service;

import com.apinoz.apirest.model.dto.ClienteDto;
import com.apinoz.apirest.model.entity.Cliente;

import java.util.List;


public interface IClienteService {

    List<Cliente> listAll();
    Cliente save(ClienteDto clienteDto);
    Cliente findById(Integer id);
    void delete(Cliente cliente);
    boolean existsById(Integer id);

}
