package com.examenmorochoevelyn.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.examenmorochoevelyn.examen.entity.Plato;

public interface PlatoRepository extends MongoRepository<Plato,Long> {

}
