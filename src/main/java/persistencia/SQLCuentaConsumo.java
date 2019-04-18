package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.CuentaConsumo;

public class SQLCuentaConsumo 
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
	public SQLCuentaConsumo(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarCuentaConsumo(PersistenceManager pm, long idReserva, long id) {
		Query q = pm.newQuery(SQL, "INSERT INTO CuentaConsumo WHERE idReserva = ? AND id = ?");
		q.setParameters(idReserva, id);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarCuentaConsumo(PersistenceManager pm, long idReserva, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM CuentaConsumo WHERE idReserva = ? AND id = ?");
		q.setParameters(idReserva, id);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<CuentaConsumo> darTodosConsumoReserva(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM CuentaConsumo");
		q.setResultClass(CuentaConsumo.class);
		List<CuentaConsumo> rta = (List<CuentaConsumo>) q.execute();
		return rta;
	}
}
