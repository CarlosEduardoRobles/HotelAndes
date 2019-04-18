package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.PlanesHotel;

public class SQLPlanesHotel 
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
	public SQLPlanesHotel(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarPlanesHotel(PersistenceManager pm, Long idHotel, Long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "INSERT INTO PlanesHotel WHERE idHotel = ? AND idPlanConsumo = ?");
		q.setParameters(idHotel, idPlanConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarPersonasHotel(PersistenceManager pm, Long idHotel, Long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "DELETE FROM PersonasHotel WHERE idHotel = ? AND idPlanConsumo = ?");
		q.setParameters(idHotel, idPlanConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<PlanesHotel> darTodosPersonasHotel(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM PlanesHotel");
		q.setResultClass(PlanesHotel.class);
		List<PlanesHotel> rta = (List<PlanesHotel>) q.execute();
		return rta;
	}


}
