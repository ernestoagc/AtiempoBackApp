package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.Usuario;

public interface UsuarioDAO {
	public Usuario getUsuario(long UsuarioId);

    public Long addUsuario(Usuario Usuario) ;

    public void deleteUsuario(long UsuarioId);

    public Usuario updateUsuario(Usuario Usuario);
	
    public List<Usuario> listUsuario();
    
    public List<Usuario> listUsuario(String query);
    public Usuario getUsuario(String email, String clave) ;
}
