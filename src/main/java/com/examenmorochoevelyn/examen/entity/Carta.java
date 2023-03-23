package com.examenmorochoevelyn.examen.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document(collection = "carta")
@Data
public class Carta {
@Id
private Long idcarta ;
private String nombre;
private String categoria;
private Integer cantidad;
public Long getIdcarta() {
	return idcarta;
}
public void setIdcarta(Long idcarta) {
	this.idcarta = idcarta;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public Integer getCantidad() {
	return cantidad;
}
public void setCantidad(Integer cantidad) {
	this.cantidad = cantidad;
}


}


