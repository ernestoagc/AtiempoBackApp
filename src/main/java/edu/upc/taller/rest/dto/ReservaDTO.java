package edu.upc.taller.rest.dto;

import java.io.Serializable;
import java.util.List;

public class ReservaDTO implements Serializable{
	private String nombre;
	List<DetalleDTO> detalles;
}
