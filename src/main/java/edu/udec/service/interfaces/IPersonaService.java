package edu.udec.service.interfaces;

import java.util.List;

import edu.udec.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> obtener();
	
	public Persona listarPersonaPorCedula(long cedula);
	
	public Persona listarPersonaPoNombre(String nombre);
	
	public Persona guardar();
	
	public Persona editar();
	
	public int eliminar(int edad);
}
