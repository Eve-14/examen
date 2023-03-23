package com.examenmorochoevelyn.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.examenmorochoevelyn.examen.entity.Cliente;
import com.examenmorochoevelyn.examen.repository.ClienteRepository;

public class ClienteServiceImpl extends GenericServiceImpl<Cliente,Long>implements ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	@Override
	public CrudRepository<Cliente, Long> getDao(){
		return clienteRepository;
	}
}
