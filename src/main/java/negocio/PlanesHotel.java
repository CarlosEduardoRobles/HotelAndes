package negocio;

public class PlanesHotel implements VOPlanesHotel
{
	private long idHotel, idPlanConsumo;
	
	public PlanesHotel() 
	{
		this.idHotel = 0;
		this.idPlanConsumo = 0;
	}

	public PlanesHotel(long idHotel, long idPlanConsumo) 
	{
		this.idHotel = idHotel;
		this.idPlanConsumo = idPlanConsumo;
	}

	public long getIdHotel() {return idHotel;}

	public long getIdPlanConsumo() {return idPlanConsumo;}

	public void setIdHotel(long idHotel) {this.idHotel = idHotel;}

	public void setIdPlanConsumo(long idPlanConsumo) {this.idPlanConsumo = idPlanConsumo;}

	@Override
	public String toString() {
		return "PlanesHotel [idHotel=" + idHotel + ", idPlanConsumo=" + idPlanConsumo + "]";
	}
	
	
}
