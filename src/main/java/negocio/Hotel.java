package negocio;

public class Hotel implements VOHotel
{
	private long id;
	
	private String nombre;
	
	public Hotel() {
		this.id = 0;
		this.nombre = "";
	}

	public Hotel(long id, String nombre) 
	{
		this.id = id;
		this.nombre = nombre;
	}

	public long getId() {return id;}

	public String getNombre() {return nombre;}

	public void setId(long id) {this.id = id;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
