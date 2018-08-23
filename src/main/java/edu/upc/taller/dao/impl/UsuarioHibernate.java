package edu.upc.taller.dao.impl;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.upc.taller.dao.*;
import edu.upc.taller.modelo.Usuario;
import edu.upc.taller.util.HibernateUtil;

@Repository
public class UsuarioHibernate  implements UsuarioDAO{
	
	  @Autowired
	   private HibernateUtil hibernateUtil;

	  public UsuarioHibernate() {
		  System.out.println("UsuarioHibernate");
	}


	   public Long addUsuario(Usuario Usuario) {        
	       return (Long) hibernateUtil.create(Usuario);
	   }


	   public Usuario updateUsuario(Usuario Usuario) {        
	       return hibernateUtil.update(Usuario);
	   }
	   
	   public void deleteUsuario(long id) {
	       Usuario Usuario = new Usuario();
	       Usuario.setId(id);
	       hibernateUtil.delete(Usuario);
	   }


	   public List<Usuario> listUsuario() {        
	       return hibernateUtil.fetchAll(Usuario.class);
	   }


	   public Usuario getUsuario(long id) {
	       return hibernateUtil.fetchById(id, Usuario.class);
	   }


	public List<Usuario> listUsuario(String query) {
		// TODO Auto-generated method stub
		 return hibernateUtil.fetchAllHibernate(query);
	}
	
	public Usuario getUsuario(String email, String clave) {
	
		String query ="from Usuario where email=''{0}'' and clave=''{1}''";
		
		query=	MessageFormat.format(query, email,clave);
		List<Usuario> listUsuario = listUsuario(query);
		if(listUsuario!=null && listUsuario.size()>0) {
			return listUsuario.get(0);
		}
		return null;
	}

}
