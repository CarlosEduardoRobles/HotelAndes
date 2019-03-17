package negocio;

import java.sql.Timestamp;
import java.util.Date;

public class Factura implements VOFactura
{
	private long id;
	
	private long idServicio;
	
	private Double totalFactura;
	
	private Date fecha;
	
	public Factura()
	{
		this.id = 0;
		this.idServicio = 0;
		this.totalFactura = 0.0;
		this.fecha = new Timestamp(0);
	}

	public Factura(long id, long idServicio, Double totalFactura, Date fecha) 
	{
		this.id = id;
		this.idServicio = idServicio;
		this.totalFactura = totalFactura;
		this.fecha = fecha;
	}

	public long getId() {return id;}

	public long getIdServicio() {return idServicio;}

	public Double getTotalFactura() {return totalFactura;}

	public Date getFecha() {return fecha;}

	public void setId(long id) {this.id = id;}

	public void setIdServicio(long idServicio) {this.idServicio = idServicio;}

	public void setTotalFactura(Double totalFactura) {this.totalFactura = totalFactura;}

	public void setFecha(Date fecha) {this.fecha = fecha;}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", idServicio=" + idServicio + ", totalFactura=" + totalFactura + ", fecha="
				+ fecha + "]";
	}
	
	
}
