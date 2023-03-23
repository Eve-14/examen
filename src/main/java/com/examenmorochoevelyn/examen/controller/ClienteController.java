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

import com.examenmorochoevelyn.examen.entity.Cliente;
import com.examenmorochoevelyn.examen.service.ClienteService;
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarcliente() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearcliente(@RequestBody Cliente c) {
        return new ResponseEntity<>(clienteService.save(c), HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarcliente(@PathVariable Long id, @RequestBody Cliente c) {
    	Cliente clienteEncontrado = clienteService.findById(id);
        if (clienteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	clienteEncontrado.setNombre(c.getNombre());
            	clienteEncontrado.setApellido(c.getApellido());
            	clienteEncontrado.setCedula(c.getCedula());
            	clienteEncontrado.setCorreo(c.getCorreo());
                return new ResponseEntity<>(clienteService.save(c), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarcliente(@PathVariable Long id) {
    	clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
