package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.FacturasCuentaConsumo;

public class SQLFacturasCuentaConsumo 
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
	public SQLFacturasCuentaConsumo(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarFacturaCuentaConsumo(PersistenceManager pm, Long idFactura, Long idCuentaConsumo) {
		Query q = pm.newQuery(SQL, "INSERT INTO FacturasCuentaConsumo WHERE idFactura = ? AND idCuentaConsumo = ?");
		q.setParameters(idFactura, idCuentaConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarFacturaCuentaConsumo(PersistenceManager pm, Long idFactura, Long idCuentaConsumo) {
		Query q = pm.newQuery(SQL, "DELETE FROM FacturasCuentaConsumo WHERE idFactura = ? AND idCuentaConsumo = ?");
		q.setParameters(idFactura, idCuentaConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<FacturasCuentaConsumo> darTodosFacturaCuentaConsumo(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM FacturasCuentaConsumo");
		q.setResultClass(FacturasCuentaConsumo.class);
		List<FacturasCuentaConsumo> rta = (List<FacturasCuentaConsumo>) q.execute();
		return rta;
	}

}
