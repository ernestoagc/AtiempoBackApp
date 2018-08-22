package edu.upc.taller.servicio.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.upc.taller.dao.UsuarioDAO;
import edu.upc.taller.dao.UsuarioPerfilDAO;
import edu.upc.taller.modelo.Usuario;
import edu.upc.taller.modelo.UsuarioPerfil;
import edu.upc.taller.servicio.SeguridadServicio;

@Service
@Transactional
public class SeguridadServicioImpl implements SeguridadServicio {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	UsuarioPerfilDAO usuarioPerfilDAO;
	
	
	
	public List<UsuarioPerfil> getUsuarioPerfil(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario getUsuario(String email) {
		// TODO Auto-generated method stub
		String query="from Usuario u where u.email='"+email+"'";
		
		//String query="select from USUARIO u where u.EMAIL='"+email+"'";
		List<Usuario> usuarios = usuarioDAO.listUsuario(query);
		if(usuarios!=null && usuarios.size()>0) {
			return usuarios.get(0);
		}
		return null;
	}

}
