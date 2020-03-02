package edu.udec.service.interfaces;

import java.util.List;

import edu.udec.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> listarPersonas();
	
	public Persona listarPersonaPorCedula(long cedula);
	
	public Persona listarPersonaPoNombre(String nombre);
	
	public Persona guardar(Persona persona);
	
	public Persona editar(Persona persona);
	
	public void eliminar(long cedula);
}
