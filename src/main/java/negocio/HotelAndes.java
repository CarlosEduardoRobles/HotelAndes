package negocio;

import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import persistencia.PersistenciaHotelAndes;

public class HotelAndes 
{
	//---------------------------------------------------------------
	//-------------------------Constantes----------------------------
	//---------------------------------------------------------------
	/**
	 * Logger para escribir la traza de la ejecuci�n
	 */
	private static Logger log = Logger.getLogger(HotelAndes.class.getName());
	
	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaHotelAndes pp;
	
	//---------------------------------------------------------------
	//------------------------Constructores--------------------------
	//---------------------------------------------------------------
	/**
	 * El constructor por defecto
	 */
	public HotelAndes ()
	{
		pp = PersistenciaHotelAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public HotelAndes (JsonObject tableConfig)
	{
		pp = PersistenciaHotelAndes.getInstance (tableConfig);
	}	
	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	//---------------------------------------------------------------
	//------------------------------RF7------------------------------
	//---------------------------------------------------------------
	//RF7 - REGISTRAR UNA RESERVA DE ALOJAMIENTO
	//Reserva una habitaci�n por un per�odo de tiempo, por parte de un cliente, siempre y cuando est� disponible.
	//Esta operaci�n es realizada por un cliente.
	public Reserva realizarUnaReserva(long idTipoDocumentoPersona, String documentoPersona, String numeroHabitacion,
			Integer numeroPersonas, Date fechaEntrada, Date fechaSalida)
	{
        log.info ("Adicionando eserva habitacion: " + numeroHabitacion);
        Reserva reserva = pp.realizarUnaReserva(idTipoDocumentoPersona, documentoPersona, numeroHabitacion, numeroPersonas, fechaEntrada, fechaSalida);		
        log.info ("Adicionando Tipo de bebida: " + reserva);
        return reserva;
	}
	
	//---------------------------------------------------------------
	//------------------------------RF8------------------------------
	//---------------------------------------------------------------
	//RF8 - REGISTRAR UNA RESERVA DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE
	//Reserva la prestaci�n de un servicio por parte de un cliente, siempre y cuando haya disponibilidad. 
	//Esta operaci�n es realizada por un cliente.
	public ReservaServicio adicionarReservaServicio(long idReserva, long idServicio, Date comienzoReserva, 
			Date finalReserva, Integer cantidadAsistentes)
	{
		log.info ("Adicionando reservaServicio: Reserva: " + idReserva + " Servicio: " + idServicio);
		ReservaServicio reservaServicio = pp.adicionarReservaServicio(idReserva, idServicio, comienzoReserva, finalReserva, cantidadAsistentes);
        log.info ("Adicionando reservaServicio: " + reservaServicio);
        return reservaServicio;
	}
	
	//---------------------------------------------------------------
	//------------------------------RF10-----------------------------
	//---------------------------------------------------------------
	//RF10 - REGISTRAR UN CONSUMO DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE O SUS ACOMPA�ANTES
	//Registra un consumo de un servicio por parte de un cliente o sus acompa�antes. Esta operaci�n es
	//realizada por un empleado del hotel.
	public ServiciosTomados adicionarServiciosTomados(long idReserva, long idServicio, Double costo, Integer tiempoUso)
	{
		log.info ("Adicionando servicioTomado: Reserva: " + idReserva + " Servicio: " + idServicio);
		ServiciosTomados servicioTomado = pp.adicionarServiciosTomados(idReserva, idServicio, costo, tiempoUso);
        log.info ("Adicionando servicioTomado: " + servicioTomado);
        return servicioTomado;	
	}
	
	/**
	 * Cierra la conexi�n con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 n�meros que indican el n�mero de tuplas borradas en las tablas.
	 */
	public long [] limpiarParranderos ()
	{
        log.info ("Limpiando la BD de Parranderos");
        long [] borrrados = pp.limpiarHotelAndes();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
    }
}
