package negocio;

public class CuentaConsumo implements VOCuentaConsumo 
{
	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * Identificador de la cuenta de consumo
	 */
	private long id;
	
	/**
	 * Identificador de la reserva a la que pertenece
	 */
	private long idReserva;	
	
	/**
	 * Costo actual/final de la cuenta
	 */
	private Double costo;
	
	public CuentaConsumo() {
		
		this.id = 0;
		this.idReserva = 0;
		this.costo = 0.0;
	}
	
	public CuentaConsumo(long id, long idReserva, Double costo)
	{
		this.id = id;
		this.idReserva = idReserva;
		this.costo = costo;
	}

	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	public long getId() {return id;}

	public long getIdReserva() {return idReserva;}

	public Double getCosto() {return costo;}

	/**
	 * Asigna el identificador a la cuenta de consumo
	 * @param id - id a asignar
	 */
	public void setId(long id) {this.id = id;}

	/**
	 * Asigna el identificador de la reserva a la que perntenece la cuenta 
	 * de consumo
	 * @param idReserva - id de la reserva a asignar
	 */
	public void setIdReserva(long idReserva) {this.idReserva = idReserva;}

	/**
	 * Asigna el costo a la cuenta.
	 * @param costo - costo de la cuenta
	 */
	public void setCosto(Double costo) {this.costo = costo;}

	@Override
	public String toString() {
		return "CuentaConsumo [id=" + id + ", idReserva=" + idReserva + ", costo=" + costo + "]";
	}
	
	
	
}
