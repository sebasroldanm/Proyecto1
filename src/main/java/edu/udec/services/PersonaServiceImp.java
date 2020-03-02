package edu.udec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.udec.entity.Persona;
import edu.udec.service.interfaces.IPersonaService;

@Service
public class PersonaServiceImp implements IPersonaService{
	
	List<Persona> personas = new ArrayList<Persona>();
	
	public PersonaServiceImp() {
		llenarLista();
	}
	
	public void llenarLista() {
		personas.add(new Persona("Juan", 9000000, "mail@app.com", 18, "Av Simpre Viva", "Soltero"));
		personas.add(new Persona("Camilo", 123456, "camilo@app.com", 22, "Mi direccion", "Casado"));
	}
	
	@Override
	public List<Persona> listarPersonas() {
		return personas;
	}

	@Override
	public Persona listarPersonaPorCedula(long cedula){
		Persona persona = new Persona();
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getCedula() == cedula) {
				persona = personas.get(i);
				break;
			}
		}
		return persona;
	}

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

	@Override
	public Persona guardar(Persona persona) {
		personas.add(persona);
		return persona;
	}

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

	@Override
	public void eliminar(long cedula) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getCedula() == cedula) {
				personas.remove(personas.get(i));
			}
		}
	}
	
	

}
