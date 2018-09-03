package edu.upc.taller.dao.impl;
import edu.upc.taller.util.*;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.List;
import java.text.MessageFormat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import edu.upc.taller.dao.*;
import edu.upc.taller.dao.impl.*;
import edu.upc.taller.modelo.Ruta;
import edu.upc.taller.modelo.RutaDetalle;
import edu.upc.taller.dao.RutaDetalleDAO;

@Repository
public class RutaDetalleHibernate implements RutaDetalleDAO {
	
	
	@Autowired
    private SessionFactory sessionFactory;

   @Autowired
   private HibernateUtil hibernateUtil;



   public Long addRutaDetalle(RutaDetalle RutaDetalle) {        
       return (Long) hibernateUtil.create(RutaDetalle);
   }


   public RutaDetalle updateRutaDetalle(RutaDetalle RutaDetalle) {        
       return hibernateUtil.update(RutaDetalle);
   }
   
   public void deleteRutaDetalle(long id) {
       RutaDetalle RutaDetalle = new RutaDetalle();
       RutaDetalle.setId(id);
       hibernateUtil.delete(RutaDetalle);
   }


   public List<RutaDetalle> listRutaDetalle() {        
       return hibernateUtil.fetchAll(RutaDetalle.class);
   }


   public RutaDetalle getRutaDetalle(long id) {
       return hibernateUtil.fetchById(id, RutaDetalle.class);
   }
   
   public List<RutaDetalle> listRutaDetalle(String query) {
		// TODO Auto-generated method stub
		 return hibernateUtil.fetchAllHibernate(query);
	}
   
   public List<RutaDetalle> getRutaDetalle(Long idRuta) {
		
		//	String query ="select up from RutaDetalle as up inner join up.usuario as u inner join up.perfil as p where u.celular=''{0}'' and u.clave=''{1}''";
			String query ="select rd from RutaDetalle as rd where rd.ruta.id="+idRuta;
			
			//query=	MessageFormat.format(query, idRuta.toString());
			List<RutaDetalle> listRutaDetalle = listRutaDetalle(query);
			System.out.println("==>query: "+query);
			
			return listRutaDetalle;
			//return listRutaDetalle();
		}
}
