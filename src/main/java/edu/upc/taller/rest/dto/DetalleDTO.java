package edu.upc.taller.rest.dto;

import java.io.Serializable;

public class DetalleDTO implements Serializable{

	private String origen;
	private String destino;
	private Long id;
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "DetalleDTO [origen=" + origen + ", destino=" + destino + ", id=" + id + "]";
	}
	
	
	
}
