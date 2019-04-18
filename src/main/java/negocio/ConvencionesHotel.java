package negocio;

public class ConvencionesHotel implements VOConvencionesHotel
{
	private long idHotel, idConvencion;

	public long getIdHotel() {return idHotel;}

	public void setIdHotel(long idHotel) {this.idHotel = idHotel;}

	public long getIdConvencion() {return idConvencion;}

	public void setIdConvencion(long idConvencion) {this.idConvencion = idConvencion;}

	@Override
	public String toString() 
	{
		return "ConvencionesHotel [idHotel=" + idHotel + ", idConvencion=" + idConvencion + "]";
	}
}
