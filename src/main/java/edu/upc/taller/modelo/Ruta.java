package edu.upc.taller.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RUTA")
public class Ruta {

	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="incremento_USUARIO")
	// @SequenceGenerator(name="incremento_USUARIO", sequenceName="incremento_USUARIO", allocationSize=1)
	 @Id	
	 @Column(name = "ID")	
	private Integer  id;

	@Column(name = "NOMBRE")
	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	

}
