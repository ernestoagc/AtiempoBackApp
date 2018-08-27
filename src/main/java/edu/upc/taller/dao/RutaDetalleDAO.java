package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.RutaDetalle;

public interface RutaDetalleDAO {
	  public RutaDetalle getRutaDetalle(long RutaDetalleId);

	    public Long addRutaDetalle(RutaDetalle RutaDetalle) ;

	    public void deleteRutaDetalle(long RutaDetalleId);

	    public RutaDetalle updateRutaDetalle(RutaDetalle RutaDetalle);
		
	    public List<RutaDetalle> listRutaDetalle();
	    
	    public List<RutaDetalle> listRutaDetalle(String query) ;
	    public List<RutaDetalle> getRutaDetalle(Long idRuta);
}
