package negocio;

public class Convencion implements VOConvencion
{
	private long id;
	
	private Integer cantParticipantes;
	
	private String nombre, nit;

	public long getId() {return id;}

	public void setId(long id) {this.id = id;}

	public Integer getCantParticipantes() {return cantParticipantes;}

	public void setCantParticipantes(Integer cantParticipantes) {this.cantParticipantes = cantParticipantes;}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getNit() {return nit;}

	public void setNit(String nit) {this.nit = nit;}
	
	@Override
	public String toString() 
	{
		return "Convencion [id=" + id + ", cantParticipantes=" + cantParticipantes + ", nombre=" + nombre + ", nit="
				+ nit + "]";
	}
	
	public Convencion(long id, Integer cantParticipantes, String nombre, String nit) 
	{
		super();
		this.id = id;
		this.cantParticipantes = cantParticipantes;
		this.nombre = nombre;
		this.nit = nit;
	}	
}
