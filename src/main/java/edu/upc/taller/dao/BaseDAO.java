package edu.upc.taller.dao;

import java.util.List;

public interface BaseDAO <Entidad, TipoLlave> {
	Entidad obtener(TipoLlave id);

	void actualizar(Entidad object);

	void crear(Entidad object);
	
	void grabarTodos(List<Entidad> list);

	void eliminar(Entidad object);

	void eliminarXId(TipoLlave id);
	
	void eliminarTodos(List<Entidad> list);

	List<Entidad> obtenerTodos();

}
