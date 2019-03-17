package negocio;

public class Servicio implements VOServicio
{
	private long id, idTipoServicio;
	
	private String nombre, descripcion;
	
	private Integer capacidad;
	
	private Double costoUso;

	public Servicio() 
	{
		this.id = 0;
		this.idTipoServicio = 0;
		this.nombre = "";
		this.descripcion = "";
		this.costoUso = 0.0;
		this.capacidad = 0;
	}
	
	public Servicio(long id, long idTipoServicio, String nombre, String descripcion, Double costoUso,
			Integer capacidad) 
	{
		this.id = id;
		this.idTipoServicio = idTipoServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoUso = costoUso;
		this.capacidad = capacidad;
	}

	public long getId() {return id;}

	public long getIdTipoServicio() {return idTipoServicio;}

	public String getNombre() {return nombre;}

	public String getDescripcion() {return descripcion;}

	public Double getCostoUso() {return costoUso;}

	public Integer getCapacidad() {return capacidad;}

	public void setId(long id) {this.id = id;}

	public void setIdTipoServicio(long idTipoServicio) {this.idTipoServicio = idTipoServicio;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

	public void setCostoUso(Double costoUso) {this.costoUso = costoUso;}

	public void setCapacidad(Integer capacidad) {this.capacidad = capacidad;}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", idTipoServicio=" + idTipoServicio + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", costoUso=" + costoUso + ", capacidad=" + capacidad + "]";
	}
	
	
}
