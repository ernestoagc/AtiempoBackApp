package edu.upc.taller.servicio.impl;
import edu.upc.taller.util.Busqueda;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.support.*;
import org.springframework.transaction.annotation.Transactional;

import edu.upc.taller.dao.BaseDAO;
import edu.upc.taller.modelo.Ruta;


public abstract class BaseHibernate
				<Entidad extends Serializable, TipoLlave extends Serializable>
		implements BaseDAO<Entidad, TipoLlave> {
	
	   @Autowired
	    private SessionFactory sessionFactory;
	   
	   
	   
	protected Class<Entidad> domainClass;
	
	@SuppressWarnings("unchecked")
	public BaseHibernate() {
		super();
		this.domainClass = (Class<Entidad>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Entidad obtener(TipoLlave id) {		
		//return (Entidad) getHibernateTemplate().get(domainClass, id);
		 return (Entidad)sessionFactory.getCurrentSession().get(domainClass, id);
	}

	@Transactional
	public void actualizar(Entidad t) {
		//validarAuditoriaActualizar(t);
		//getHibernateTemplate().update(t);
		   sessionFactory.getCurrentSession().update(t);   
	}
	
	@Transactional
	public void crear(Entidad t) {
		//validarAuditoria(t);
		//getHibernateTemplate().persist(t);
		  sessionFactory.getCurrentSession().save(t);        
	}
	
	@Transactional
	public void grabar(Entidad t) {
	//	validarAuditoria(t);
		  sessionFactory.getCurrentSession().saveOrUpdate(t);   
		//getHibernateTemplate().saveOrUpdate(t);
	}
	
	@Transactional
	public void grabarTodos(List<Entidad> list)
	{
		for (Entidad entidad : list) {
			//validarAuditoria(entidad);
			sessionFactory.getCurrentSession().saveOrUpdate(entidad);   
		}
		  
	}

	@Transactional
	public void eliminar(Entidad t) {
		 sessionFactory.getCurrentSession().delete(t);
		 sessionFactory.getCurrentSession().flush();
	}
	
	@Transactional
	public void eliminarXId(TipoLlave id) {
		Object obj = obtener(id);
		 sessionFactory.getCurrentSession().delete(obj);
		 sessionFactory.getCurrentSession().flush();
		//getHibernateTemplate().delete(obj);
	//	getHibernateTemplate().flush();
	}
	
	@Transactional
	public void eliminarTodos(List<Entidad> list) {
		//getHibernateTemplate().deleteAll(list);

		String stringQuery = "DELETE FROM tablename";
		Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
		query.executeUpdate();
	}

	/*
	public <Entidad> List<Entidad> obtenerTodos() {

return null;
	   // return ( List<Entidad>)sessionFactory.getCurrentSession().createQuery(" FROM "+domainClass.getName()).list();  
	    //return sessionFactory.getCurrentSession().createQuery(" FROM "+domainClass.getName()).list();       
		
		
	}
	*/
	/*
	@SuppressWarnings("rawtypes")
	public int contar() {
		List list = getHibernateTemplate().find(
				"select count(*) from " + domainClass.getName() + " x");
		Integer count = (Integer) list.get(0);
		return count.intValue();
	}
*/
	
}
