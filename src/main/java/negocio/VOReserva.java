package negocio;

import java.util.Date;

public interface VOReserva
{
	public long getId();

	public long getIdTipoDocumentoPersona();

	public String getDocumentoPersona();

	public String getNumeroHabitacion();

	public Integer getNumeroPersonas();

	public Boolean getCheckIn();
	
	public Boolean getCheckOut();

	public Date getFechaEntrada();

	public Date getFechaSalida();
	
	public String toString();
}
