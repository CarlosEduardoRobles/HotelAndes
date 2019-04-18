package negocio;

import java.util.Date;

public interface VOServiciosRequeridos 
{
	public long getIdConvencion();
	
	public long getIdServicio();
	
	public Integer getCantParticipantes();
	
	public Date getComienzoReserva();

	public Date getFinalReserva();
	
	public String toString();
}
