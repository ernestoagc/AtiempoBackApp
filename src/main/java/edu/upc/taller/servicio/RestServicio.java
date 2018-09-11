package edu.upc.taller.servicio;

import java.util.List;

import edu.upc.taller.rest.dto.EntradaDTO;
import edu.upc.taller.rest.dto.ReservaDTO;
import edu.upc.taller.rest.dto.SalidaDTO;
import edu.upc.taller.rest.dto.UsuarioDTO;

public interface RestServicio {
	public UsuarioDTO getUsuario(String celular, String clave);
	public List<SalidaDTO> getRutas();
	public SalidaDTO insertReserva(EntradaDTO entradaDTO);
	public List<ReservaDTO> getReserva(String celular,String codigoPerfil, String estado);
	public UsuarioDTO insertUsuario(UsuarioDTO usuarioDTO) ;
	public List<SalidaDTO> getEstadoViajes();
	public List<SalidaDTO> getPerfiles();
	public  SalidaDTO cancelarReserva(String idReserva);
}
