package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ServiciosPlanConsumo;

public class SQLServiciosPlanConsumo 
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
	public SQLServiciosPlanConsumo(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarServiciosPlanConsumo(PersistenceManager pm, long idReserva, long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "INSERT INTO ServiciosPlanConsumo WHERE idReserva = ? AND idPlanConsumo = ?");
		q.setParameters(idReserva, idPlanConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarServiciosPlanConsumo(PersistenceManager pm, long idReserva, long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "DELETE FROM ServiciosPlanConsumo WHERE idReserva = ? AND idPlanConsumo = ?");
		q.setParameters(idReserva, idPlanConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<ServiciosPlanConsumo> darServiciosPlanConsumo(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM ServiciosPlanConsumo");
		q.setResultClass(ServiciosPlanConsumo.class);
		List<ServiciosPlanConsumo> rta = (List<ServiciosPlanConsumo>) q.execute();
		return rta;
	}
	

}
