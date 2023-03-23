package com.examenmorochoevelyn.examen.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "plato")
@Data
public class Plato {
@Id
private Long idplato;
private String nombrePlato;
private String descripcion;
private Double precio;
public Long getIdplato() {
	return idplato;
}
public void setIdplato(Long idplato) {
	this.idplato = idplato;
}
public String getNombrePlato() {
	return nombrePlato;
}
public void setNombrePlato(String nombrePlato) {
	this.nombrePlato = nombrePlato;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Double getPrecio() {
	return precio;
}
public void setPrecio(Double precio) {
	this.precio = precio;
}


}
