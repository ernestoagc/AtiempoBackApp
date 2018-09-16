package edu.upc.taller.rest.controller;

import java.io.BufferedReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;

import edu.upc.taller.dao.RutaDao;
import edu.upc.taller.modelo.*;
import edu.upc.taller.rest.dto.EntradaDTO;
import edu.upc.taller.rest.dto.ReservaDTO;
import edu.upc.taller.rest.dto.SalidaDTO;
import edu.upc.taller.rest.dto.UsuarioDTO;
import edu.upc.taller.servicio.ConfiguracionServicio;
import edu.upc.taller.servicio.RestServicio;
import edu.upc.taller.servicio.SeguridadServicio;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="service")
public class AtiempoController {


	@Autowired
	ConfiguracionServicio configuracionServicio;
	
	@Autowired
	SeguridadServicio seguridadServicio;
	
	@Autowired
	RestServicio restServicio;
	
	
	
	
	
	@RequestMapping(value="/perfil", method=RequestMethod.GET)
	public ModelAndView getEjemplo()
	{
		ModelAndView  view = new ModelAndView("ejemplo");
		//  List<Usuario> list = usuarioService.listar();
		
		return view;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	@ResponseBody
	public UsuarioDTO listarUsuario(HttpServletRequest request, HttpServletResponse  response) throws Exception {
		//Monitor monitor = null ;
		Map<String, Object> mapResponse=null;
		UsuarioDTO resultado= new UsuarioDTO();
		try{
			String ticket=getRequestID(request, response);

			Map<String, String> finalParams = getRequestParameters(request);
			
			String celular = finalParams.get("celular");
			String clave = finalParams.get("clave");

			UsuarioDTO usuarioDTO=restServicio.getUsuario(celular,clave);
			resultado=usuarioDTO;

			Long inicio = System.currentTimeMillis();

			mapResponse=new HashMap<String, Object>();

			 List<Ruta> rutas = configuracionServicio.listRuta();
			 System.out.println(rutas);

			String jsonRutas =getObjectMapper().writeValueAsString(rutas);
			// mapResponse.put("data", usuarioDTO);
		
		}catch (Exception e) {			
			throw e; 
		}finally {
		
		}
		return resultado;
	}
	
	

	
	@RequestMapping(value = "/configuracion", method = RequestMethod.GET)
	@ResponseBody
	public List<SalidaDTO> listarParametria(HttpServletRequest request, HttpServletResponse  response) throws Exception {
		//Monitor monitor = null ;
		
		List<SalidaDTO> resultado= new ArrayList<SalidaDTO>();
		try{
			String ticket=getRequestID(request, response);

			Map<String, String> finalParams = getRequestParameters(request);
			
			String tabla = finalParams.get("tabla");
			if(tabla!=null) {
				if(tabla.equals("RUTA")) {
					resultado= restServicio.getRutas();				
				}
				
				if(tabla.equals("ESTADO_VIAJE")) {
					resultado= restServicio.getEstadoViajes();					
				}
				
				if(tabla.equals("PERFIL") || tabla.equals("ROL")) {
					resultado= restServicio.getPerfiles();					
				}
				
			}
			
		
		}catch (Exception e) {			
			throw e; 
		}finally {
		
		}
		return resultado;
	}
	
	@RequestMapping(value = "/pasajero/registrar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public UsuarioDTO registrarPasajero(HttpServletRequest request, HttpServletResponse  response) throws Exception {
		UsuarioDTO respuesta = new UsuarioDTO();
		String json = readJsonRequest(request);
		UsuarioDTO usuarioDTO = getObjectMapper().readValue(json, UsuarioDTO.class);
		respuesta = restServicio.insertPasajero(usuarioDTO);
		return respuesta;
	}
	
	@RequestMapping(value = "/conductor/registrar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public UsuarioDTO registrarConductor(HttpServletRequest request, HttpServletResponse  response) throws Exception {
		UsuarioDTO respuesta = new UsuarioDTO();
		String json = readJsonRequest(request);
		UsuarioDTO usuarioDTO = getObjectMapper().readValue(json, UsuarioDTO.class);
		respuesta = restServicio.insertConductor(usuarioDTO);
		return respuesta;
	}
	
	@RequestMapping(value = "/reserva", method = RequestMethod.POST, consumes = "application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public SalidaDTO registrarReserva(HttpServletRequest request, HttpServletResponse  response) throws Exception {
		SalidaDTO respuesta = new SalidaDTO();
		String json = readJsonRequest(request);
		EntradaDTO entradaDTO = getObjectMapper().readValue(json, EntradaDTO.class);
		respuesta = restServicio.insertReserva(entradaDTO);
		return respuesta;
	}
	
	@RequestMapping(value = "/reserva", method = RequestMethod.GET)
	@ResponseBody
	public List<ReservaDTO> listarReservas(HttpServletRequest request, HttpServletResponse  response) throws Exception {
	  List<ReservaDTO> resultado= new ArrayList<ReservaDTO>();

		Map<String, String> finalParams = getRequestParameters(request);
		String celular = finalParams.get("celular");
		String perfil = finalParams.get("perfil");
		String estado = finalParams.get("estado");
		resultado = restServicio.getReserva(celular, perfil, estado);
		
	  return resultado;
	}


	//@RequestMapping(value = "/reserva/cancelar/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@RequestMapping(value = "/reserva/cancelar", method = RequestMethod.GET)
	@ResponseBody
	public SalidaDTO modificarCotizacion(HttpServletRequest request, HttpServletResponse  response)  throws Exception {
		SalidaDTO resultado = new SalidaDTO();
		Map<String, String> finalParams = getRequestParameters(request);
		String id = finalParams.get("id");
		String json = readJsonRequest(request);
		resultado = restServicio.cancelarReserva(id);
		
		return resultado;
	}

	
	/*
	@SuppressWarnings("unchecked")
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/reserva/cancelar/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public SalidaDTO modificarCotizacion(@PathVariable String id, HttpServletRequest request, HttpServletResponse  response) throws Exception {
		SalidaDTO resultado = new SalidaDTO();
		String json = readJsonRequest(request);
		resultado = restServicio.cancelarReserva(id);
		
		return resultado;
	}

*/


	protected Map<String, String> getRequestParameters(HttpServletRequest request)
	  {
	    Map<String, String[]> requestParameters = request.getParameterMap();
	    Map<String, String> finalParams = new HashMap();
	    for (Map.Entry<String, String[]> entry : requestParameters.entrySet())
	    {
	      String key = (String)entry.getKey();
	      String value = null;
	      if ((entry.getValue() != null) && (((String[])entry.getValue()).length > 0)) {
	        value = ((String[])(String[])entry.getValue())[0];
	      }
	      finalParams.put(key, value);
	    }
	    return finalParams;
	  }
	
	
	protected ObjectMapper getObjectMapper()
	  {
//	    if (this.objectMapper != null) {
//	      return this.objectMapper;
//	    }
		ObjectMapper objectMapper = new ObjectMapper();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	    objectMapper.setDateFormat(df);
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    objectMapper.setSerializationInclusion(Include.NON_NULL);
	    objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	    return objectMapper;
	  }
	  
	public String readJsonRequest(HttpServletRequest request) {
		StringBuilder jb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
		} catch (Exception e) {
			
		}
		return jb.toString();
	}
	
	public String getRequestID(HttpServletRequest request, HttpServletResponse response)
	  {
	   
	    String ticket = request.getHeader("requestID");
	    if (ticket != null) {
	      response.addHeader("requestID", ticket);
	    }
	    return ticket;
	  }
}
