package edu.upc.taller.servicio;

import java.util.List;

import edu.upc.taller.rest.dto.SalidaDTO;
import edu.upc.taller.rest.dto.UsuarioDTO;

public interface RestServicio {
	public UsuarioDTO getUsuario(String celular, String clave);
	public List<SalidaDTO> getRutas();
}
