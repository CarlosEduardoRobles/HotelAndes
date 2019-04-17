package persistencia;

public class SQLServiciosRequeridos 
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
	public SQLServiciosRequeridos(PersistenciaHotelAndes pha) {this.pha = pha;}
	
	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------

}
