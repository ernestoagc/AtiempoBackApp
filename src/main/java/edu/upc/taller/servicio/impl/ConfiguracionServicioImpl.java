package edu.upc.taller.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.taller.modelo.Ruta;
import edu.upc.taller.servicio.ConfiguracionServicio;
import edu.upc.taller.dao.*;
@Service
@Transactional
public class ConfiguracionServicioImpl implements ConfiguracionServicio {



	@Autowired
	RutaDao RutaDao;
	

  @SuppressWarnings("unchecked")
    public List<Ruta> listRuta() {
        return RutaDao.listRuta();
    }
}
