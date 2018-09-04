package edu.upc.taller.util;

public abstract class Constante {
	
	public static abstract class LISTA
	{
		public static final String ESTADO_VIAJE = "ESTADO_VIAJE";
	}
	
	public static abstract class ESTADO_VIAJE
	{
		public static final String PENDIENTE = "PENDIENTE";
		public static final String EN_PROGRESO = "EN_PROGRESO";
		public static final String TERMINADO = "TERMINADO";
		public static final String CANCELADO = "CANCELADO";
	}
	
	public static abstract class PERFIL
	{
		public static final String CODIGO_PASAJERO= "PASAJERO";
		public static final String CODIGO_CONDUCTOR= "CONDUCTOR";
	}
	

}
