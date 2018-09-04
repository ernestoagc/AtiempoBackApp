package edu.upc.taller.dao.impl;

import edu.upc.taller.dao.ValorDAO;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.upc.taller.dao.*;
import edu.upc.taller.modelo.Lista;
import edu.upc.taller.util.HibernateUtil;

@Repository
public class ListaHibernate {
	@Autowired
	   private HibernateUtil hibernateUtil;

	  public ListaHibernate() {
		  System.out.println("ListaHibernate");
	}


	   public Long addLista(Lista Lista) {        
	       return (Long) hibernateUtil.create(Lista);
	   }


	   public Lista updateLista(Lista Lista) {        
	       return hibernateUtil.update(Lista);
	   }
	   
	   public void deleteLista(long id) {
	       Lista Lista = new Lista();
	       Lista.setId(id);
	       hibernateUtil.delete(Lista);
	   }


	   public List<Lista> listLista() {        
	       return hibernateUtil.fetchAll(Lista.class);
	   }


	   public Lista getLista(long id) {
	       return hibernateUtil.fetchById(id, Lista.class);
	   }
}
