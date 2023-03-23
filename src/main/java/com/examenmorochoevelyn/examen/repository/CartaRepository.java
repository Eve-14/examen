package com.examenmorochoevelyn.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examenmorochoevelyn.examen.entity.Carta;

public interface CartaRepository extends MongoRepository<Carta,Long>{

}
