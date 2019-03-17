package negocio;

public class TipoDocumento implements VOTipoDocumento
{
	private long id;
	
	private String tipoDocumento;
	
	public TipoDocumento()
	{
		this.id = 0;
		this.tipoDocumento = "";
	}

	public TipoDocumento(long id, String tipoDocumento) 
	{
		this.id = id;
		this.tipoDocumento = tipoDocumento;
	}

	public long getId() {return id;}

	public String getTipoDocumento() {return tipoDocumento;}

	public void setId(long id) {this.id = id;}

	public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}
	
	@Override
	public String toString() {
		return "TipoDocumento [id=" + id + ", tipoDocumento=" + tipoDocumento + "]";
	}
}

	
