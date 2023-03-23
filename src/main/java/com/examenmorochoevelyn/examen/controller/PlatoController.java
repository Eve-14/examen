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

import com.examenmorochoevelyn.examen.entity.Plato;
import com.examenmorochoevelyn.examen.service.PlatoService;
@RestController
@RequestMapping("/api/plato")
public class PlatoController {
	@Autowired
    PlatoService platoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Plato>> listarplato() {
        return new ResponseEntity<>(platoService.findByAll(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Plato> crearplato(@RequestBody Plato p) {
        return new ResponseEntity<>(platoService.save(p), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Plato> actualizarplato(@PathVariable Long id, @RequestBody Plato p) {
    	Plato platoEncontrado = platoService.findById(id);
        if (platoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	platoEncontrado.setNombrePlato(p.getNombrePlato());
            	platoEncontrado.setDescripcion(p.getDescripcion());
            	platoEncontrado.setPrecio(p.getPrecio());
                return new ResponseEntity<>(platoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Plato> eliminarplato(@PathVariable Long id) {
    	platoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
