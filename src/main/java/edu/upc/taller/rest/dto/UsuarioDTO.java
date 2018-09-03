package edu.upc.taller.rest.dto;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable{

	private Long id;

	private String nombre;

	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String email;	
	
	private String celular;
	
	private String mensaje;
	private String error;
	
	private List<RolDTO> rolesDTO;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<RolDTO> getRolesDTO() {
		return rolesDTO;
	}

	public void setRolesDTO(List<RolDTO> rolesDTO) {
		this.rolesDTO = rolesDTO;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", email=" + email + ", celular=" + celular + ", mensaje=" + mensaje + ", error="
				+ error + ", rolesDTO=" + rolesDTO + "]";
	}
	
	
	
}
