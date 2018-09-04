package edu.upc.taller.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ReservaDTO implements Serializable{
	private String fecha;
	private String origen;
	private String destino;
	private Long hora;
	private Long minuto;
	private String estado;
	private String pasajeroNombreCompleto;
	private String pasajeroCelular;
	private Long cantidadAsiento;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
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
	public Long getHora() {
		return hora;
	}
	public void setHora(Long hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPasajeroNombreCompleto() {
		return pasajeroNombreCompleto;
	}
	public void setPasajeroNombreCompleto(String pasajeroNombreCompleto) {
		this.pasajeroNombreCompleto = pasajeroNombreCompleto;
	}
	public String getPasajeroCelular() {
		return pasajeroCelular;
	}
	public void setPasajeroCelular(String pasajeroCelular) {
		this.pasajeroCelular = pasajeroCelular;
	}
	public Long getCantidadAsiento() {
		return cantidadAsiento;
	}
	public void setCantidadAsiento(Long cantidadAsiento) {
		this.cantidadAsiento = cantidadAsiento;
	}
	
	
	
	public Long getMinuto() {
		return minuto;
	}
	public void setMinuto(Long minuto) {
		this.minuto = minuto;
	}
	@Override
	public String toString() {
		return "ReservaDTO [fecha=" + fecha + ", origen=" + origen + ", destino=" + destino + ", hora=" + hora
				+ ", minuto=" + minuto + ", estado=" + estado + ", pasajeroNombreCompleto=" + pasajeroNombreCompleto
				+ ", pasajeroCelular=" + pasajeroCelular + ", cantidadAsiento=" + cantidadAsiento + "]";
	}


	
	
}
