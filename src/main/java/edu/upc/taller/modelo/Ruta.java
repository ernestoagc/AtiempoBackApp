package edu.upc.taller.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RUTA")
public class Ruta implements Serializable{

	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="incremento_USUARIO")
	// @SequenceGenerator(name="incremento_USUARIO", sequenceName="incremento_USUARIO", allocationSize=1)
	 @Id	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")	
	private Long  id;

	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CODIGO")
	private String codigo;
	
	@Column(name = "IMAGEN")
	private String imagen;


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
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", imagen=" + imagen + "]";
	}



	
	
	
	
	

}
