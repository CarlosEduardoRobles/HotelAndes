package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Servicio;

public class SQLServicio 
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
	public SQLServicio(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	//long id, long idTipoServicio, String nombre, String descripcion, Integer costoUso, Integer capacidad
	public Servicio darServicioPorId (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Servicio WHERE id = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(idServicio);
		return (Servicio) q.executeUnique();
	}
	
	public long comenzarMantenimiento (PersistenceManager pm, long idServicio) 
	{
        Query q = pm.newQuery(SQL, "UPDATE Habitacion SET mantenimiento = 'N' WHERE id = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();
	}
	
	public long terminarMantenimiento (PersistenceManager pm, long idServicio) 
	{
        Query q = pm.newQuery(SQL, "UPDATE Habitacion SET mantenimiento = 'Y' WHERE id = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();
	}
	
	public List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM Servicio");
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
}
