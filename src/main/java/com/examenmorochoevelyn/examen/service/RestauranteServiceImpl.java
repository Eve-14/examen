package com.examenmorochoevelyn.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


import com.examenmorochoevelyn.examen.entity.Restaurante;
import com.examenmorochoevelyn.examen.repository.RestuaranteRepository;

public class RestauranteServiceImpl extends GenericServiceImpl<Restaurante,Long>implements RestauranteService {

	@Autowired
	RestuaranteRepository restuaranteRepository;
	@Override
	public CrudRepository<Restaurante, Long> getDao(){
		return restuaranteRepository;
	}
}
