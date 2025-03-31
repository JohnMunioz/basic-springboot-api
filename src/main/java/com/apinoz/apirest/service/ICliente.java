package com.apinoz.apirest.service;

import com.apinoz.apirest.model.dto.ClienteDto;
import com.apinoz.apirest.model.entity.Cliente;

public interface ICliente {

    Cliente save(ClienteDto clienteDto);
    Cliente findById(Integer id);
    void delete(Cliente cliente);

}
