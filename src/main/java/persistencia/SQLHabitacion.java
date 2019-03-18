package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Habitacion;
public class SQLHabitacion 
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
	public SQLHabitacion(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	public long adicionarHabitacion (PersistenceManager pm, String numeroHabitacion, String descripcion, long idTipoHabitacion, Integer capacidad,
			Double precio) 
	{
		//Por conveniencia se asume que cuando se crea una habitacion, esta disponbile
		char si = 'N';
        Query q = pm.newQuery(SQL, "INSERT INTO Habitacion (numeroHabitacion, descripcion, idTipoHabitacion, capacidad, precio, disponible)"
        		+ " values (?, ?, ?, ?, ?, ?)");
        q.setParameters(numeroHabitacion, descripcion, idTipoHabitacion, capacidad, precio, si);
        return (long) q.executeUnique();
	}
	
	public Habitacion darHabitacionPorNumero (PersistenceManager pm, String numeroHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Habitacion WHERE numeroHabitacion = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(numeroHabitacion);
		return (Habitacion) q.executeUnique();
	}
}
