package negocio;

public class Utencilio implements VOUtencilio
{
	private long id;
	
	private String nombre, descripcion;
	
	private Double precio;
	
	private Boolean buenEstado;
	
	public Utencilio()
	{
		this.id = 0;
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0.0;
		this.buenEstado = false;
	}
	
	public Utencilio(long id, String nombre, String descripcion, Double precio, Boolean buenEstado)
	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.buenEstado = buenEstado;
	}

	public long getId() {return id;}

	public String getNombre() {	return nombre;}

	public String getDescripcion() {return descripcion;}

	public Double getPrecio() {return precio;}

	public Boolean getBuenEstado() {return buenEstado;}

	public void setId(long id) {this.id = id;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

	public void setPrecio(Double precio) {this.precio = precio;}

	public void setBuenEstado(Boolean buenEstado) {this.buenEstado = buenEstado;}

	@Override
	public String toString() {
		return "VOUtencilio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", buenEstado=" + buenEstado + "]";
	}
	
}
