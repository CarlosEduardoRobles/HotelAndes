package persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLReserva 
{
	// ---------------------------------------------------------------
	// -------------------------Constantes----------------------------
	// ---------------------------------------------------------------
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las
	 * sentencias de acceso a la base de datos Se renombra aca para facilitar la
	 * escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	// ---------------------------------------------------------------
	// --------------------------Atributos----------------------------
	// ---------------------------------------------------------------
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pha;

	// ---------------------------------------------------------------
	// ------------------------Constructores--------------------------
	// ---------------------------------------------------------------
	/**
	 * Constructor
	 * @param pha - Manejador de persistencia de la aplicacion
	 */
	public SQLReserva(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	
	public long adicionarReserva (PersistenceManager pm, long id, long idTipoDocumentoPersona, long documentoPersona, String numeroHabitacion,
			Double costo, Integer numeroPersonas, Date fechaEntrada, Date fechaSalida) 
	{
		char no = 'N';
        Query q = pm.newQuery(SQL, "INSERT INTO Reserva (id, idTipoDocumentoPersona, documentoPersona, numeroHabitacion, costo"
        		+ ", numeroPersonas, checkIn, checkOut, fechaEntrada, fechaSalida) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, idTipoDocumentoPersona, documentoPersona, numeroHabitacion, costo, numeroPersonas, no, no, fechaEntrada, fechaSalida);
        return (long) q.executeUnique();
	}
	
	public long checkIn (PersistenceManager pm, long idReserva) 
	{
        Query q = pm.newQuery(SQL, "UPDATE Reserva SET checkIn='Y' WHERE id = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();
	}
	
	public long checkOut (PersistenceManager pm, long idReserva) 
	{
        Query q = pm.newQuery(SQL, "UPDATE Reserva SET checkOut='Y' WHERE id = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();
	}


}
