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
@Table(name = "VALOR")
public class Valor {
	
	 @Id	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")	
	private Long  id;

	@Column(name = "VALOR")
	private String valor;
	
	@Column(name = "CODIGO")
	private String codigo;

	
	 @ManyToOne
	 @JoinColumn(name="LISTA", nullable=false)	 
	 private Lista lista;
	 
	 @Column(name = "AUX1")
	private String aux1;
	 
	 @Column(name = "AUX2")
	private String aux2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public String getAux1() {
		return aux1;
	}

	public void setAux1(String aux1) {
		this.aux1 = aux1;
	}

	public String getAux2() {
		return aux2;
	}

	public void setAux2(String aux2) {
		this.aux2 = aux2;
	}

	@Override
	public String toString() {
		return "Valor [id=" + id + ", valor=" + valor + ", codigo=" + codigo + ", lista=" + lista + ", aux1=" + aux1
				+ ", aux2=" + aux2 + "]";
	}
	 
	 
	
}
