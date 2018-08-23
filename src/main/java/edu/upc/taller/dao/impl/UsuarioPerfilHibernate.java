package edu.upc.taller.dao.impl;


import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.upc.taller.dao.*;
import edu.upc.taller.modelo.Usuario;
import edu.upc.taller.modelo.UsuarioPerfil;
import edu.upc.taller.util.HibernateUtil;

@Repository
public class UsuarioPerfilHibernate  implements UsuarioPerfilDAO{
	
	  @Autowired
	   private HibernateUtil hibernateUtil;

	  public UsuarioPerfilHibernate() {
		  System.out.println("UsuarioPerfilHibernate");
	}


	   public Long addUsuarioPerfil(UsuarioPerfil UsuarioPerfil) {        
	       return (Long) hibernateUtil.create(UsuarioPerfil);
	   }


	   public UsuarioPerfil updateUsuarioPerfil(UsuarioPerfil UsuarioPerfil) {        
	       return hibernateUtil.update(UsuarioPerfil);
	   }
	   
	   public void deleteUsuarioPerfil(long id) {
	       UsuarioPerfil UsuarioPerfil = new UsuarioPerfil();
	       UsuarioPerfil.setId(id);
	       hibernateUtil.delete(UsuarioPerfil);
	   }


	   public List<UsuarioPerfil> listUsuarioPerfil() {        
	       return hibernateUtil.fetchAll(UsuarioPerfil.class);
	   }


	   public UsuarioPerfil getUsuarioPerfil(long id) {
	       return hibernateUtil.fetchById(id, UsuarioPerfil.class);
	   }
	   
		public List<UsuarioPerfil> listUsuario(String query) {
			// TODO Auto-generated method stub
			 return hibernateUtil.fetchAllHibernate(query);
		}
		
		public List<UsuarioPerfil> getUsuarioPerfil(String email, String clave) {
		
		//	String query ="from UsuarioPerfil as up inner join up.usuario as u inner join up.perfil as p where u.email=''{0}'' and u.clave=''{1}''";
			String query ="from UsuarioPerfil as up where up.usuario.email=''{0}'' and up.usuario.clave=''{1}''";
			
			query=	MessageFormat.format(query, email,clave);
			List<UsuarioPerfil> listUsuarioPerfil = listUsuario(query);
			return listUsuarioPerfil;
		}

}
