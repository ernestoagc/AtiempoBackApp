package edu.upc.taller.rest.dto;

import java.io.Serializable;
import java.util.List;

public class SalidaDTO implements Serializable{

	private Long id;
	private String nombre;
	private String codigo;
	private List<DetalleDTO> detalles;
	
	
	
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
	public List<DetalleDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleDTO> detalles) {
		this.detalles = detalles;
	}
	
	
}
