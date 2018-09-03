package edu.upc.taller.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {
	
	 @Id	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")	
	private Long  id;	
	
	@ManyToOne
	@JoinColumn(name="RUTA_DETALLE", nullable=false)	
	private RutaDetalle RutaDetalle;
	
	@Column(name = "FECHA")
	private Date fecha;
	
	@Column(name = "HORA")
	private Long hora;
	
	@Column(name = "MINUTO")
	private Long minuto;
	
	@Column(name = "CANTIDAD_ASIENTO")
	private Long cantidadAsiento;
	
	@ManyToOne
	@JoinColumn(name="ESTADO", nullable=false)
	private Valor estado;	
	
	@ManyToOne
	@JoinColumn(name="PASAJERO", nullable=false)
	private Usuario pasajero;	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RutaDetalle getRutaDetalle() {
		return RutaDetalle;
	}
	public void setRutaDetalle(RutaDetalle rutaDetalle) {
		RutaDetalle = rutaDetalle;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
	public Valor getEstado() {
		return estado;
	}
	public void setEstado(Valor estado) {
		this.estado = estado;
	}
	public Usuario getPasajero() {
		return pasajero;
	}
	public void setPasajero(Usuario pasajero) {
		this.pasajero = pasajero;
	}
	
	
	
}
