package edu.udec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.udec.entity.Persona;
import edu.udec.service.interfaces.IPersonaService;

/**
 * funcion donde se ejecuta el servico
 * @author Sebastian
 *
 */
@Service
public class PersonaServiceImp implements IPersonaService{
	
	/**
	 * Crear lista en memoria
	 */
	List<Persona> personas = new ArrayList<Persona>();
	
	/**
	 * Metodo para llamar los primeros datos al levantar el proyecto
	 */
	public PersonaServiceImp() {
		llenarLista();
	}
	
	/**
	 * Metodo para llenar a lista
	 */
	public void llenarLista() {
		personas.add(new Persona("Juan", 1070984090, "mail@app.com", 18, "Av Simpre Viva", "Soltero"));
		personas.add(new Persona("Camilo", 123456, "camilo@app.com", 22, "Mi direccion", "Casado"));
	}
	
	/**
	 * Lista todas las personas, retorna objeto persona
	 */
	@Override
	public List<Persona> listarPersonas() {
		return personas;
	}

	/**
	 * Lista persona por cedula, devueve objeto persona ,necesita parametro long
	 */
	@Override
	public Persona listarPersonaPorCedula(long cedula){
		Persona persona = new Persona();
		for (int i = 0; i < personas.size(); i++) {
//			i = i / 0;
			if (personas.get(i).getCedula() == cedula) {
				persona = personas.get(i);
				break;
			}
		}
		return persona;
	}

	/**
	 * lista persona por nombre, devuelve objeto persona y necesita parametro de string
	 */
	@Override
	public Persona listarPersonaPoNombre(String nombre) {
		Persona persona = new Persona();
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getNombre().equals(nombre)) {
				persona = personas.get(i);
				break;
			}
		}
		return persona;
	}

	/**
	 * Guarda perosna, requiere objeto persona json y devuelve el mismo objeto
	 */
	@Override
	public Persona guardar(Persona persona) {
		personas.add(persona);
		return persona;
	}

	/**
	 * Edita la persona, requiere objeto persona y edita por cedula
	 */
	@Override
	public Persona editar(Persona persona) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getCedula() == persona.getCedula()) {
				personas.remove(personas.get(i));
				personas.add(persona);
			}
		}
		return persona;
	}

	/**
	 * Elimina objeto persona, requiere parametro cedula long
	 */
	@Override
	public void eliminar(long cedula) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getCedula() == cedula) {
				personas.remove(personas.get(i));
			}
		}
	}
	
	

}
