package negocio;

public class Producto implements VOProducto
{
	private long id, idServicio;
	
	private String nombre, descripcion;
	
	private Double precio;
	
	public Producto()
{
		this.id = 0;
		this.idServicio = 0;
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0.0;
	}

	public Producto(long id, long idServicio, String nombre, String descripcion, Double precio) 
	{
		this.id = id;
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public long getId() {return id;}

	public long getIdServicio() {return idServicio;}
	
	public String getNombre() {return nombre;}

	public String getDescripcion() {return descripcion;}

	public Double getPrecio() {return precio;}

	public void setId(long id) {this.id = id;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

	public void setPrecio(Double precio) {this.precio = precio;}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}
	
	
}
