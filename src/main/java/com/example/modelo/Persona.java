package com.example.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private   Integer  id;
	@Column
	private String nombre;	
	@Column
	private String apellido;
	
	@Column
	private String  procesado="false";
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getProcesado() {
		return procesado;
	}
	public void setProcesado(String procesado) {
		this.procesado = procesado;
	}


}