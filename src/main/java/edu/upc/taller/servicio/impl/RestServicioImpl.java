package edu.upc.taller.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import edu.upc.taller.dao.UsuarioPerfilDAO;
import edu.upc.taller.dao.ValorDAO;
import edu.upc.taller.dao.PerfilDAO;
import edu.upc.taller.dao.ReservaDAO;
import edu.upc.taller.dao.RutaDao;
import edu.upc.taller.dao.RutaDetalleDAO;
import edu.upc.taller.dao.UsuarioDAO;
import edu.upc.taller.modelo.Perfil;
import edu.upc.taller.modelo.Reserva;
import edu.upc.taller.modelo.Ruta;
import edu.upc.taller.modelo.RutaDetalle;
import edu.upc.taller.modelo.Usuario;
import edu.upc.taller.modelo.UsuarioPerfil;
import edu.upc.taller.modelo.Valor;
import edu.upc.taller.rest.dto.EntradaDTO;
import edu.upc.taller.rest.dto.ReservaDTO;
import edu.upc.taller.rest.dto.RolDTO;
import edu.upc.taller.rest.dto.SalidaDTO;
import edu.upc.taller.rest.dto.UsuarioDTO;
import edu.upc.taller.servicio.RestServicio;
import edu.upc.taller.util.BeanFunctionUtil;
import edu.upc.taller.util.BeanStringUtil;
import edu.upc.taller.util.Constante;



@Service
@Transactional
public class RestServicioImpl implements RestServicio {

	@Autowired
	UsuarioPerfilDAO usuarioPerfilDAO;
	
	@Autowired
	RutaDao rutaDAO;
	
	@Autowired
	RutaDetalleDAO rutaDetalleDAO;
	
	@Autowired
	ValorDAO valorDAO;
	
	@Autowired
	ReservaDAO reservaDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	PerfilDAO perfilDAO;
	
	public UsuarioDTO getUsuario(String celular, String clave) {
		
		if(BeanStringUtil.isBlank(celular))
			celular="";
		
		if(BeanStringUtil.isBlank(clave))
			celular="";
		
		//verificar si existe usuario
		List<UsuarioPerfil> usuariosPerfilExiste=usuarioPerfilDAO.getUsuarioPerfil(celular);
		System.out.println("===>usuariosPerfilExiste: "+usuariosPerfilExiste);
		if(usuariosPerfilExiste==null || usuariosPerfilExiste.size()==0) {
			
			UsuarioDTO usuarioDTO= new UsuarioDTO();
			usuarioDTO.setError("E001");
			usuarioDTO.setMensaje("El usuario no existe");
			return usuarioDTO;
		} 
		
		
		List<UsuarioPerfil> usuariosPerfil=usuarioPerfilDAO.getUsuarioPerfil(celular, clave);
		if( usuariosPerfil.size()>0) {
			
			UsuarioDTO usuarioDTO=BeanFunctionUtil.UsuarioDTO(usuariosPerfil);
			return usuarioDTO;
		}else {
			
			UsuarioDTO usuarioDTO= new UsuarioDTO();
			usuarioDTO.setError("E002");
			usuarioDTO.setMensaje("Clave incorreta");
			return usuarioDTO;
		}
		
	
		
	
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public SalidaDTO insertReserva(EntradaDTO entradaDTO) {
		
		SalidaDTO salidaDTO= new SalidaDTO();
		try {
			Reserva reserva = new Reserva();
			
			if(entradaDTO.getCantidadAsiento()==null) {
				
				salidaDTO.setError("A001");
				salidaDTO.setMensaje("Falta ingresar cantidad de asientos");
				return salidaDTO;
			}
			
			if(entradaDTO.getHora()==null) {
				
				salidaDTO.setError("A001");
				salidaDTO.setMensaje("Falta ingresar la hora");
				return salidaDTO;
			}
			
			if(entradaDTO.getMinuto()==null) {
				
				salidaDTO.setError("A001");
				salidaDTO.setMensaje("Falta ingresar el minuto");
				return salidaDTO;
			}
			
			if(entradaDTO.getIdRutaDetalle()==null) {
				
				salidaDTO.setError("A001");
				salidaDTO.setMensaje("Falta ingresar destino");
				return salidaDTO;
			}
			
			Valor estadoPendiente = valorDAO.getValorxCodigoListaValor(Constante.LISTA.ESTADO_VIAJE, Constante.ESTADO_VIAJE.PENDIENTE).get(0);
			List<UsuarioPerfil> usuariosPerfil = usuarioPerfilDAO.getUsuarioPerfilxCelularPerfil(entradaDTO.getCelular(),entradaDTO.getPerfil());
			if(usuariosPerfil.size()==0) {
				salidaDTO.setError("E004");
				salidaDTO.setMensaje("El usuario no existe");
				return salidaDTO;
			}
			
			RutaDetalle rutaDetalle = rutaDetalleDAO.getRutaDetalle(entradaDTO.getIdRutaDetalle());
			
			if(rutaDetalle==null) {
				salidaDTO.setError("E005");
				salidaDTO.setMensaje("La ruta detalle no existe");			
				return salidaDTO;
			}
			java.util.Date fecha = new Date();
			UsuarioPerfil usuarioPerfil = usuariosPerfil.get(0);
			reserva.setUsuarioPasajero(usuarioPerfil);
			reserva.setCantidadAsiento(entradaDTO.getCantidadAsiento());
			reserva.setFecha(fecha);
			reserva.setRutaDetalle(rutaDetalle);
			reserva.setEstado(estadoPendiente);
			reserva.setHora(entradaDTO.getHora());
			reserva.setMinuto(entradaDTO.getMinuto());		
			Long idReserva= reservaDAO.addReserva(reserva);
			salidaDTO.setMensaje("OK");
			salidaDTO.setId(idReserva);
			
		}catch (Exception e) {
			salidaDTO.setError("E006");
			salidaDTO.setMensaje("No se pudo guardar la reserva");
		}
		
		return salidaDTO;
	}
	
	public SalidaDTO cancelarReserva(String idReserva) {
		SalidaDTO salidaDTO= new SalidaDTO();
		try {		
		
			if(BeanStringUtil.isBlank(idReserva)) {
				salidaDTO.setError("E007");
				salidaDTO.setMensaje("El codigo de reserva no existe");
				return salidaDTO;
			}
			Long idReservaNumero = new Long(idReserva);
			Reserva reserva  =  reservaDAO.getReserva(idReservaNumero);
			
			if(reserva==null) {
				salidaDTO.setError("E009");
				salidaDTO.setMensaje("la reserva no existe");
				return salidaDTO;
			}
			
			if(!reserva.getEstado().getCodigo().equals(Constante.ESTADO_VIAJE.PENDIENTE))
			{
				salidaDTO.setError("E020");
				salidaDTO.setMensaje("No se puede cancelar la reserva porque su estado es distinto a PENDIENTE");
				return salidaDTO;
			}
			
			
			Valor estadoCancelado = valorDAO.getValorxCodigoListaValor(Constante.LISTA.ESTADO_VIAJE, Constante.ESTADO_VIAJE.CANCELADO).get(0);
			reserva.setEstado(estadoCancelado);
			reservaDAO.updateReserva(reserva);
			salidaDTO.setId(idReservaNumero);
			salidaDTO.setMensaje("OK");
		}catch (Exception e) {
			salidaDTO.setError("E008");
			salidaDTO.setMensaje("No se pudo cancelar la reserva");
		}
		return salidaDTO;
		
	}
	
	public List<ReservaDTO> getReserva(String celular,String codigoPerfil, String estado) {
			
		List<ReservaDTO> resultado= new ArrayList<ReservaDTO>();
		List<UsuarioPerfil>  usuariosPerfil= usuarioPerfilDAO.getUsuarioPerfilxCelularPerfil(celular,codigoPerfil);
		if(usuariosPerfil.size()==0) {
			return resultado;
		}
		UsuarioPerfil usuarioPerfil=usuariosPerfil.get(0);
		
		List<Reserva> reservas = reservaDAO.getReservaxPasajeroEstado(usuarioPerfil.getUsuario().getCelular(), estado);
		
		if(reservas.size()==0) {
			return resultado;
		}
		
		for(Reserva reserva : reservas) {			
			resultado.add(BeanFunctionUtil.getReservaDTO(reserva));
		}
		
		return resultado;
		
		
		}
	
	public SalidaDTO cancelarReserva(ReservaDTO reservaDTO) {
		
		SalidaDTO salidaDTO = new SalidaDTO();
		return salidaDTO;
	}
	
	public UsuarioDTO validarCamposObligatorios(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta= new UsuarioDTO();
	
		if(BeanStringUtil.isBlank(usuarioDTO.getCelular())) {
			respuesta.setError("E012");
			respuesta.setMensaje("Se debe ingresar Celular");
			return respuesta;
		}
		
		if(BeanStringUtil.isBlank(usuarioDTO.getNombre())) {
			respuesta.setError("E013");
			respuesta.setMensaje("Se debe ingresar Nombre");
			return respuesta;
		}
		
		if(BeanStringUtil.isBlank(usuarioDTO.getApellidoPaterno())) {
			respuesta.setError("E014");
			respuesta.setMensaje("Se debe ingresar Apellido Paterno");
			return respuesta;
		}
		
		
		if(BeanStringUtil.isBlank(usuarioDTO.getApellidoMaterno())) {
			respuesta.setError("E015");
			respuesta.setMensaje("Se debe ingresar Apellido Materno");
			return respuesta;
		}
		
		if(BeanStringUtil.isBlank(usuarioDTO.getEmail())) {
			respuesta.setError("E016");
			respuesta.setMensaje("Se debe ingresar correo electronico");
			return respuesta;
		}
		
		if(BeanStringUtil.isBlank(usuarioDTO.getPassword())) {
			respuesta.setError("E021");
			respuesta.setMensaje("Se debe ingresar una contrase�a");
			return respuesta;
		}
		
		if(BeanStringUtil.isBlank(usuarioDTO.getConfirmPassword())) {
			respuesta.setError("E022");
			respuesta.setMensaje("Se debe ingresar una confirmaci�n de la contrase�a");
			return respuesta;
		}
		
		
		if(!usuarioDTO.getPassword().equals(usuarioDTO.getConfirmPassword())){
			respuesta.setError("E023");
			respuesta.setMensaje("La contrase�a no coincide con la ingresada en el campo de confirmaci�n.");
		}
		
		usuarioDTO.setClave(usuarioDTO.getPassword());
		
		if(BeanStringUtil.isBlank(usuarioDTO.getClave())) {
			respuesta.setError("E017");
			respuesta.setMensaje("Se debe ingresar una clave");
			return respuesta;
		}
		
		
		if(usuarioDTO.getPerfil().equals("CONDUCTOR")){
			
						
			
			if(BeanStringUtil.isBlank(usuarioDTO.getNumeroPlaca())) {
				respuesta.setError("E028");
				respuesta.setMensaje("Se debe ingresar Numero de Placa");
				return respuesta;
			}
			
			if(BeanStringUtil.isBlank(usuarioDTO.getLicenciaConducir())) {
				respuesta.setError("E027");
				respuesta.setMensaje("Se debe ingresar Numero de licencia de conducir");
				return respuesta;
			}
			
			if(BeanStringUtil.isBlank(usuarioDTO.getSoat())) {
				respuesta.setError("E026");
				respuesta.setMensaje("Se debe ingresar Numero de soat");
				return respuesta;
			}
			
			if(BeanStringUtil.isBlank(usuarioDTO.getNroVoucher())) {
				respuesta.setError("E025");
				respuesta.setMensaje("Se debe ingresar Numero de voucher");
				return respuesta;
			}
			
			if(BeanStringUtil.isBlank(usuarioDTO.getNroCuenta())) {
				respuesta.setError("E029");
				respuesta.setMensaje("Se debe ingresar Numero de Cuenta");
				return respuesta;
			}
			
		}
		
		
		if(respuesta.getError()==null) {
			respuesta.setMensaje("OK");	
		}
		
		return respuesta;
	}

	public UsuarioDTO validarEstructuraCelular(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta= new UsuarioDTO();
		boolean tieneNumero=false;
		boolean tieneLetras=false;
		

		for(int i=0;i<usuarioDTO.getClave().length();i++){
		
			try{
		        Integer.parseInt(usuarioDTO.getClave().substring(i,i+1));
		        tieneNumero=true;
		    }catch(NumberFormatException e){
		    	tieneLetras= true;
		    }
			
		}
		
		if(!tieneLetras) {
			if (!usuarioDTO.getClave().matches("[0-9]*")) {
				tieneNumero= true;
		      }	
			
		} 
		
		
		
		if(tieneNumero && tieneLetras) {
			respuesta.setMensaje("OK");					
		}else {
			
			respuesta.setError("E024");
			respuesta.setMensaje("La contrase�a debe contener campos numericos y letras");
		}
		
		/*
		if(respuesta.getError()==null) {
			respuesta.setMensaje("OK");	
		}
		*/
		return respuesta;
	}
	
	public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

	
	
	public UsuarioDTO validarEstructuraCorreo(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta= new UsuarioDTO();
		boolean tieneNumero=false;
		boolean tieneLetras=false;
		
String email=usuarioDTO.getEmail();
//final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
//return EMAIL_REGEX.matcher(email).matches();
	
	        //return Regex.IsMatch(email, EMAIL_VERIFICATION);
		
		
		
		if(tieneNumero && tieneLetras) {
			respuesta.setMensaje("OK");					
		}else {
			
			respuesta.setError("E024");
			respuesta.setMensaje("La contrase�a debe contener campos numericos y letras");
		}
		
		/*
		if(respuesta.getError()==null) {
			respuesta.setMensaje("OK");	
		}
		*/
		return respuesta;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UsuarioDTO insertPasajero(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta= new UsuarioDTO();
		try {
			
			if(usuarioDTO==null) {				
				respuesta.setError("E018");
				respuesta.setMensaje("No se ha enviado un objeto. NULL");
				return respuesta;
			}
			
			usuarioDTO.setAccion("REGISTRAR");
					
			Perfil perfil =null;
			
			List<Perfil> perfiles =perfilDAO.getPerfil(usuarioDTO.getPerfil());					
			if(perfiles.size()>0) {
				perfil = perfiles.get(0);	
			}else{
				respuesta.setMensaje("El Perfil no existe.");
				respuesta.setError("E011");
				return respuesta;
			}	
			
			if(!Constante.PERFIL.CODIGO_PASAJERO.equals(perfil.getCodigo())) {
				respuesta.setMensaje("El c�digo de pasajero es incorrecto.");
				respuesta.setError("E019");
				return respuesta;
			}
			
			UsuarioDTO validarCampos=validarCamposObligatorios(usuarioDTO);
			
			
			
			if(validarCampos.getError()!=null) {
				return validarCampos;
			};
			
			UsuarioDTO validarEstructuraCelular=validarEstructuraCelular(usuarioDTO);
			if(validarEstructuraCelular.getError()!=null) {
				return validarEstructuraCelular;
			};
			
			List<UsuarioPerfil> listUsuarioPerfilExistePasajero = usuarioPerfilDAO.getUsuarioPerfilxCelularPerfil(usuarioDTO.getCelular(), perfil.getCodigo());
		
			
			
			if(listUsuarioPerfilExistePasajero!=null && listUsuarioPerfilExistePasajero.size()>0) {
				respuesta.setMensaje("El numero de celular ya existe. Intente con otro numero.");
				respuesta.setError("E010");
				return respuesta;
			}
			
			
			List<UsuarioPerfil> listUsuarioPerfilExisteConductor = usuarioPerfilDAO.getUsuarioPerfilxCelularPerfil(usuarioDTO.getCelular(), Constante.PERFIL.CODIGO_CONDUCTOR);
			Usuario usuario = null;
			Usuario usuarioRegistrado= null;
			Long idUsuario = 0L;
			if(listUsuarioPerfilExistePasajero.size()==0) {				
				usuario = BeanFunctionUtil.getUsuario(usuarioDTO);		
				idUsuario = usuarioDAO.addUsuario(usuario);
				usuarioRegistrado= usuarioDAO.getUsuario(idUsuario);
			}else {				
				usuarioRegistrado=listUsuarioPerfilExistePasajero.get(0).getUsuario();
			}
			
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
			usuarioPerfil.setPerfil(perfil);
			usuarioPerfil.setUsuario(usuarioRegistrado);
			
			Long idUSuarioPerfil =  usuarioPerfilDAO.addUsuarioPerfil(usuarioPerfil);
			
			if(idUSuarioPerfil!= null || idUSuarioPerfil!=0L) {
				usuarioDTO.setMensaje("OK");			
			}
		}catch (Exception e) {
			respuesta.setMensaje("Hubo problemas al registrar el pasajero. Comuniquese con soporte.");
			respuesta.setError("E003");
			return respuesta;
		}
		
		
		return usuarioDTO;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UsuarioDTO insertConductor(UsuarioDTO usuarioDTO) {
		UsuarioDTO respuesta= new UsuarioDTO();
		try {
			
			if(usuarioDTO==null) {				
				respuesta.setError("E018");
				respuesta.setMensaje("No se ha enviado un objeto. NULL");
			}
			
			usuarioDTO.setAccion("REGISTRAR");
					
			Perfil perfil =null;
			
			List<Perfil> perfiles =perfilDAO.getPerfil(usuarioDTO.getPerfil());					
			if(perfiles.size()>0) {
				perfil = perfiles.get(0);	
			}else{
				respuesta.setMensaje("El Perfil no existe.");
				respuesta.setError("E011");
				return respuesta;
			}	
			
			if(!Constante.PERFIL.CODIGO_CONDUCTOR.equals(perfil.getCodigo())) {
				respuesta.setMensaje("El c�digo de conductor es incorrecto.");
				respuesta.setError("E019");
				return respuesta;
			}
			
			UsuarioDTO validarCampos=validarCamposObligatorios(usuarioDTO);
			
			if(!validarCampos.getMensaje().equals("OK")) {
				return validarCampos;
			};
			
			List<UsuarioPerfil> listUsuarioPerfilExisteConductor = usuarioPerfilDAO.getUsuarioPerfilxCelularPerfil(usuarioDTO.getCelular(), perfil.getCodigo());
		
			
			
			if(listUsuarioPerfilExisteConductor!=null && listUsuarioPerfilExisteConductor.size()>0) {
				respuesta.setMensaje("El numero de celular ya existe. Intente con otro numero.");
				respuesta.setError("E010");
				return respuesta;
			}
			
			
			List<UsuarioPerfil> listUsuarioPerfilExistePasajero = usuarioPerfilDAO.getUsuarioPerfilxCelularPerfil(usuarioDTO.getCelular(), Constante.PERFIL.CODIGO_PASAJERO);
			Usuario usuario = null;
			Usuario usuarioRegistrado= null;
			Long idUsuario = 0L;
			if(listUsuarioPerfilExistePasajero.size()==0) {				
				usuario = BeanFunctionUtil.getUsuario(usuarioDTO);		
				idUsuario = usuarioDAO.addUsuario(usuario);
				usuarioRegistrado= usuarioDAO.getUsuario(idUsuario);
			}else {				
				usuarioRegistrado=listUsuarioPerfilExistePasajero.get(0).getUsuario();
			}
			
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
			usuarioPerfil.setPerfil(perfil);
			usuarioPerfil.setUsuario(usuarioRegistrado);
			
			Long idUSuarioPerfil =  usuarioPerfilDAO.addUsuarioPerfil(usuarioPerfil);
			
			if(idUSuarioPerfil!= null || idUSuarioPerfil!=0L) {
				usuarioDTO.setMensaje("OK");			
			}
		}catch (Exception e) {
			respuesta.setMensaje("Hubo problemas al registrar el conductor. Comuniquese con soporte.");
			respuesta.setError("E003");
		}
		
		
		return usuarioDTO;
	}


	public List<SalidaDTO> getRutas() {
		List<SalidaDTO> resultado=new ArrayList<SalidaDTO>();
		List<Ruta> rutas = rutaDAO.listRuta();
		for(Ruta ruta :rutas) {			
			SalidaDTO rutaDTO=  BeanFunctionUtil.getRuta(ruta);
			List<RutaDetalle> rutaDetalles=  rutaDetalleDAO.getRutaDetallexIdRuta(ruta.getId());	
			rutaDTO.setDetalles(BeanFunctionUtil.getRutaDetalle(rutaDetalles));
			resultado.add(rutaDTO);			
		}
		// TODO Auto-generated method stub
		return resultado;
	}
	
	
	public List<SalidaDTO> getEstadoViajes() {
		List<SalidaDTO> resultado=new ArrayList<SalidaDTO>();
		List<Valor> estados= valorDAO.getValorxCodigoLista(Constante.LISTA.ESTADO_VIAJE);

		for(Valor estado :estados) {			
			SalidaDTO estadoDTO=  BeanFunctionUtil.getEstado(estado);
			resultado.add(estadoDTO);			
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	public List<SalidaDTO> getPerfiles() {
		List<SalidaDTO> resultado=new ArrayList<SalidaDTO>();
		List<Perfil> perfiles= perfilDAO.listPerfil();

		for(Perfil perfil :perfiles) {			
			SalidaDTO estadoDTO=  BeanFunctionUtil.getPerfil(perfil);
			resultado.add(estadoDTO);			
		}
		// TODO Auto-generated method stub
		return resultado;
	}
}
