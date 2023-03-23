package com.examenmorochoevelyn.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.examenmorochoevelyn.examen.entity.Carta;
import com.examenmorochoevelyn.examen.repository.CartaRepository;

public class CartaServiceImpl  extends GenericServiceImpl<Carta,Long>implements CartaService{

	@Autowired
	CartaRepository cartaRepository;
	@Override
	public CrudRepository<Carta, Long> getDao(){
		return cartaRepository;
	}
}
