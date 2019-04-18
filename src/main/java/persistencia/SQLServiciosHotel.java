package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import negocio.ServiciosHotel;

public class SQLServiciosHotel
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
	public SQLServiciosHotel(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------

	public List<ServiciosHotel> darServiciosHotel (PersistenceManager pm, long idHotel)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM ServiciosHotel WHERE idHotel = ?");
		q.setResultClass(ServiciosHotel.class);
		q.setParameters(idHotel);
		return (List<ServiciosHotel>) q.executeList();
	}

	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long adicionarServiciosHotel(PersistenceManager pm, Long idHotel, Long idServicio) {
		Query q = pm.newQuery(SQL, "INSERT INTO ServiciosHotel WHERE idHotel = ? AND idServicio = ?");
		q.setParameters(idHotel, idServicio);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarServiciosHotel(PersistenceManager pm, Long idHotel, Long idServicio) {
		Query q = pm.newQuery(SQL, "DELETE FROM ServiciosHotel WHERE idHotel = ? AND idServicio = ?");
		q.setParameters(idHotel, idServicio);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<ServiciosHotel> darHabitacionesHotel(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM ServiciosHotel");
		q.setResultClass(ServiciosHotel.class);
		List<ServiciosHotel> rta = (List<ServiciosHotel>) q.execute();
		return rta;
	}

}
