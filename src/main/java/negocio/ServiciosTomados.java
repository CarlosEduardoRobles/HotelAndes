package negocio;

public class ServiciosTomados
{
	private long idReserva, idServicio;
	
	private Double costo;
	
	private Integer tiempoUso;
	
	public ServiciosTomados() 
	{
		this.idReserva = 0;
		this.idServicio = 0;
		this.costo = 0.0;
		this.tiempoUso = 0;
	}

	public ServiciosTomados(long idReserva, long idServicio, Double costo, Integer tiempoUso) 
	{
		this.idReserva = idReserva;
		this.idServicio = idServicio;
		this.costo = costo;
		this.tiempoUso = tiempoUso;
	}

	public long getIdReserva() {return idReserva;}

	public long getIdServicio() {return idServicio;}

	public Double getCosto() {return costo;}

	public Integer getTiempoUso() {return tiempoUso;}

	public void setIdReserva(long idReserva) {this.idReserva = idReserva;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public void setCosto(Double costo) {this.costo = costo;}

	public void setTiempoUso(Integer tiempoUso) {this.tiempoUso = tiempoUso;}

	@Override
	public String toString() {
		return "ServiciosTomados [idReserva=" + idReserva + ", idServicio=" + idServicio + ", costo=" + costo
				+ ", tiempoUso=" + tiempoUso + "]";
	}
	
	
}
