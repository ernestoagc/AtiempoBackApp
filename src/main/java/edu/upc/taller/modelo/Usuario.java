package edu.upc.taller.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	
	 @Id	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")	
	private Long  id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;
	
	
	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CELULAR")
	private String celular;
	
	@Column(name = "CLAVE")
	private String clave;

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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	/*
	public List<UsuarioPerfil> getUsuariosPerfil() {
		return usuariosPerfil;
	}

	public void setUsuariosPerfil(List<UsuarioPerfil> usuariosPerfil) {
		this.usuariosPerfil = usuariosPerfil;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", usuariosPerfil="
				+ usuariosPerfil + ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", celular=" + celular
				+ ", clave=" + clave + "]";
	}
	*/
	


	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", celular=" + celular + ", clave="
				+ clave + "]";
	}
	


	
	
	
}


