package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.Valor;

public interface ValorDAO {
	public Valor getValor(long ValorId);

	public Long addValor(Valor Valor) ;

	public void deleteValor(long ValorId);

	public Valor updateValor(Valor Valor);
	
	public List<Valor> listValor();
	  public List<Valor> getValorxCodigoLista(String codigoLista) ;
	
	 public List<Valor> getValorxCodigoListaValor(String codigoLista,String codigoValor);
}
