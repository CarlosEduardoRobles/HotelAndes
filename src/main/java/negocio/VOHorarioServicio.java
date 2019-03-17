package negocio;

import java.util.Date;

public interface VOHorarioServicio 
{
	public long getIdServicio();

	public Date getInicioServicio();

	public Date getFinalServicio();
	
	public String toString();
}
