package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.DotacionHabitacion;

public class SQLDotacionHabitacion 
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
	public SQLDotacionHabitacion(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long adicionarDotacionHabitacion(PersistenceManager pm, String numeroHabitacion, Long idDotacion, Integer cantidad) {
		Query q = pm.newQuery(SQL, "INSERT INTO DotacionHabitacion WHERE numeroHabitacion = ? AND idDotacion = ? AND cantidad = ?");
		q.setParameters(numeroHabitacion, idDotacion, cantidad);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarDotacionHabitacion(PersistenceManager pm, long numeroHabitacion, long idDotacion) {
		Query q = pm.newQuery(SQL, "DELETE FROM DotacionHabitacion WHERE numeroHabitacion = ? AND idDotacion = ?");
		q.setParameters(numeroHabitacion, idDotacion);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<DotacionHabitacion> darTodosDotacionHabitacion(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM DotacionHabitacion");
		q.setResultClass(DotacionHabitacion.class);
		List<DotacionHabitacion> rta = (List<DotacionHabitacion>) q.execute();
		return rta;
	}

}
