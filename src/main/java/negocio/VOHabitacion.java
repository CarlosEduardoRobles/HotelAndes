package negocio;

public interface VOHabitacion 
{
	public String getNumeroHabitacion();

	public String getDescripcion();

	public long getIdTipoHabitacion();

	public Integer getCapacidad();

	public Double getPrecio();
	
	public Boolean getDisponible();
	
	public String toString();
}
