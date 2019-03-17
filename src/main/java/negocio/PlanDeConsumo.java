package negocio;

public class PlanDeConsumo implements VOPlanDeConsumo
{
	private long id, idTipoConsumo;
	
	private Integer tiempoEstadia;
	
	private Double descuento;
	
	public PlanDeConsumo() {
		this.id = 0;
		this.idTipoConsumo = 0;
		this.tiempoEstadia = 0;
		this.descuento = 0.0;
	}

	public PlanDeConsumo(long id, long idTipoConsumo, Integer tiempoEstadia, Double descuento) 
	{
		this.id = id;
		this.idTipoConsumo = idTipoConsumo;
		this.tiempoEstadia = tiempoEstadia;
		this.descuento = descuento;
	}

	public long getId() {return id;}

	public long getIdTipoConsumo() {return idTipoConsumo;}

	public Integer getTiempoEstadia() {return tiempoEstadia;}

	public Double getDescuento() {return descuento;}

	public void setId(long id) {this.id = id;}

	public void setIdTipoConsumo(long idTipoConsumo) {this.idTipoConsumo = idTipoConsumo;}

	public void setTiempoEstadia(Integer tiempoEstadia) {this.tiempoEstadia = tiempoEstadia;}

	public void setDescuento(Double descuento) {this.descuento = descuento;}

	@Override
	public String toString() {
		return "PlanConsumo [id=" + id + ", idTipoConsumo=" + idTipoConsumo + ", tiempoEstadia=" + tiempoEstadia
				+ ", descuento=" + descuento + "]";
	}
	
	
}
