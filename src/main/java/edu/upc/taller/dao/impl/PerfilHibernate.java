package edu.upc.taller.dao.impl;


import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.upc.taller.dao.*;
import edu.upc.taller.modelo.Perfil;
import edu.upc.taller.modelo.UsuarioPerfil;
import edu.upc.taller.util.HibernateUtil;

@Repository
public class PerfilHibernate  implements PerfilDAO{
	
	  @Autowired
	   private HibernateUtil hibernateUtil;

	  public PerfilHibernate() {
		  System.out.println("PerfilHibernate");
	}


	   public Long addPerfil(Perfil Perfil) {        
	       return (Long) hibernateUtil.create(Perfil);
	   }


	   public Perfil updatePerfil(Perfil Perfil) {        
	       return hibernateUtil.update(Perfil);
	   }
	   
	   public void deletePerfil(long id) {
	       Perfil Perfil = new Perfil();
	       Perfil.setId(id);
	       hibernateUtil.delete(Perfil);
	   }


	   public List<Perfil> listPerfil() {        
	       return hibernateUtil.fetchAll(Perfil.class);
	   }


	   public Perfil getPerfil(long id) {
	       return hibernateUtil.fetchById(id, Perfil.class);
	   }
	   public List<Perfil> listPerfil(String query) {
			// TODO Auto-generated method stub
			 return hibernateUtil.fetchAllHibernate(query);
		}


	public List<Perfil> getPerfil(String codigoPerfil) {
		// TODO Auto-generated method stub
		String query ="select p from Perfil as p where p.codigo.celular=''{0}''";
		
		query=	MessageFormat.format(query, codigoPerfil);
		List<Perfil> listPerfil = listPerfil(query);
		return listPerfil;
	}

}
