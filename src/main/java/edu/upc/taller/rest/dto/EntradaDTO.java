package edu.upc.taller.rest.dto;

import java.io.Serializable;

public class EntradaDTO implements Serializable{
	private Long idRutaDetalle;
	private String fecha;
	private Long hora;
	private Long minuto;
	private Long cantidadAsiento;
	private Long idPasajero;
	private String celular;
	private String perfil;
	
	
	public Long getIdRutaDetalle() {
		return idRutaDetalle;
	}
	public void setIdRutaDetalle(Long idRutaDetalle) {
		this.idRutaDetalle = idRutaDetalle;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Long getHora() {
		return hora;
	}
	public void setHora(Long hora) {
		this.hora = hora;
	}
	public Long getMinuto() {
		return minuto;
	}
	public void setMinuto(Long minuto) {
		this.minuto = minuto;
	}
	public Long getCantidadAsiento() {
		return cantidadAsiento;
	}
	public void setCantidadAsiento(Long cantidadAsiento) {
		this.cantidadAsiento = cantidadAsiento;
	}
	public Long getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(Long idPasajero) {
		this.idPasajero = idPasajero;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
