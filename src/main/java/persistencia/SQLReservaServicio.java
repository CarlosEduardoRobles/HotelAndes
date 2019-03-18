package persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLReservaServicio 
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
	public SQLReservaServicio(PersistenciaHotelAndes pha) {this.pha = pha;}

	// ---------------------------------------------------------------
	// ---------------------------Metodos-----------------------------
	// ---------------------------------------------------------------
	//long idReserva, long idServicio, Date comienzoReserva, Date finalReserva, Integer cantidadAsistentes
	public long adicionarReservaServicio (PersistenceManager pm, long idReserva, long idServicio, Date comienzoReserva, 
			Date finalReserva, Integer cantidadAsistentes, Double costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO ReservaServicio (idReserva, idServicio, comienzoReserva, finalReserva) values (?, ?, ?, ?,?)");
        q.setParameters(idReserva, idServicio, comienzoReserva, finalReserva, cantidadAsistentes);
        
        long diff = finalReserva.getTime() - comienzoReserva.getTime();
        //Tiempo de uso
        long tiempoUso = diff / (60 * 1000); 
       
        Double costoFinal = costo*tiempoUso;
        
        //long idReserva, long idServicio, Double costo, Integer tiempoUso
        Query q2 = pm.newQuery(SQL, "INSERT INTO ServiciosTomados (idReserva, idServicio, costo, tiempoUso) values (?, ?, ?,?)");
        q2.setParameters(idReserva, idServicio, costoFinal, tiempoUso);
        
        //Tambien se agrega a los ServiciosTomados
        q2.executeUnique();
        
        return (long) q.executeUnique();
	}
}
