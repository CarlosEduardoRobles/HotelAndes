package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLConvencion 
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
	public SQLConvencion(PersistenciaHotelAndes pha) {this.pha = pha;}
	
	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	public long crearConvencion (PersistenceManager pm, long id, Integer cantParticipantes, String nombre, String nit) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO Convencion (id, cantParticipantes, nombre, nit) values (?, ?, ?, ?)");
	    q.setParameters(id, cantParticipantes, nombre, nit);
        return (long) q.executeUnique();
	}
	
	public void eliminarConvencionPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM Convencion WHERE id = ?");
	    q.setParameters(id);
	    q.executeUnique();
	}
	
	public void eliminarConvencionPorNombre (PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM Convencion WHERE nombre = ?");
	    q.setParameters(nombre);
	    q.executeUnique();
	}
	
	public void eliminarConvencionPorNit (PersistenceManager pm, String nit)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM Convencion WHERE nit = ?");
	    q.setParameters(nit);
	    q.executeUnique();
	}
}
