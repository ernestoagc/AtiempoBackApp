package edu.upc.taller.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SalidaDTO implements Serializable{

	private Long id;
	private String nombre;
	private String codigo;
	private String imagen;
	private List<DetalleDTO> detalles;

	private String mensaje;
	private String error;
	
	
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
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "SalidaDTO [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", imagen=" + imagen
				+ ", detalles=" + detalles + ", mensaje=" + mensaje + ", error=" + error + "]";
	}


	
	
}
