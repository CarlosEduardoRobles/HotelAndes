package negocio;

public interface VOCuentaConsumo 
{
	/**
	 * Retorna el identificador de la cuenta de consumo
	 * @return el identificador de la cuenta de consumo
	 */
	public long getId();

	/**
	 * Retorna el identificador de la reserva a la que pertenece
	 * @return el identificador de la reserva a la que pertenece
	 */
	public long getIdReserva();

	/**
	 * Retorna el costo actual/final de la cuenta
	 * @return el costo actual/final de la cuenta
	 */
	public Double getCosto();
	
	/**
	 * Metodo toString
	 * @return toString
	 */
	public String toString();
}
