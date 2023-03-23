package com.examenmorochoevelyn.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.examenmorochoevelyn.examen.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente,Long> {

}
