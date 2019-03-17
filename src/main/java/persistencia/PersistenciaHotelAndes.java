package persistencia;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import negocio.Reserva;
import negocio.ReservaServicio;
import negocio.Servicio;

public class PersistenciaHotelAndes 
{
	//------------------------------------------------
	//--------------------Constantes------------------
	//------------------------------------------------
	/**
	 * Logger para escribir la taza de la ejecucion
	 */
	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	
	//------------------------------------------------
	//--------------------Atributos-------------------
	//------------------------------------------------
	/**
	 * Atributo privado que es el unico objeto de la clase - Patron SINGLETON
	 */
	private static PersistenciaHotelAndes instance;
	
	/**
	 * Frabrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla CONSUMORESERVA de la base de datos
	 */
	private SQLConsumoReserva sqlConsumoReserva;
	
	/**
	 * Atributo para el acceso a la tabla CUENTACONSUMO de la base de datos
	 */
	private SQLCuentaConsumo sqlCuentaConsumo;

	/**
	 * Atributo para el acceso a la tabla DOTACION de la base de datos
	 */
	private SQLDotacion sqlDotacion;
	
	/**
	 * Atributo para el acceso a la tabla DOTACIONHABITACION de la base de datos
	 */
	private SQLDotacionHabitacion sqlDotacionHabitacion;
	
	/**
	 * Atributo para el acceso a la tabla FACTURA de la base de datos
	 */
	private SQLFactura sqlFactura;
	
	/**
	 * Atributo para el acceso a la tabla FACTURASCUENTACONSUMO de la base de datos
	 */
	private SQLFacturasCuentaConsumo sqlFacturasCuentaConsumo;
	
	/**
	 * Atributo para el acceso a la tabla HABITACION de la base de datos
	 */
	private SQLHabitacion sqlHabitacion;
	
	/**
	 * Atributo para el acceso a la tabla HABITACION de la base de datos
	 */
	private SQLHabitacionesHotel sqlHabitacionesHotel;
	
	/**
	 * Atributo para el acceso a la tabla HORARIOSERVICIO de la base de datos
	 */
	private SQLHorarioServicio sqlHorarioServicio;
	
	/**
	 * Atributo para el acceso a la tabla HOTEL de la base de datos
	 */
	private SQLHotel sqlHotel;
	
	/**
	 * Atributo para el acceso a la tabla PERSONA de la base de datos
	 */
	private SQLPersona sqlPersona;
	
	/**
	 * Atributo para el acceso a la tabla PERSONASHOTEL de la base de datos
	 */
	private SQLPersonasHotel sqlPersonasHotel;
	
	/**
	 * Atributo para el acceso a la tabla PLANDECONSUMO de la base de datos
	 */
	private SQLPlanDeConsumo sqlPlanDeConsumo;
	
	/**
	 * Atributo para el acceso a la tabla PLANESHOTEL de la base de datos
	 */
	private SQLPlanesHotel sqlPlanesHotel;
	
	/**
	 * Atributo para el acceso a la tabla PRODUCTO de la base de datos
	 */
	private SQLProducto sqlProducto;
	
	/**
	 * Atributo para el acceso a la tabla PRODUCTOSFACTURA de la base de datos
	 */
	private SQLProductosFactura sqlProductosFactura;
	
	/**
	 * Atributo para el acceso a la tabla RESERVA de la base de datos
	 */
	private SQLReserva sqlReserva;
	
	/**
	 * Atributo para el acceso a la tabla RESERVASERVICIO de la base de datos
	 */
	private SQLReservaServicio sqlReservaServicio;
	
	/**
	 * Atributo para el acceso a la tabla ROL de la base de datos
	 */
	private SQLRol sqlRol;
	
	/**
	 * Atributo para el acceso a la tabla SERVICIO de la base de datos
	 */
	private SQLServicio sqlServicio;
	
	/**
	 * Atributo para el acceso a la tabla SERVICIOSHOTEL de la base de datos
	 */
	private SQLServiciosHotel sqlServiciosHotel;
	
	/**
	 * Atributo para el acceso a la tabla SERVICIOSPLANCONSUMO de la base de datos
	 */
	private SQLServiciosPlanConsumo sqlServiciosPlanConsumo;
	
	/**
	 * Atributo para el acceso a la tabla SERVICIOSTOMADOS de la base de datos
	 */
	private SQLServiciosTomados sqlServiciosTomados;
	
	/**
	 * Atributo para el acceso a la tabla TIPOCONSUMO de la base de datos
	 */
	private SQLTipoConsumo sqlTipoConsumo;
	
	/**
	 * Atributo para el acceso a la tabla TIPODOCUMENTO de la base de datos
	 */
	private SQLTipoDocumento sqlTipoDocumento;
	
	/**
	 * Atributo para el acceso a la tabla TIPOHABITACION de la base de datos
	 */
	private SQLTipoHabitacion sqlTipoHabitacion;
	
	/**
	 * Atributo para el acceso a la tabla TIPOSERVICIO de la base de datos
	 */
	private SQLTipoServicio sqlTipoServicio;
	
	/**
	 * Atributo para el acceso a la tabla UNTENCILIO de la base de datos
	 */
	private SQLUtencilio sqlUtencilio;
	
	/**
	 * Atributo para el acceso a la tabla UNTENCILIOSPRESTADOS de la base de datos
	 */
	private SQLUtenciliosPrestados sqlUtenciliosPrestados;
	
	//------------------------------------------------
	//------------------Constructores-----------------
	//------------------------------------------------
	/**
	 * Constructor privado con valores por defecto - Patron SINGLETON
	 */
	private PersistenciaHotelAndes()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
		crearClasesSQL ();
		
		tablas = new LinkedList<String> ();
		tablas.add ("SuperAndes_sequence");
		tablas.add ("CONSUMORESERVA");	tablas.add ("CUENTACONSUMO");	tablas.add ("DOTACION");	tablas.add ("DOTACIONHABITACION");	tablas.add ("FACTURA");
		tablas.add ("FACTURASCUENTACONSUMO");	tablas.add ("HABITACION"); tablas.add ("HABITACIONESHOTEL"); tablas.add ("HORARIOSERVICIO"); tablas.add ("HOTEL");
		tablas.add ("PERSONA"); tablas.add ("PERSONASHOTEL"); tablas.add ("PLANDECONSUMO"); tablas.add ("PLANESHOTEL"); tablas.add ("PRODUCTO");
		tablas.add ("PRODUCTOSFACTURA"); tablas.add ("RESERVA"); tablas.add ("RESERVASERVICIO"); tablas.add ("ROL"); tablas.add ("SERVICIO");
		tablas.add ("SERVICIOSHOTEL"); tablas.add ("SERVICIOSPLANCONSUMO"); tablas.add ("SERVICIOSTOMADOS"); tablas.add ("TIPOCONSUMO"); tablas.add ("TIPODOCUMENTO");
		tablas.add ("TIPOHABITACION"); tablas.add ("TIPOSERVICIO"); tablas.add ("UTENCILIO"); tablas.add ("UTENCILIOSPRESTADOS");
	}
	
	/**
	 * 
	 * @param tableConfig
	 */
	private PersistenciaHotelAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	//------------------------------------------------
	//---------------------Metodos--------------------
	//------------------------------------------------
	/**
	 * Retorna el unico objeto PersistenciaHotelAndes existente
	 * @return el unico objeto PersistenciaHotelAndes existente
	 */
	public static PersistenciaHotelAndes getInstance ()
	{
		if (instance == null)		
			instance = new PersistenciaHotelAndes ();
		
		return instance;
	}
	
	public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)		
			instance = new PersistenciaHotelAndes (tableConfig);
		
		return instance;
	}
	
	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	private void crearClasesSQL ()
	{
		sqlConsumoReserva = new SQLConsumoReserva(this); sqlCuentaConsumo = new SQLCuentaConsumo(this); sqlDotacion = new SQLDotacion(this);
		sqlDotacionHabitacion = new SQLDotacionHabitacion(this); sqlFactura = new SQLFactura(this); sqlFacturasCuentaConsumo = new SQLFacturasCuentaConsumo(this);
		sqlHabitacion = new SQLHabitacion(this); sqlHabitacionesHotel = new SQLHabitacionesHotel(this); sqlHorarioServicio = new SQLHorarioServicio(this);
		sqlHotel = new SQLHotel(this); sqlPersona = new SQLPersona(this); sqlPersonasHotel = new SQLPersonasHotel(this); sqlPlanDeConsumo = new SQLPlanDeConsumo(this);
		sqlPlanesHotel = new SQLPlanesHotel(this); sqlProducto = new SQLProducto(this); sqlProductosFactura =  new SQLProductosFactura(this); sqlReserva = new SQLReserva(this);
		sqlReservaServicio = new SQLReservaServicio(this); sqlRol = new SQLRol(this); sqlServicio = new SQLServicio(this); sqlServiciosHotel = new SQLServiciosHotel(this);
		sqlServiciosPlanConsumo = new SQLServiciosPlanConsumo(this); sqlServiciosTomados = new SQLServiciosTomados(this); sqlTipoConsumo = new SQLTipoConsumo(this);
		sqlTipoDocumento = new SQLTipoDocumento(this); sqlTipoHabitacion = new SQLTipoHabitacion(this); sqlTipoServicio = new SQLTipoServicio(this); sqlUtencilio = new SQLUtencilio(this);
		sqlUtenciliosPrestados = new SQLUtenciliosPrestados(this);
	}
	
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 28 números que indican el número de tuplas borradas 
	 */
	public long [] limpiarHotelAndes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarParranderos (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1,-1, -1, -1, -1, -1,-1, -1, -1, -1, -1,
        			-1, -1, -1, -1, -1,-1, -1, -1, -1, -1,-1,-1,-1};
        }
        finally
        {
            if (tx.isActive())            
                tx.rollback();
            
            pm.close();
        }		
	}
	//---------------------------------------------------------------
	//------------------------------RF7------------------------------
	//---------------------------------------------------------------
	//RF7 - REGISTRAR UNA RESERVA DE ALOJAMIENTO
	//Reserva una habitación por un período de tiempo, por parte de un cliente, siempre y cuando esté disponible.
	//Esta operación es realizada por un cliente.
	public Reserva realizarUnaReserva(long idTipoDocumentoPersona, long documentoPersona, String numeroHabitacion, Double costo,
			Integer numeroPersonas, Date fechaEntrada, Date fechaSalida)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            if(sqlHabitacion.darHabitacionPorNumero(pm, numeroHabitacion) == null)
            {
            	  long idReserva = nextval ();
                  long tuplasInsertadas = sqlReserva.
                  		adicionarReserva(pm, idReserva, idTipoDocumentoPersona, documentoPersona, numeroHabitacion, costo, 
                  				numeroPersonas, fechaEntrada, fechaSalida);
                  tx.commit();
                  
                  log.trace ("Inserción de reserva con id: " + idReserva + ": " + tuplasInsertadas + " tuplas insertadas");
                  
                  return new Reserva(idReserva, idTipoDocumentoPersona, documentoPersona, numeroHabitacion, costo, numeroPersonas, false, false, fechaEntrada, fechaSalida);   
            }
            else
            {
            	log.error("La habitacion no esta disponible");
            	return null;
            }
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())            
                tx.rollback();
            
            pm.close();
        }
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
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	Integer servicioCapacidad =sqlServicio.darServicioPorId(pm, idServicio).getCapacidad();
        	if(cantidadAsistentes > 0 || servicioCapacidad < cantidadAsistentes) 
        	{
        		tx.begin();        		
                long tuplasInsertadas = sqlReservaServicio.
                		adicionarReservaServicio(pm, idReserva, idServicio, comienzoReserva, finalReserva, cantidadAsistentes);
                tx.commit();
                
                log.trace ("Inserción de reservaServicio con ids: " 
                		+ idReserva +" "+ idServicio+": " + tuplasInsertadas + " tuplas insertadas");
                
                return new ReservaServicio(idReserva, idServicio, comienzoReserva, finalReserva, cantidadAsistentes);
        	}
        	else
        	{
        		log.error("Deben haber asistentes para realizar una reserva");
        		return null;
        	}
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
}
