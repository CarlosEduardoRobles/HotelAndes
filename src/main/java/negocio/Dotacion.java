package negocio;

public class Dotacion implements VODotacion
{
	//---------------------------------------------------------------
	//--------------------------Atributos----------------------------
	//---------------------------------------------------------------
	/**
	 * Identificador del objeto
	 */
	private long id;
	
	/**
	 * Nombre del objeto
	 */
	private String nombre;
	
	/**
	 * Descripcion general del objeto
	 */
	private String descripcion;
	
	/**
	 * Precio del objeto
	 */
	private Double precio;
	
	public Dotacion() 
	{
		this.id = 0;
		this.nombre = "";
		this.descripcion = "";
		this.precio = 0.0;
	}
	
	public Dotacion(long id, String nombre, String descripcion, Double precio) 
	{
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	//---------------------------------------------------------------
	//---------------------------Metodos-----------------------------
	//---------------------------------------------------------------
	public long getId() {return id;}

	public String getNombre() {return nombre;}

	public String getDescripcion() {return descripcion;}

	public Double getPrecio() {return precio;}

	public void setId(long id) {this.id = id;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setDescripcion(String descripcion) {this.descripcion = descripcion;	}

	public void setPrecio(Double precio) {this.precio = precio;}

	@Override
	public String toString() {
		return "Dotacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}
	
	
}
