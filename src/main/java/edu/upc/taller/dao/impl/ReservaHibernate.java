package edu.upc.taller.dao.impl;

import edu.upc.taller.dao.ReservaDAO;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.upc.taller.dao.*;
import edu.upc.taller.modelo.Perfil;
import edu.upc.taller.modelo.Reserva;
import edu.upc.taller.util.BeanStringUtil;
import edu.upc.taller.util.HibernateUtil;

public class ReservaHibernate implements ReservaDAO{
	@Autowired
	   private HibernateUtil hibernateUtil;

	  public ReservaHibernate() {
		  System.out.println("ReservaHibernate");
	}


	   public Long addReserva(Reserva Reserva) {        
	       return (Long) hibernateUtil.create(Reserva);
	   }


	   public Reserva updateReserva(Reserva Reserva) {        
	       return hibernateUtil.update(Reserva);
	   }
	   
	   public void deleteReserva(long id) {
	       Reserva Reserva = new Reserva();
	       Reserva.setId(id);
	       hibernateUtil.delete(Reserva);
	   }


	   public List<Reserva> listReserva() {        
	       return hibernateUtil.fetchAll(Reserva.class);
	   }


	   public Reserva getReserva(long id) {
	       return hibernateUtil.fetchById(id, Reserva.class);
	   }
	   
	   public List<Reserva> listReserva(String query) {
			// TODO Auto-generated method stub
			 return hibernateUtil.fetchAllHibernate(query);
		}
	   
	   public List<Reserva> getReservaxPasajeroEstado(String celular,String estadoCodigo) {
			// TODO Auto-generated method stub
			String query ="select r from Reserva as r where r.usuarioPasajero.usuario.celular=''{0}''";
			
			query=	MessageFormat.format(query, celular);
			
			if(BeanStringUtil.isNotBlank(estadoCodigo)) {
				query=query + " and r.estado.codigo='"+estadoCodigo+"'";				
			}
			
			List<Reserva> listReserva = listReserva(query);
			return listReserva;
		}
}
