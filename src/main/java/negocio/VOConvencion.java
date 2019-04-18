package negocio;

public interface VOConvencion 
{
	/**
	 * Retorna el id de la convencion
	 * @return el id de la convencion
	 */
	public long getId();
	
	/**
	 * Retorna la cantidad de participantes esperados en la convencion
	 * @return la cantidad de participantes esperados en la convencion
	 */
	public Integer getCantParticipantes();
	
	public String getNombre();
	
	/**
	 * Metodo toString
	 * @return metodo toString
	 */
	public String toString();
}
