package negocio;

public class TipoHabitacion implements VOTipoHabitacion
{
	private long id;
	
	private String tipoHabitacion;
	
	public TipoHabitacion()
	{
		this.id = 0;
		this.tipoHabitacion = "";
	}

	public TipoHabitacion(long id, String tipoHabitacion) 
	{
		this.id = id;
		this.tipoHabitacion = tipoHabitacion;
	}

	public long getId() {return id;}

	public String getTipoHabitacion() {return tipoHabitacion;}

	public void setId(long id) {this.id = id;}

	public void setTipoHabitacion(String tipoHabitacion) {this.tipoHabitacion = tipoHabitacion;}

	@Override
	public String toString() {
		return "TipoHabitacion [id=" + id + ", tipoHabitacion=" + tipoHabitacion + "]";
	}	
}
