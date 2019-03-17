package negocio;

import java.sql.Timestamp;
import java.util.Date;

public class HorarioServicio implements VOHorarioServicio
{
	private long idServicio;
	
	private Date inicioServicio;
	
	private Date finalServicio;
	
	public HorarioServicio() 
	{
		this.idServicio = 0;
		this.inicioServicio = new Timestamp(0);
		this.finalServicio = new Timestamp(0);
	}


	public HorarioServicio(long idServicio, Date inicioServicio, Date finalServicio) 
	{
		this.idServicio = idServicio;
		this.inicioServicio = inicioServicio;
		this.finalServicio = finalServicio;
	}

	public long getIdServicio() {return idServicio;}

	public Date getInicioServicio() {return inicioServicio;}

	public Date getFinalServicio() {return finalServicio;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public void setInicioServicio(Date inicioServicio) {this.inicioServicio = inicioServicio;}

	public void setFinalServicio(Date finalServicio) {this.finalServicio = finalServicio;}

	@Override
	public String toString() {
		return "HorarioServicio [idServicio=" + idServicio + ", inicioServicio=" + inicioServicio + ", finalServicio="
				+ finalServicio + "]";
	}
	
}
