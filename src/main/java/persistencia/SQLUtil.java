package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLUtil 
{	
	//---------------------------------------------------------------
	//-------------------------Constantes----------------------------
	//---------------------------------------------------------------
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos.
	 * Se renombra aca para facilitar la escritura de las sentencias.
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;
	
	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * El manejador de persistencia general de la aplicacion
	 */
	private PersistenciaHotelAndes pha;
	
	//---------------------------------------------------------------
	//------------------------Constructores--------------------------
	//---------------------------------------------------------------
	/**
	 * Constructor
	 * @param pha - El manejador de persistencia de la aplicacion
	 */
	public SQLUtil (PersistenciaHotelAndes pha)	{this.pha = pha;}
	
	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo numero de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El numero de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
		//TODO No esto seguro que funcione
        Query q = pm.newQuery(SQL, "SELECT Parranderos_sequence.nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	public long [] limpiarParranderos (PersistenceManager pm)
	{
		Query qConsumoReserva = pm.newQuery(SQL, "DELETE FROM CONSUMORESERVA");    
		Query qCuentaConsumo = pm.newQuery(SQL, "DELETE FROM CUENTACONSUMO"); 
		Query qDotacion = pm.newQuery(SQL, "DELETE FROM DOTACION"); 
		Query qDotacionHabitacion = pm.newQuery(SQL, "DELETE FROM DOTACIONHABITACION"); 
		Query qFactura = pm.newQuery(SQL, "DELETE FROM FACTURA"); 
		Query qFacturasCuentaConsumo = pm.newQuery(SQL, "DELETE FROM FACTURASCUENTACONSUMO"); 
		Query qHabitacion = pm.newQuery(SQL, "DELETE FROM HABITACION"); 
		Query qHabitacionesHotel = pm.newQuery(SQL, "DELETE FROM HABITACIONESHOTEL"); 
		Query qHorarioServicio = pm.newQuery(SQL, "DELETE FROM HORARIOSERVICIO"); 
		Query qHotel = pm.newQuery(SQL, "DELETE FROM HOTEL"); 
		Query qPersona = pm.newQuery(SQL, "DELETE FROM PERSONA"); 
		Query qPersonasHotel = pm.newQuery(SQL, "DELETE FROM PERSONASHOTEL"); 
		Query qPlanDeConsumo = pm.newQuery(SQL, "DELETE FROM PLANDECONSUMO"); 
		Query qPlanesHotel = pm.newQuery(SQL, "DELETE FROM PLANESHOTEL"); 
		Query qProducto = pm.newQuery(SQL, "DELETE FROM PRODUCTO"); 
		Query qProductosFactura = pm.newQuery(SQL, "DELETE FROM PRODUCTOSFACTURA"); 
		Query qReserva = pm.newQuery(SQL, "DELETE FROM RESERVA"); 
		Query qReservaServicio = pm.newQuery(SQL, "DELETE FROM RESERVASERVICIO"); 
		Query qRol = pm.newQuery(SQL, "DELETE FROM ROL"); 
		Query qServicio = pm.newQuery(SQL, "DELETE FROM SERVICIO"); 
		Query qServiciosHotel = pm.newQuery(SQL, "DELETE FROM SERVICIOSHOTEL"); 
		Query qServiciosPlanConsumo = pm.newQuery(SQL, "DELETE FROM SERVICIOSPLANCONSUMO"); 
		Query qServiciosTomados = pm.newQuery(SQL, "DELETE FROM SERVICIOSTOMADOS"); 
		Query qTipoConsumo = pm.newQuery(SQL, "DELETE FROM TIPOCONSUMO"); 
		Query qTipoDocumento = pm.newQuery(SQL, "DELETE FROM TIPODOCUMENTO"); 
		Query qTipoHabitacion = pm.newQuery(SQL, "DELETE FROM TIPOHABITACION"); 
		Query qTipocServicio = pm.newQuery(SQL, "DELETE FROM TIPOSERVICIO"); 
		Query qUtencilio = pm.newQuery(SQL, "DELETE FROM UTENCILIO"); 
		Query qUtenciliosPrestados = pm.newQuery(SQL, "DELETE FROM UTENCILIOSPRESTADOS"); 
	
		
		long e1 = (long) qConsumoReserva.executeUnique ();
		long e2 = (long) qCuentaConsumo.executeUnique ();
		long e3 = (long) qDotacion.executeUnique ();
		long e4 = (long) qDotacionHabitacion.executeUnique ();
		long e5 = (long) qFactura.executeUnique ();
		long e6 = (long) qFacturasCuentaConsumo.executeUnique ();
		long e7 = (long) qHabitacion.executeUnique ();
		long e8 = (long) qHabitacionesHotel.executeUnique ();
		long e9 = (long) qHorarioServicio.executeUnique ();
		long e10 = (long) qHotel.executeUnique ();
		long e11 = (long) qPersona.executeUnique ();
		long e12 = (long) qPersonasHotel.executeUnique ();
		long e13 = (long) qPlanDeConsumo.executeUnique ();
		long e14 = (long) qPlanesHotel.executeUnique ();
		long e15 = (long) qProductosFactura.executeUnique ();
		long e16 = (long) qReserva.executeUnique ();
		long e17 = (long) qReservaServicio.executeUnique ();
		long e18 = (long) qRol.executeUnique ();
		long e19 = (long) qServicio.executeUnique ();
		long e20 = (long) qServiciosHotel.executeUnique ();
		long e21 = (long) qServiciosPlanConsumo.executeUnique ();
		long e22 = (long) qServiciosTomados.executeUnique ();
		long e23 = (long) qTipoConsumo.executeUnique ();
		long e24 = (long) qTipoDocumento.executeUnique ();
		long e25 = (long) qTipoHabitacion.executeUnique ();
		long e26 = (long) qTipocServicio.executeUnique ();
		long e27 = (long) qUtencilio.executeUnique ();
		long e28 = (long) qUtenciliosPrestados.executeUnique ();

		return new long[] {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20
				,e21,e22,e23,e24,e25,e26,e27,e28};
	}
}
