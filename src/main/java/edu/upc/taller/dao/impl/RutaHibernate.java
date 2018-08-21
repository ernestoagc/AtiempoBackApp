package edu.upc.taller.dao.impl;
import edu.upc.taller.util.*;

import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import edu.upc.taller.dao.*;
import edu.upc.taller.dao.impl.*;
import edu.upc.taller.modelo.Ruta;

import java.util.List;
@Repository
public class RutaHibernate  implements RutaDao {


    @Autowired
    private SessionFactory sessionFactory;

   @Autowired
   private HibernateUtil hibernateUtil;

   public void setSessionFactory(SessionFactory sessionFactory) {
       this.sessionFactory = sessionFactory;
   }

   
   @Autowired
	public RutaHibernate(SessionFactory sessionFactory){
	   this.sessionFactory = sessionFactory;
	 	 System.out.println("RutaHibernate");
	}
   

   public Long addRuta(Ruta Ruta) {        
       return (Long) hibernateUtil.create(Ruta);
   }


   public Ruta updateRuta(Ruta Ruta) {        
       return hibernateUtil.update(Ruta);
   }
   
   public void deleteRuta(long id) {
       Ruta Ruta = new Ruta();
       Ruta.setId(id);
       hibernateUtil.delete(Ruta);
   }


   public List<Ruta> listRuta() {        
       return hibernateUtil.fetchAll(Ruta.class);
   }


   public Ruta getRuta(long id) {
       return hibernateUtil.fetchById(id, Ruta.class);
   }


	
}
