package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.modelo.Persona;
import com.example.repositorio.Repositorio;

@Controller
public class Controlador {

	@Autowired
	private Repositorio repositorio;

	@GetMapping({ "/inicio", "/" })
	public String inicio(Model m) {

		return "paginaFormulario";

	}

	@PostMapping({ "/guardar" })
	public String guardar(Model m, Persona persona) {

		repositorio.save(persona);

		m.addAttribute("listaRegistro", repositorio.findAll());

		return "paginaTabla";

	}

	@PostMapping({ "/procesar" })
	public String procesar(@RequestParam("procesado") ArrayList<String> procesado, Model m) {

		for (String identificador : procesado) {

			Persona persona = repositorio.findById(Integer.parseInt(identificador)).get();

			persona.setProcesado("true");

			repositorio.save(persona);
		}

		List<Persona> lista = (List<Persona>) repositorio.findAll();

		m.addAttribute("listaRegistro2", lista);

		return "paginaTabla2";

	}

}