package negocio;

public class DotacionHabitacion implements VODotacionHabitacion
{
	private String numeroHabitacion;
	
	private long idDotacion;
	
	private Integer cantidad;
	
	public DotacionHabitacion() 
	{
		this.numeroHabitacion = "";
		this.idDotacion = 0;
		this.cantidad = 0;
	}

	public DotacionHabitacion(String numeroHabitacion, long idDotacion, Integer cantidad) 
	{
		this.numeroHabitacion = numeroHabitacion;
		this.idDotacion = idDotacion;
		this.cantidad = cantidad;
	}

	public String getNumeroHabitacion() {return numeroHabitacion;}

	public long getIdDotacion() {return idDotacion;}

	public Integer getCantidad() {return cantidad;}

	public void setNumeroHabitacion(String numeroHabitacion) {this.numeroHabitacion = numeroHabitacion;}

	public void setIdDotacion(long idDotacion) {this.idDotacion = idDotacion;}

	public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}

	@Override
	public String toString() {
		return "DotacionHabitacion [numeroHabitacion=" + numeroHabitacion + ", idDotacion=" + idDotacion + "]";
	}
	
	
}
