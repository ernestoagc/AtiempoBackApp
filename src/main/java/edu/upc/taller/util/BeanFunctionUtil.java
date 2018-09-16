package edu.upc.taller.util;
import edu.upc.taller.rest.dto.*;
import edu.upc.taller.modelo.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			rolDTO.setCodigo(usuarioPerfil.getPerfil().getCodigo());
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
		usuario.setClave(usuarioDTO.getClave());
		usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
		usuario.setCelular(usuarioDTO.getCelular());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setNombre(usuarioDTO.getNombre());	
		
	
		if(usuarioDTO.getAccion()==null) {

			if(usuarioDTO.getId()!=null || usuarioDTO.getId()!=0L) {
				usuario.setId(usuarioDTO.getId());			
			}	
			
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
			reservaDTO.setDestino(reserva.getRutaDetalle().getDestino());
			reservaDTO.setNombre(reserva.getRutaDetalle().getRuta().getNombre());
			reservaDTO.setImagen(reserva.getRutaDetalle().getRuta().getImagen());
		}
		
		if(reserva.getEstado()!=null) {
			reservaDTO.setEstado(reserva.getEstado().getValor());
		}
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
		reservaDTO.setHora(reserva.getHora());
		reservaDTO.setMinuto(reserva.getMinuto());
		reservaDTO.setCantidadAsiento(reserva.getCantidadAsiento());
		reservaDTO.setIdReserva(reserva.getId());
		if(reserva.getFecha()!=null) {
			reservaDTO.setFecha(df.format(reserva.getFecha()));	
			reservaDTO.setFechaHora(df2.format(reserva.getFecha()));
		}
		
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
		salidaDTO.setImagen(ruta.getImagen());
		return salidaDTO;
		
	}
	
	public static SalidaDTO getEstado(Valor valor) {
		SalidaDTO salidaDTO= new SalidaDTO();		
		salidaDTO.setId(valor.getId());
		salidaDTO.setCodigo(valor.getCodigo());
		salidaDTO.setNombre(valor.getValor());
		return salidaDTO;
		
	}
	
	public static SalidaDTO getPerfil(Perfil perfil) {
		SalidaDTO salidaDTO= new SalidaDTO();		
		salidaDTO.setId(perfil.getId());
		salidaDTO.setCodigo(perfil.getCodigo());
		salidaDTO.setNombre(perfil.getNombre());
		return salidaDTO;
		
	}
}
