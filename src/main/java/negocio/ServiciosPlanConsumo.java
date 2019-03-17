package negocio;

public class ServiciosPlanConsumo implements VOServiciosPlanConsumo
{
	private long idServicio, idPlanConsumo;
	
	public ServiciosPlanConsumo()
	{
		this.idServicio = 0;
		this.idPlanConsumo = 0;
	}

	public ServiciosPlanConsumo(long idServicio, long idPlanConsumo) 
	{
		this.idServicio = idServicio;
		this.idPlanConsumo = idPlanConsumo;
	}

	public long getIdServicio() {return idServicio;}

	public long getIdPlanConsumo() {return idPlanConsumo;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public void setIdPlanConsumo(long idPlanConsumo) {this.idPlanConsumo = idPlanConsumo;}

	@Override
	public String toString() {
		return "ServiciosPlanConsumo [idServicio=" + idServicio + ", idPlanConsumo=" + idPlanConsumo + "]";
	}
	
	
}
