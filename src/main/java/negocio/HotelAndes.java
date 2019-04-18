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
	 * Logger para escribir la traza de la ejecución
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
	//Reserva una habitación por un período de tiempo, por parte de un cliente, siempre y cuando esté disponible.
	//Esta operación es realizada por un cliente.
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
	//Reserva la prestación de un servicio por parte de un cliente, siempre y cuando haya disponibilidad. 
	//Esta operación es realizada por un cliente.
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
	//RF10 - REGISTRAR UN CONSUMO DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE O SUS ACOMPAÑANTES
	//Registra un consumo de un servicio por parte de un cliente o sus acompañantes. Esta operación es
	//realizada por un empleado del hotel.
	public ServiciosTomados adicionarServiciosTomados(long idReserva, long idServicio, Double costo, Integer tiempoUso)
	{
		log.info ("Adicionando servicioTomado: Reserva: " + idReserva + " Servicio: " + idServicio);
		ServiciosTomados servicioTomado = pp.adicionarServiciosTomados(idReserva, idServicio, costo, tiempoUso);
        log.info ("Adicionando servicioTomado: " + servicioTomado);
        return servicioTomado;	
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas.
	 */
	public long [] limpiarParranderos ()
	{
        log.info ("Limpiando la BD de Parranderos");
        long [] borrrados = pp.limpiarHotelAndes();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
    }
}
