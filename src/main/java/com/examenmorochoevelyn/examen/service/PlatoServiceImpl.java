package com.examenmorochoevelyn.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.examenmorochoevelyn.examen.entity.Plato;
import com.examenmorochoevelyn.examen.repository.PlatoRepository;

public class PlatoServiceImpl extends GenericServiceImpl<Plato,Long>implements PlatoService {
	@Autowired
	PlatoRepository platoRepository;
	@Override
	public CrudRepository<Plato, Long> getDao(){
		return platoRepository;
	}
}
