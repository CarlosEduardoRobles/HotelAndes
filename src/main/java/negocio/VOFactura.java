package negocio;

import java.util.Date;

public interface VOFactura 
{
	public long getId();

	public long getIdServicio();
	
	public Double getTotalFactura();

	public Date getFecha();
	
	public String toString();
}
