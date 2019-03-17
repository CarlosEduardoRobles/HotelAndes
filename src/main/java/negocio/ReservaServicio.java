package negocio;

import java.sql.Timestamp;
import java.util.Date;

public class ReservaServicio implements VOReservaServicio 
{
	private long idReserva, idServicio;
	
	private Date comienzoReserva, finalReserva;
	
	private Integer cantidadAsistentes;
	
	public ReservaServicio()
	{
		this.idReserva = 0;
		this.idServicio = 0;
		this.comienzoReserva = new Timestamp(0);
		this.finalReserva = new Timestamp(0);
		this.cantidadAsistentes = 0;
	}
	
	public ReservaServicio(long idReserva, long idServicio, Date comienzoReserva, Date finalReserva,
			Integer cantidadAsistentes) 
	{
		this.idReserva = idReserva;
		this.idServicio = idServicio;
		this.comienzoReserva = comienzoReserva;
		this.finalReserva = finalReserva;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public long getIdReserva() {return idReserva;}

	public long getIdServicio() {return idServicio;}

	public Date getComienzoReserva() {return comienzoReserva;}

	public Date getFinalReserva() {return finalReserva;}

	public void setIdReserva(long idReserva) {this.idReserva = idReserva;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public void setComienzoReserva(Date comienzoReserva) {this.comienzoReserva = comienzoReserva;}

	public void setFinalReserva(Date finalReserva) {this.finalReserva = finalReserva;}

	@Override
	public String toString() {
		return "ReservaServicio [idReserva=" + idReserva + ", idServicio=" + idServicio + ", comienzoReserva="
				+ comienzoReserva + ", finalReserva=" + finalReserva + "]";
	}
	
	
}
