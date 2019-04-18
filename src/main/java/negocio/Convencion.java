package negocio;

public class Convencion implements VOConvencion
{
	private long id;
	
	private Integer cantParticipantes;

	public long getId() {return id;}

	public void setId(long id) {this.id = id;}

	public Integer getCantParticipantes() {return cantParticipantes;}

	public void setCantParticipantes(Integer cantParticipantes) {this.cantParticipantes = cantParticipantes;}

	@Override
	public String toString() 
	{
		return "Convencion [id=" + id + ", cantParticipantes=" + cantParticipantes + "]";
	}	
}
