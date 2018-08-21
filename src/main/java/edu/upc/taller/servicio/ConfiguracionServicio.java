package edu.upc.taller.servicio;

import java.util.List;

import edu.upc.taller.modelo.Ruta;

public interface ConfiguracionServicio {
    
		public Ruta getRuta(long RutaId);

	    public Long addRuta(Ruta Ruta) ;

	    public void deleteRuta(long RutaId);

	    public Ruta updateRuta(Ruta Ruta);
		
	    public List<Ruta> listRuta();
		
	    public Ruta obtenerBase(Long id);
}
