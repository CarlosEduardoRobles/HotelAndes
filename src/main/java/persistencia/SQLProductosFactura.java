package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ProductosFactura;

public class SQLProductosFactura 
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
	public SQLProductosFactura(PersistenciaHotelAndes pha) {this.pha = pha;}

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
	public long adicionarProductosFactura(PersistenceManager pm, Long idFactura, Long idProducto) {
		Query q = pm.newQuery(SQL, "INSERT INTO ProductosFactura WHERE idFactura = ? AND idProducto = ?");
		q.setParameters(idFactura, idProducto);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @param idReserva
	 * @param idPlanConsumo
	 * @return
	 */
	public long eliminarProductosFactura(PersistenceManager pm, Long idHotel, Long idPlanConsumo) {
		Query q = pm.newQuery(SQL, "DELETE FROM ProductosFactura WHERE idHotel = ? AND idPlanConsumo = ?");
		q.setParameters(idHotel, idPlanConsumo);
		return (long) q.executeUnique();
	}
	
	/**
	 * 
	 * @param pm
	 * @return
	 */
	public List<ProductosFactura> darTodosProductosFactura(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM ProductosFactura");
		q.setResultClass(ProductosFactura.class);
		List<ProductosFactura> rta = (List<ProductosFactura>) q.execute();
		return rta;
	}

}
