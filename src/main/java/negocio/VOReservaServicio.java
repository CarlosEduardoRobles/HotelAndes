package negocio;

import java.util.Date;

public interface VOReservaServicio 
{
	public long getIdReserva();

	public long getIdServicio();

	public Date getComienzoReserva();

	public Date getFinalReserva();
	
	public String toString();
}
