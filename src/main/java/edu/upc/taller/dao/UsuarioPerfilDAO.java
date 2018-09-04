package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.UsuarioPerfil;

public interface UsuarioPerfilDAO {
	public UsuarioPerfil getUsuarioPerfil(long UsuarioPerfilId);

    public Long addUsuarioPerfil(UsuarioPerfil UsuarioPerfil) ;

    public void deleteUsuarioPerfil(long UsuarioPerfilId);

    public UsuarioPerfil updateUsuarioPerfil(UsuarioPerfil UsuarioPerfil);
	
    public List<UsuarioPerfil> listUsuarioPerfil();
    
    public List<UsuarioPerfil> getUsuarioPerfil(String celular, String clave);
    public List<UsuarioPerfil> getUsuarioPerfil(String celular);
    
    public List<UsuarioPerfil> listUsuario(String query);
    public List<UsuarioPerfil> getUsuarioPerfilxCelularPerfil(String celular, String codigoPerfil);
}
