package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLPersona 
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
	public SQLPersona(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	public long registrarPersona (PersistenceManager pm, long idTipoDocumento, long idRol, String documento, String nombre, String correo) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO Persona (idTipoDocumento, idRol, documento, nombre, correo) "
				+ "values (?, ?, ?, ?, ?)");
	    q.setParameters(idTipoDocumento, idRol, documento, nombre, correo);
        return (long) q.executeUnique();
	}
}
