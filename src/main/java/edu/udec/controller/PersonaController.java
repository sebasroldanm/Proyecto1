package edu.udec.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import edu.udec.entity.Persona;
import edu.udec.service.interfaces.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

		@Autowired
		IPersonaService iPersonaService;
		
//		@GetMapping("/accessDenied")
//		public String accessDenied() {
//			return new ResponseEntity<Persona>(HttpStatus.FORBIDDEN);
//		}
		
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
		
		@PostMapping("/guardar")
		public ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
			Persona personaCreate = iPersonaService.guardar(persona);
			return new ResponseEntity<Persona>(personaCreate, HttpStatus.CREATED);
		}
		
		@PutMapping("/editar")
		public ResponseEntity<Persona> editar(@RequestBody Persona persona){
			Persona personaUpdate = iPersonaService.editar(persona);
			return new ResponseEntity<Persona>(personaUpdate, HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/eliminar/{cedula}")
		public ResponseEntity<Void> eliminar(@PathVariable long cedula){
			iPersonaService.eliminar(cedula);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
}
