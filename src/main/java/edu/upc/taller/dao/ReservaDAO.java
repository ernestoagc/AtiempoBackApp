package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.Reserva;

public interface ReservaDAO {
	public Reserva getReserva(long ReservaId);

	public Long addReserva(Reserva Reserva) ;

	public void deleteReserva(long ReservaId);

	public Reserva updateReserva(Reserva Reserva);
	
	public List<Reserva> listReserva();
	public List<Reserva> getReservaxPasajeroEstado(String celular,String estadoCodigo);
}
