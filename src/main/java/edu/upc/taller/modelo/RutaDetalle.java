package edu.upc.taller.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RUTA_DETALLE")
public class RutaDetalle {
	 @Id	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")	
	private Long  id;

	 @ManyToOne
	 @JoinColumn(name="RUTA", nullable=false)	 
	 private Ruta ruta;
	 
	
	 @Column(name = "ORIGEN")	
	 private String origen;

	 @Column(name = "DESTINO")
	 private String destino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
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

	@Override
	public String toString() {
		return "RutaDetalle [id=" + id + ", ruta=" + ruta + ", origen=" + origen + ", destino=" + destino + "]";
	}
	 
	 
	 
}
