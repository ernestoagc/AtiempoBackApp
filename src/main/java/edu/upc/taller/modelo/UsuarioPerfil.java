package edu.upc.taller.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Table(name = "USUARIO_PERFIL")
public class UsuarioPerfil {
	 @Id	
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")	
	private Long  id;

	 @ManyToOne
	 @JoinColumn(name="USUARIO", nullable=false)	 
	 private Usuario usuario;
		
		
	 @ManyToOne
	 @JoinColumn(name="PERFIL", nullable=false)	
	 private Perfil perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioPerfil [id=" + id + ", usuario=" + usuario + ", perfil=" + perfil + "]";
	}
	 
	
	
	 
}
