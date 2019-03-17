package negocio;

public class ProductosFactura 
{
	private long idFactura, idProducto;
	
	private Integer cantidad;
	
	public ProductosFactura() 
	{
		this.idFactura = 0;
		this.idProducto = 0;
		this.cantidad = 0;
	}

	public ProductosFactura(long idFactura, long idProducto, Integer cantidad) 
	{
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public long getIdFactura() {return idFactura;}

	public long getIdProducto() {return idProducto;}

	public Integer getCantidad() {return cantidad;}

	public void setIdFactura(long idFactura) {this.idFactura = idFactura;}

	public void setIdProducto(long idProducto) {this.idProducto = idProducto;}

	public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}

	@Override
	public String toString() {
		return "ProductosFactura [idFactura=" + idFactura + ", idProducto=" + idProducto + ", cantidad=" + cantidad
				+ "]";
	}
	
	
}
