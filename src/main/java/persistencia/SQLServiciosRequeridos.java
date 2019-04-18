package persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServiciosRequeridos 
{
	//---------------------------------------------------------------
	//-------------------------Constantes----------------------------
	//---------------------------------------------------------------
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra aca para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pha;
	
	//---------------------------------------------------------------
	//------------------------Constructores--------------------------
	//---------------------------------------------------------------
	/**
	 * Constructor
	 * @param pha - Manejador de persistencia de la aplicacion
	 */
	public SQLServiciosRequeridos(PersistenciaHotelAndes pha) {this.pha = pha;}
	
	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	public long agregarServiciosRequeridos (PersistenceManager pm, long idConvencion, long idServicio, Integer cantParticipantes, Date comienzoReserva,
			Date finalReserva) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO ServiciosRequeridos (idConvencion, idServicio, cantParticipantes, comienzoReserva, finalReserva) "
				+ "values (?, ?, ?, ?, ?)");
	    q.setParameters(idConvencion, idServicio, cantParticipantes, comienzoReserva, finalReserva);
        return (long) q.executeUnique();
	}
}
