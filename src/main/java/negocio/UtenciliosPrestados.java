package negocio;

public class UtenciliosPrestados implements VOUtenciliosPrestados
{
	private long idUtencilio, idReserva;
	
	public UtenciliosPrestados() 
	{
		this.idUtencilio = 0;
		this.idReserva = 0;
	}

	public UtenciliosPrestados(long idUtencilio, long idReserva) 
	{
		this.idUtencilio = idUtencilio;
		this.idReserva = idReserva;
	}

	public long getIdUtencilio() {return idUtencilio;}

	public long getIdReserva() {return idReserva;}

	public void setIdUtencilio(long idUtencilio) {this.idUtencilio = idUtencilio;}

	public void setIdReserva(long idReserva) {this.idReserva = idReserva;}

	@Override
	public String toString() {
		return "UtenciliosPrestados [idUtencilio=" + idUtencilio + ", idReserva=" + idReserva + "]";
	}	
}
