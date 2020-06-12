package com.example.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.modelo.Persona;

public interface Repositorio  extends CrudRepository<Persona, Integer>{

}
