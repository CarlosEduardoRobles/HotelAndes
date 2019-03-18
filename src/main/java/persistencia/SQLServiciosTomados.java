package persistencia;

import java.util.Date;

import java.util.List;
import negocio.ServiciosTomados;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServiciosTomados
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
	public SQLServiciosTomados(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	public long adicionarServiciosTomados (PersistenceManager pm, long idReserva, long idServicio, Double costo, Integer tiempoUso) 
	{    
        //long idReserva, long idServicio, Double costo, Integer tiempoUso
        Query q = pm.newQuery(SQL, "INSERT INTO ServiciosTomados (idReserva, idServicio, costo, tiempoUso) values (?, ?, ?, ?)");
        q.setParameters(idReserva, idServicio, costo, tiempoUso);       
        
        return (long) q.executeUnique();
	}
	
	public ServiciosTomados obtenerServiciosTomados(PersistenceManager pm, long idReserva) {
		Query q = pm.newQuery(SQL, "SELECT * FROM ServiciosTomados WHERE id = ?");
		q.setResultClass(ServiciosTomados.class);
		q.setParameters(idReserva);
		return (ServiciosTomados) q.executeUnique();
	}
}
