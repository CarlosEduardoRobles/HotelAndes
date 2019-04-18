package negocio;

public class PlanConvencion implements VOPlanConvencion
{
	private long idConvencion, idPlanConsumo;

	public long getIdConvencion() {return idConvencion;}

	public void setIdConvencion(long idConvencion) {this.idConvencion = idConvencion;}

	public long getIdPlanConsumo() {return idPlanConsumo;}

	public void setIdPlanConsumo(long idPlanConsumo) {this.idPlanConsumo = idPlanConsumo;}

	@Override
	public String toString() 
	{
		return "PlanConvencion [idConvencion=" + idConvencion + ", idPlanConsumo=" + idPlanConsumo + "]";
	}	
}
