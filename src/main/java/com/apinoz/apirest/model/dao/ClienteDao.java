package com.apinoz.apirest.model.dao;

import com.apinoz.apirest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
