package edu.upc.taller.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.taller.dao.UsuarioPerfilDAO;
import edu.upc.taller.dao.RutaDao;
import edu.upc.taller.dao.RutaDetalleDAO;
import edu.upc.taller.modelo.Ruta;
import edu.upc.taller.modelo.RutaDetalle;
import edu.upc.taller.modelo.UsuarioPerfil;
import edu.upc.taller.rest.dto.SalidaDTO;
import edu.upc.taller.rest.dto.UsuarioDTO;
import edu.upc.taller.servicio.RestServicio;
import edu.upc.taller.util.BeanFunctionUtil;
import edu.upc.taller.util.BeanStringUtil;

@Service
@Transactional
public class RestServicioImpl implements RestServicio {

	@Autowired
	UsuarioPerfilDAO usuarioPerfilDAO;
	
	@Autowired
	RutaDao rutaDAO;
	
	@Autowired
	RutaDetalleDAO rutaDetalleDAO;
	
	
	public UsuarioDTO getUsuario(String celular, String clave) {
		
		if(BeanStringUtil.isBlank(celular))
			celular="";
		
		if(BeanStringUtil.isBlank(clave))
			celular="";
		
		//verificar si existe usuario
		List<UsuarioPerfil> usuariosPerfilExiste=usuarioPerfilDAO.getUsuarioPerfil(celular);
		System.out.println("===>usuariosPerfilExiste: "+usuariosPerfilExiste);
		if(usuariosPerfilExiste==null || usuariosPerfilExiste.size()==0) {
			
			UsuarioDTO usuarioDTO= new UsuarioDTO();
			usuarioDTO.setError("E001");
			usuarioDTO.setMensaje("El usuario no existe");
			return usuarioDTO;
		} 
		
		
		List<UsuarioPerfil> usuariosPerfil=usuarioPerfilDAO.getUsuarioPerfil(celular, clave);
		System.out.println("===>usuarioPerfil join: "+usuariosPerfil);
		if( usuariosPerfil.size()>0) {
			
			UsuarioDTO usuarioDTO=BeanFunctionUtil.UsuarioDTO(usuariosPerfil);
			return usuarioDTO;
		}else {
			
			UsuarioDTO usuarioDTO= new UsuarioDTO();
			usuarioDTO.setError("E002");
			usuarioDTO.setMensaje("Clave incorreta");
			return usuarioDTO;
		}
		
	
		
	
	}



	public List<SalidaDTO> getRutas() {
		List<SalidaDTO> resultado=new ArrayList<SalidaDTO>();
		List<Ruta> rutas = rutaDAO.listRuta();
		for(Ruta ruta :rutas) {			
			SalidaDTO rutaDTO=  BeanFunctionUtil.getRuta(ruta);
			List<RutaDetalle> rutaDetalles=  rutaDetalleDAO.getRutaDetalle(ruta.getId());	
			rutaDTO.setDetalles(BeanFunctionUtil.getRutaDetalle(rutaDetalles));
			resultado.add(rutaDTO);			
		}
		// TODO Auto-generated method stub
		return resultado;
	}
}
