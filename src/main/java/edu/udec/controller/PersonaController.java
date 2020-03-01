package edu.udec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.udec.entity.Persona;
import edu.udec.service.interfaces.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

		@Autowired
		IPersonaService iPersonaService;
		
		@GetMapping("/listar")
		public ResponseEntity<List<Persona>> listarPersonas() {
			List<Persona> listaPersona = iPersonaService.listarPersonas();
			return new ResponseEntity<List<Persona>>(listaPersona, HttpStatus.OK);
		}
		
		@GetMapping("/listarPorCedula/{cedula}")
		public ResponseEntity<Persona> listarPorCedula(@PathVariable long cedula){
			Persona persona = iPersonaService.listarPersonaPorCedula(cedula);
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		}
		
		@GetMapping("/listarPorNombre/{nombre}")
		public ResponseEntity<Persona> listarPorNombre(@PathVariable String nombre){
			Persona persona = iPersonaService.listarPersonaPoNombre(nombre);
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		}
		
		
}
