package edu.upc.taller.util;
import edu.upc.taller.rest.dto.*;
import edu.upc.taller.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class BeanFunctionUtil {

	public static UsuarioDTO UsuarioDTO(List<UsuarioPerfil> listUsuarioPerfil) {
		UsuarioDTO usuarioDTO= new UsuarioDTO();
		
		if(listUsuarioPerfil==null || listUsuarioPerfil.size()==0) {
			return null;
		}
		Usuario usuario= listUsuarioPerfil.get(0).getUsuario();
		
		usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
		usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setCelular(usuario.getCelular());
		
		List<RolDTO> rolesDTO= new ArrayList<RolDTO>();
		for(UsuarioPerfil usuarioPerfil : listUsuarioPerfil) {
			RolDTO rolDTO= new RolDTO();
			rolDTO.setNombre(usuarioPerfil.getPerfil().getNombre());
			rolDTO.setCodigo(usuarioPerfil.getPerfil().getNombre());
			rolesDTO.add(rolDTO);
		}
		
		usuarioDTO.setRolesDTO(rolesDTO);
		
		return usuarioDTO;
		
	}
	
	public static DetalleDTO getRutaDetalle(RutaDetalle rutaDetalle) {
		DetalleDTO detalleDTO= new  DetalleDTO();
		
		detalleDTO.setId(rutaDetalle.getId());
		detalleDTO.setOrigen(rutaDetalle.getOrigen());
		detalleDTO.setDestino(rutaDetalle.getDestino());
		return detalleDTO;
		
	}
	
	public static Usuario getUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario= new Usuario();
		usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
		usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
		usuario.setCelular(usuarioDTO.getCelular());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setNombre(usuarioDTO.getNombre());	
		
		if(usuarioDTO.getId()!=null || usuarioDTO.getId()!=0L) {
			usuario.setId(usuarioDTO.getId());			
		}
		
		
		return usuario;
	}
	
	public static ReservaDTO getReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		if(reserva.getUsuarioPasajero()!=null) {
			reservaDTO.setPasajeroCelular(reserva.getUsuarioPasajero().getUsuario().getCelular());	
			reservaDTO.setPasajeroNombreCompleto(reserva.getUsuarioPasajero().getUsuario().getNombre()+ " " +reserva.getUsuarioPasajero().getUsuario().getApellidoPaterno()+ " " +reserva.getUsuarioPasajero().getUsuario().getApellidoMaterno());
		}
		if(reserva.getRutaDetalle()!=null) {
			reservaDTO.setOrigen(reserva.getRutaDetalle().getOrigen());
			reservaDTO.setOrigen(reserva.getRutaDetalle().getDestino());			
		}
		
		reservaDTO.setHora(reserva.getHora());
		reservaDTO.setMinuto(reserva.getMinuto());
		reservaDTO.setCantidadAsiento(reserva.getCantidadAsiento());
		return reservaDTO;
	}
	

	public static List<DetalleDTO> getRutaDetalle(List<RutaDetalle> rutaDetalles) {
		List<DetalleDTO> detallesDTO= new ArrayList<DetalleDTO>();
		
		for(RutaDetalle rutaDetalle : rutaDetalles) {
			detallesDTO.add(getRutaDetalle(rutaDetalle));			
		}	
		
		return detallesDTO;		
	}
	
	
	public static SalidaDTO getRuta(Ruta ruta) {
		SalidaDTO salidaDTO= new SalidaDTO();		
		salidaDTO.setId(ruta.getId());
		salidaDTO.setCodigo(ruta.getCodigo());
		salidaDTO.setNombre(ruta.getNombre());
		return salidaDTO;
		
	}
}
