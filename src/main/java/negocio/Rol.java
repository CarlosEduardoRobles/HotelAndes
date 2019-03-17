package negocio;

public class Rol implements VORol
{
	private long id;
	
	private String nombre;
	
	public Rol() 
	{
		this.id = 0;
		this.nombre = "";
	}

	public Rol(long id, String nombre) 
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
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
