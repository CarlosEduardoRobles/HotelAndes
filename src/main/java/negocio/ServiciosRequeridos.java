package negocio;

import java.util.Date;

public class ServiciosRequeridos implements VOServiciosRequeridos 
{
	private long idConvencion, idServicio;
	
	private Integer cantParticipantes;
	
	private Date comienzoReserva, finalReserva;

	public long getIdConvencion() {return idConvencion;}

	public void setIdConvencion(long idConvencion) {this.idConvencion = idConvencion;}

	public long getIdServicio() {return idServicio;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public Integer getCantParticipantes() {return cantParticipantes;}

	public void setCantParticipantes(Integer cantParticipantes) {this.cantParticipantes = cantParticipantes;}

	public Date getComienzoReserva() {return comienzoReserva;}

	public void setComienzoReserva(Date comienzoReserva) {this.comienzoReserva = comienzoReserva;}

	public Date getFinalReserva() {return finalReserva;}

	public void setFinalReserva(Date finalReserva) {this.finalReserva = finalReserva;}

	@Override
	public String toString() 
	{
		return "ServiciosRequeridos [idConvencion=" + idConvencion + ", idServicio=" + idServicio
				+ ", cantParticipantes=" + cantParticipantes + ", comienzoReserva=" + comienzoReserva
				+ ", finalReserva=" + finalReserva + "]";
	}

	public ServiciosRequeridos(long idConvencion, long idServicio, Integer cantParticipantes, Date comienzoReserva,
			Date finalReserva) 
	{
		super();
		this.idConvencion = idConvencion;
		this.idServicio = idServicio;
		this.cantParticipantes = cantParticipantes;
		this.comienzoReserva = comienzoReserva;
		this.finalReserva = finalReserva;
	}		
}
