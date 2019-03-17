package negocio;

public class ConsumoReserva implements VOConsumoReserva
{
	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * Identificador de la reserva
	 */
	private long idReserva;
	
	/**
	 * Identificador del plan de consumo
	 */
	private long idPlanConsumo;	
	
	public ConsumoReserva() 
	{
		this.idReserva = 0;
		this.idPlanConsumo = 0;
	}
	
	public ConsumoReserva(long idReserva, long idPlanConsumo) 
	{
		this.idReserva = idReserva;
		this.idPlanConsumo = idPlanConsumo;
	}

	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	public long getIdReserva() {return idReserva;}

	public long getIdPlanConsumo() {return idPlanConsumo;}

	/**
	 * Asigna el id de reserva al que pertenece el plan de consumo
	 * @param idReserva - Id de la reserva
	 */
	public void setIdReserva(long idReserva) {this.idReserva = idReserva;}

	/**
	 * Asigna el id del plan de consumo que tiene la reserva
	 * @param idPlanConsumo - Id del plan de consumo
	 */
	public void setIdPlanConsumo(long idPlanConsumo) {this.idPlanConsumo = idPlanConsumo;}

	@Override
	public String toString() {return "ConsumoReserva [idReserva=" + idReserva + ", idPlanConsumo=" + idPlanConsumo + "]";}
	
	
	
	
}
