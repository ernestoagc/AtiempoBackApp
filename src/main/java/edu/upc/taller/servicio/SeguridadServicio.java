package edu.upc.taller.servicio;
import java.util.List;

import edu.upc.taller.modelo.Usuario;
import edu.upc.taller.modelo.UsuarioPerfil;

public interface SeguridadServicio {
List<UsuarioPerfil> getUsuarioPerfil(Usuario usuario);
Usuario getUsuario(String email, String clave);
public List<UsuarioPerfil> getUsuarioPerfil(String email, String clave);
}
