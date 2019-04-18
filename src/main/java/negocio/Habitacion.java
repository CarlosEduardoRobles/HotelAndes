package negocio;

public class Habitacion implements VOHabitacion
{
	private String numeroHabitacion;
	
	private String descripcion;
	
	private long idTipoHabitacion;
	
	private Integer capacidad;
	
	private Double precio;
	
	private Boolean disponible, mantenimiento;
	
	public Habitacion() 
	{
		this.numeroHabitacion = "";
		this.descripcion = "";
		this.idTipoHabitacion = 0;
		this.capacidad = 0;
		this.precio = 0.0;
		this.disponible = false;
		this.mantenimiento = false;
	}
	
	public Habitacion(String numeroHabitacion, String descripcion, long idTipoHabitacion, Integer capacidad,
			Double precio, Boolean disponible, Boolean mantenimiento) 
	{
		super();
		this.numeroHabitacion = numeroHabitacion;
		this.descripcion = descripcion;
		this.idTipoHabitacion = idTipoHabitacion;
		this.capacidad = capacidad;
		this.precio = precio;
		this.disponible = disponible;
		this.mantenimiento = mantenimiento;
	}
	
	public String getNumeroHabitacion() {return numeroHabitacion;}

	public String getDescripcion() {return descripcion;}

	public long getIdTipoHabitacion() {return idTipoHabitacion;}

	public Integer getCapacidad() {return capacidad;}

	public Double getPrecio() {return precio;}

	public Boolean getDisponible() {return disponible;}

	public void setDisponible(Boolean disponible) {this.disponible = disponible;}

	public void setNumeroHabitacion(String numeroHabitacion) {this.numeroHabitacion = numeroHabitacion;}

	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

	public void setIdTipoHabitacion(long idTipoHabitacion) {this.idTipoHabitacion = idTipoHabitacion;}

	public void setCapacidad(Integer capacidad) {this.capacidad = capacidad;}

	public void setPrecio(Double precio) {this.precio = precio;}

	public Boolean getMantenimiento() {return mantenimiento;}

	public void setMantenimiento(Boolean mantenimiento) {this.mantenimiento = mantenimiento;}

	@Override
	public String toString() 
	{
		return "Habitacion [numeroHabitacion=" + numeroHabitacion + ", descripcion=" + descripcion
				+ ", idTipoHabitacion=" + idTipoHabitacion + ", capacidad=" + capacidad + ", precio=" + precio
				+ ", disponible=" + disponible + ", mantenimiento=" + mantenimiento + "]";
	}
}
