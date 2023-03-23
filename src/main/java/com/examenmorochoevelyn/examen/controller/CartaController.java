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

import com.examenmorochoevelyn.examen.entity.Carta;
import com.examenmorochoevelyn.examen.service.CartaService;

import java.util.List;
@RestController
@RequestMapping("/api/carta")

public class CartaController {

    @Autowired
    CartaService cartaService;
    @GetMapping("/listar")
    public ResponseEntity<List<Carta>> listarcarta() {
        return new ResponseEntity<>(cartaService.findByAll(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Carta> crearcarta(@RequestBody Carta c) {
        return new ResponseEntity<>(cartaService.save(c), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Carta> actualizarcarta(@PathVariable Long id, @RequestBody Carta c) {
    	Carta cartaEncontrado = cartaService.findById(id);
        if (cartaEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	cartaEncontrado.setNombre(c.getNombre());
            	cartaEncontrado.setCategoria(c.getCategoria());
            	cartaEncontrado.setCantidad(c.getCantidad());
                return new ResponseEntity<>(cartaService.save(c), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Carta> eliminarcarta(@PathVariable Long id) {
        cartaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
