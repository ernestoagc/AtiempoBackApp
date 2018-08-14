package edu.upc.taller.rest.controller;

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
import edu.upc.taller.modelo.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping(value="service")
public class AtiempoController {

	@RequestMapping(value="/perfil", method=RequestMethod.GET)
	public ModelAndView getEjemplo()
	{
		ModelAndView  view = new ModelAndView("ejemplo");
		//  List<Usuario> list = usuarioService.listar();
		
		return view;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listarParametria(HttpServletRequest request, HttpServletResponse  response) throws Exception {
		//Monitor monitor = null ;
		Map<String, Object> mapResponse=null;
		try{
			String ticket=getRequestID(request, response);
		//	monitor = getMonitor(Constante.MODPRE_SERVICE.MODIFICAR_COTIZACION.CODIGO, new Date(),ticket);			
			//LOGGER.info("{}|====== SERVICIO LISTAR PARAMETRIA - INICIO====== ",ticket);	
			//ObjectMapper objectMapper = getObjectMapper();		
			Map<String, String> finalParams = getRequestParameters(request);
			//EjecutarProcesoRequest2 ejecutarProcesoRequest	=	getEjecutarProcesoRequest(request, response,ticket,finalParams,objectMapper,  Constante.MODPRE_SERVICE.PARAMETRIA.REGLA, Constante.MODPRE_SERVICE.PARAMETRIA.CODIGO);
			//LOGGER.info(LOG_INFO_MESSAGE_INI,ticket);
			Long inicio = System.currentTimeMillis();
			//mapResponse=consultarServicio(request,response,ticket,ejecutarProcesoRequest,objectMapper,Constante.MODPRE_SERVICE.PARAMETRIA.REGLA,monitor);
			//LOGGER.info(LOG_INFO_MESSAGE_FIN,ticket,(System.currentTimeMillis()-inicio),MILISEGUNDOS);
		//	LOGGER.info("{}|====== SERVICIO LISTAR PARAMETRIA - FIN ====== ",ticket);
		//	monitor.setEstado(Monitor.OK);
			mapResponse=new HashMap<String, Object>();
			 List<Usuario> usuarios= getUsuarios();
			 
			 String jsonInString = getObjectMapper().writeValueAsString(usuarios);
			 mapResponse.put("data", usuarios);
		
		}catch (Exception e) {			
			throw e; 
		}finally {
		
		}
		return mapResponse;
	}
	
	private List<Usuario> getUsuarios(){
		
		List<Usuario> usuarios= new ArrayList<Usuario>();
		
		Usuario usuario1= new Usuario();
		usuario1.setNombre("Juan");
		usuario1.setApellidoPaterno("Perez1");
		usuario1.setNombre("Gutierrez1");
		
		Usuario usuario2= new Usuario();
		usuario2.setNombre("Sergio");
		usuario2.setApellidoPaterno("Perez2");
		usuario2.setNombre("Gutierrez2");
		
		Usuario usuario3= new Usuario();
		usuario3.setNombre("Maria");
		usuario3.setApellidoPaterno("Perez3");
		usuario3.setNombre("Gutierrez3");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		
		return usuarios;
	}
	
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
	  
	
	public String getRequestID(HttpServletRequest request, HttpServletResponse response)
	  {
	   
	    String ticket = request.getHeader("requestID");
	    if (ticket != null) {
	      response.addHeader("requestID", ticket);
	    }
	    return ticket;
	  }
}
