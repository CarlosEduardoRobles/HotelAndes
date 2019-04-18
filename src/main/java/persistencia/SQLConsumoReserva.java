package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;
import negocio.ConsumoReserva;

public class SQLConsumoReserva 
{
	//---------------------------------------------------------------
	//-------------------------Constantes----------------------------
	//---------------------------------------------------------------
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra aca para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pha;
	
	//---------------------------------------------------------------
	//------------------------Constructores--------------------------
	//---------------------------------------------------------------
	/**
	 * Constructor
	 * @param pha - Manejador de persistencia de la aplicacion
	 */
	public SQLConsumoReserva(PersistenciaHotelAndes pha) {this.pha = pha;}
	
	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long adicionarConsumoReserva(PersistenceManager pm, long idReserva, long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "INSERT INTO ConsumoReserva WHERE idReserva = ? AND idPlanConsumo = ?");
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
	public long eliminarConsumoReserva(PersistenceManager pm, long idReserva, long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "DELETE FROM ConsumoReserva WHERE idReserva = ? AND idPlanConsumo = ?");
		q.setParameters(idReserva, idPlanConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<ConsumoReserva> darTodosConsumoReserva(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM ConsumoReserva");
		q.setResultClass(ConsumoReserva.class);
		List<ConsumoReserva> rta = (List<ConsumoReserva>) q.execute();
		return rta;
	}
	
}
