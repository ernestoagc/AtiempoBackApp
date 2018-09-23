package edu.upc.taller.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UsuarioDTO implements Serializable{

	private Long id;

	private String nombre;
	
	private String accion;

	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String email;
	private String numeroDocumento;
	private String numeroBrevete;
	private String tipoBrevete;
	private String clave;
	
	private String password;
	private String confirmPassword;
	
	
	private String celular;
	
	private String mensaje;
	private String error;
	
	private String nroVoucher;
	private String soat;
	private String licenciaConducir;
	private String numeroPlaca;
	private String nroCuenta;
	
	
	private String perfil;
	
	private List<RolDTO> rolesDTO;
	private List<PerfilDTO> perfiles;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<RolDTO> getRolesDTO() {
		return rolesDTO;
	}

	public void setRolesDTO(List<RolDTO> rolesDTO) {
		this.rolesDTO = rolesDTO;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	public List<PerfilDTO> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<PerfilDTO> perfiles) {
		this.perfiles = perfiles;
	}
	
	

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNumeroBrevete() {
		return numeroBrevete;
	}

	public void setNumeroBrevete(String numeroBrevete) {
		this.numeroBrevete = numeroBrevete;
	}

	public String getTipoBrevete() {
		return tipoBrevete;
	}

	public void setTipoBrevete(String tipoBrevete) {
		this.tipoBrevete = tipoBrevete;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

	public String getNroVoucher() {
		return nroVoucher;
	}

	public void setNroVoucher(String nroVoucher) {
		this.nroVoucher = nroVoucher;
	}

	public String getSoat() {
		return soat;
	}

	public void setSoat(String soat) {
		this.soat = soat;
	}

	public String getLicenciaConducir() {
		return licenciaConducir;
	}

	public void setLicenciaConducir(String licenciaConducir) {
		this.licenciaConducir = licenciaConducir;
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nombre=" + nombre + ", accion=" + accion + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", numeroDocumento="
				+ numeroDocumento + ", numeroBrevete=" + numeroBrevete + ", tipoBrevete=" + tipoBrevete + ", clave="
				+ clave + ", password=" + password + ", confirmPassword=" + confirmPassword + ", celular=" + celular
				+ ", mensaje=" + mensaje + ", error=" + error + ", perfil=" + perfil + ", rolesDTO=" + rolesDTO
				+ ", perfiles=" + perfiles + "]";
	}


	
	







	
	
	
}
