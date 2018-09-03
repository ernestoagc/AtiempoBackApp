package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.Lista;

public interface ListaDAO {
	public Lista getLista(long ListaId);

	public Long addLista(Lista Lista) ;

	public void deleteLista(long ListaId);

	public Lista updateLista(Lista Lista);
	
	public List<Lista> listLista();
}
