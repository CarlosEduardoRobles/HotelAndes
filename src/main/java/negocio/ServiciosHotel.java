package negocio;

public class ServiciosHotel
{
	private long idHotel, idServicio;
	
	public ServiciosHotel() 
	{
		this.idHotel = 0;
		this.idServicio = 0;
	}

	public ServiciosHotel(long idHotel, long idServicio) 
	{
		this.idHotel = idHotel;
		this.idServicio = idServicio;
	}

	public long getIdHotel() {return idHotel;}

	public long getIdServicio() {return idServicio;}

	public void setIdHotel(long idHotel) {this.idHotel = idHotel;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	@Override
	public String toString() {
		return "ServiciosHotel [idHotel=" + idHotel + ", idServicio=" + idServicio + "]";
	}
	
	
}
