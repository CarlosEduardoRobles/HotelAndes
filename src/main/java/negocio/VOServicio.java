package negocio;

public interface VOServicio 
{
	public long getId();

	public long getIdTipoServicio();

	public String getNombre();

	public String getDescripcion();

	public Integer getCostoUso();
	
	public Integer getCapacidad();
	
	public String toString();
}
