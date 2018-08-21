package edu.upc.taller.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.taller.modelo.Ruta;
import edu.upc.taller.servicio.ConfiguracionServicio;
import edu.upc.taller.dao.RutaDao;
@Service
@Transactional
public class ConfiguracionServicioImpl implements ConfiguracionServicio {

	@Autowired
	RutaDao rutaDao;
	

	public Ruta getRuta(long RutaId) {
		 
        return rutaDao.getRuta(RutaId);
    }

    public Long addRuta(Ruta Ruta) {
      return rutaDao.addRuta(Ruta);
       
    }

    public void deleteRuta(long RutaId) {
    	rutaDao.deleteRuta(RutaId);
    }

    public Ruta updateRuta(Ruta Ruta) {
        return rutaDao.updateRuta(Ruta);
    }

    @SuppressWarnings("unchecked")
    public List<Ruta> listRuta() {
        return rutaDao.listRuta();
    }

	public Ruta obtenerBase(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
