package negocio;

public class TipoServicio implements VOTipoServicio
{
	private long id;
	
	private String tipoServicio;
	
	public TipoServicio() 
	{
		this.id = 0;
		this.tipoServicio = "";
	}

	public TipoServicio(long id, String tipoServicio) 
	{
		this.id = id;
		this.tipoServicio = tipoServicio;
	}

	public long getId() {return id;}

	public String getTipoServicio() {return tipoServicio;}

	public void setId(long id) {this.id = id;}

	public void setTipoServicio(String tipoServicio) {this.tipoServicio = tipoServicio;}

	@Override
	public String toString() {
		return "TipoServicio [id=" + id + ", tipoServicio=" + tipoServicio + "]";
	}
	
	
}
