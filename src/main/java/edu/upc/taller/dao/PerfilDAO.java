package edu.upc.taller.dao;

import java.util.List;

import edu.upc.taller.modelo.Perfil;

public interface PerfilDAO {
	public Perfil getPerfil(long PerfilId);

    public Long addPerfil(Perfil Perfil) ;

    public void deletePerfil(long PerfilId);

    public Perfil updatePerfil(Perfil Perfil);
	
    public List<Perfil> listPerfil();
}
