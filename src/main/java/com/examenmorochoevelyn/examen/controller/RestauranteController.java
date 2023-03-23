package com.examenmorochoevelyn.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenmorochoevelyn.examen.entity.Restaurante;
import com.examenmorochoevelyn.examen.service.RestauranteService;

@RestController
@RequestMapping("/api/restaurante")

public class RestauranteController {
	  @Autowired
	    RestauranteService restauranteService;
	    @GetMapping("/listar")
	    public ResponseEntity<List<Restaurante>> listarcarta() {
	        return new ResponseEntity<>(restauranteService.findByAll(), HttpStatus.OK);
	    }
	    @PostMapping("/crear")
	    public ResponseEntity<Restaurante> crearcarta(@RequestBody Restaurante r) {
	        return new ResponseEntity<>(restauranteService.save(r), HttpStatus.CREATED);
	    }
	    @PutMapping("/actualizar/{id}")
	    public ResponseEntity<Restaurante> actualizarcarta(@PathVariable Long id, @RequestBody Restaurante r) {
	    	Restaurante cartaEncontrado = restauranteService.findById(id);
	        if (cartaEncontrado == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            try {
	            	cartaEncontrado.setNombre(r.getNombre());
	            	cartaEncontrado.setTelefono(r.getTelefono());
	            	cartaEncontrado.setCorreo(r.getCorreo());
	            	cartaEncontrado.setDireccion(r.getDireccion());
	                return new ResponseEntity<>(restauranteService.save(r), HttpStatus.OK);
	            } catch (DataAccessException e) {
	                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	        }
	    }
	    @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<Restaurante> eliminarcarta(@PathVariable Long id) {
	    	restauranteService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
