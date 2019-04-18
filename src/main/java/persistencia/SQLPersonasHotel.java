package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.PersonasHotel;

public class SQLPersonasHotel
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
	public SQLPersonasHotel(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarPersonasHotel(PersistenceManager pm, Long idHotel, Long idTipoDocumentoPersona, Long documentoPersona) {
		Query q = pm.newQuery(SQL, "INSERT INTO PersonasHotel WHERE idHotel = ? AND idTipoDocumentoPersona = ? AND documentoPersona = ?");
		q.setParameters(idHotel, idTipoDocumentoPersona, documentoPersona);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarPersonasHotel(PersistenceManager pm, Long idHotel, Long idTipoDocumentoPersona) {
		Query q = pm.newQuery(SQL, "DELETE FROM PersonasHotel WHERE idHotel = ? AND idTipoDocumentoPersona = ?");
		q.setParameters(idHotel, idTipoDocumentoPersona);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<PersonasHotel> darTodosPersonasHotel(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM PersonasHotel");
		q.setResultClass(PersonasHotel.class);
		List<PersonasHotel> rta = (List<PersonasHotel>) q.execute();
		return rta;
	}

}
