package edu.udec.entity;

//import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( description  = "Clase contenedora de los atributos comunes de una persona.")
public class Persona {

	@ApiModelProperty(notes = "Nombre del persona")
	@Size(min = 3, message = "Nombre debe tener al menos 3 caracteres")
	private String nombre;
	
	@ApiModelProperty(notes = "Cedula de persona")
	private long cedula;
	
	@ApiModelProperty(notes = "Correo de persona")
	private String email;
	
	@ApiModelProperty(notes = "Edad de persona")
	private int edad;
	
	@ApiModelProperty(notes = "Direccion de persona")
	private String direccion;
	
	@ApiModelProperty(notes = "Estado Civil de persona")
	private String estadoCivil;
	
	
	public Persona() {

	}

	public Persona(String nombre, long cedula, String email, int edad, String direccion, String estadoCivil) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.email = email;
		this.edad = edad;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
