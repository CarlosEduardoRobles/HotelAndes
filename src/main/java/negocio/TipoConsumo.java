package negocio;

public class TipoConsumo implements VOTipoConsumo
{
	private long id;
	
	private String tipoConsumo;
	
	public TipoConsumo() 
	{
		this.id = 0;
		this.tipoConsumo = "";
	}

	public TipoConsumo(long id, String tipoConsumo) 
	{
		this.id = id;
		this.tipoConsumo = tipoConsumo;
	}

	public long getId() {return id;}

	public String getTipoConsumo() {return tipoConsumo;}

	public void setId(long id) {this.id = id;}

	public void setTipoConsumo(String tipoConsumo) {this.tipoConsumo = tipoConsumo;}

	@Override
	public String toString() {
		return "TipoConsumo [id=" + id + ", tipoConsumo=" + tipoConsumo + "]";
	}
	

}
