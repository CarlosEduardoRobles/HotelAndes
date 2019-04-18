package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import negocio.Dotacion;
import java.util.List;

public class SQLDotacion 
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
	public SQLDotacion(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	
	/**
	 * 
	 * @param pm
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @return
	 */
	public long agregar(PersistenceManager pm, String nombre, String descripcion, Double precio) {
		Query q = pm.newQuery(SQL, "INSERT INTO Dotacion (nombre, descripcion, precio) values (?, ?, ?)");
		q.setParameters(nombre, descripcion, precio);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idDotacion
	 * @return
	 */
	public long eliminar(PersistenceManager pm, Long idDotacion) {
		Query q = pm.newQuery(SQL, "DELETE FROM Dotacion WHERE id = ?");
		q.setParameters(idDotacion);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<Dotacion> darTodos(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM Dotacion");
		q.setResultClass(Dotacion.class);
		return (List<Dotacion>) q.executeList();
	}
	
	/**
	 * 
	 * @param pm
	 * @param nombre
	 * @return
	 */
	public List<Dotacion> darPorNombre(PersistenceManager pm, String nombre){
		Query q = pm.newQuery(SQL, "SELECT * FROM Dotacion WHERE nombre = ?");
		q.setParameters(nombre);
		q.setResultClass(Dotacion.class);
		return (List<Dotacion>) q.executeList();
	}
	
	/**
	 * 
	 * @param pm
	 * @param id
	 * @return
	 */
	public Dotacion darPorId(PersistenceManager pm, Long id){
		Query q = pm.newQuery(SQL, "SELECT * FROM Dotacion WHERE id = ?");
		q.setParameters(id);
		q.setResultClass(Dotacion.class);
		return (Dotacion) q.executeUnique();
	}
}
