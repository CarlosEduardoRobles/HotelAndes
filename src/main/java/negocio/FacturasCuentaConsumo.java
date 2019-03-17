package negocio;

public class FacturasCuentaConsumo implements VOFacturasCuentaConsumo 
{
	private long idFactura;
	
	private long idCuentaConsumo;
	
	public FacturasCuentaConsumo() 
	{
		this.idFactura = 0;
		this.idCuentaConsumo = 0;
	}


	public FacturasCuentaConsumo(long idFactura, long idCuentaConsumo) 
	{
		this.idFactura = idFactura;
		this.idCuentaConsumo = idCuentaConsumo;
	}

	public long getIdFactura() {return idFactura;}

	public long getIdCuentaConsumo() {return idCuentaConsumo;}

	public void setIdFactura(long idFactura) {this.idFactura = idFactura;}

	public void setIdCuentaConsumo(long idCuentaConsumo) {this.idCuentaConsumo = idCuentaConsumo;}

	@Override
	public String toString() {
		return "FacturasCuentaConsumo [idFactura=" + idFactura + ", idCuentaConsumo=" + idCuentaConsumo + "]";
	}
	
	
}
