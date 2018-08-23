package edu.upc.taller.servicio;

import edu.upc.taller.rest.dto.UsuarioDTO;

public interface RestServicio {
	public UsuarioDTO getUsuario(String email, String clave);
}
