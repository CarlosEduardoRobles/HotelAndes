package negocio;

public interface VOConsumoReserva 
{
	/**
	 * Retorna el id de la reserva
	 * @return el id de la reserva
	 */
	public long getIdReserva();

	/**
	 * Retorna el id del plan de consumo
	 * @return el id del plan de consumo
	 */
	public long getIdPlanConsumo();
	
	/**
	 * Metodo toString
	 * @return metodo toString
	 */
	public String toString();
}
