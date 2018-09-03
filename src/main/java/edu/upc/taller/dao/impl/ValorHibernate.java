package edu.upc.taller.dao.impl;

import edu.upc.taller.dao.ValorDAO;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.upc.taller.dao.*;
import edu.upc.taller.modelo.UsuarioPerfil;
import edu.upc.taller.modelo.Valor;
import edu.upc.taller.util.HibernateUtil;

public class ValorHibernate implements ValorDAO{
	@Autowired
	   private HibernateUtil hibernateUtil;

	  public ValorHibernate() {
		  System.out.println("ValorHibernate");
	}


	   public Long addValor(Valor Valor) {        
	       return (Long) hibernateUtil.create(Valor);
	   }


	   public Valor updateValor(Valor Valor) {        
	       return hibernateUtil.update(Valor);
	   }
	   
	   public void deleteValor(long id) {
	       Valor Valor = new Valor();
	       Valor.setId(id);
	       hibernateUtil.delete(Valor);
	   }


	   public List<Valor> listValor() {        
	       return hibernateUtil.fetchAll(Valor.class);
	   }
	   
	   public List<Valor> listValor(String query) {
			// TODO Auto-generated method stub
			 return hibernateUtil.fetchAllHibernate(query);
		}


	   public Valor getValor(long id) {
	       return hibernateUtil.fetchById(id, Valor.class);
	   }
	   
	   public List<Valor> getValorxCodigoListaValor(String codigoLista,String codigoValor) {
		   String query ="select v from Valor as v where v.lista.codigo=''{0}'' and v.codigo=''{1}''";
			query=	MessageFormat.format(query, codigoLista,codigoValor);
			List<Valor> listValor= listValor(query);
			return listValor;
		}
}
