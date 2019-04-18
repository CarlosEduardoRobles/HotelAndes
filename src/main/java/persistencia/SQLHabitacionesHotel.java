package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.HabitacionesHotel;

public class SQLHabitacionesHotel 
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
	public SQLHabitacionesHotel(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarHabitacionesHotel(PersistenceManager pm, Long idHotel, Long numeroHabitacion) {
		Query q = pm.newQuery(SQL, "INSERT INTO HabitacionesHotel WHERE idHotel = ? AND numeroHabitacion = ?");
		q.setParameters(idHotel, numeroHabitacion);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarHabitacionesHotel(PersistenceManager pm, Long idHotel, Long numeroHabitacion) {
		Query q = pm.newQuery(SQL, "DELETE FROM HabitacionesHotel WHERE idHotel = ? AND numeroHabitacion = ?");
		q.setParameters(idHotel, numeroHabitacion);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<HabitacionesHotel> darHabitacionesHotel(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM HabitacionesHotel");
		q.setResultClass(HabitacionesHotel.class);
		List<HabitacionesHotel> rta = (List<HabitacionesHotel>) q.execute();
		return rta;
	}


}
