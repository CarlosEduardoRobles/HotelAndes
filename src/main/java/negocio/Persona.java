package negocio;

public class Persona implements VOPersona
{
	private long idTipoDocumento;
	
	private long idRol;
		
	private String nombre, correo, documento;
	
	public Persona() 
	{
		this.idTipoDocumento = 0;
		this.idRol = 0;
		this.documento = "";
		this.nombre = "";
		this.correo = "";
	}

	public Persona(long idTipoDocumento, long idRol, String documento, String nombre, String correo)
	{
		this.idTipoDocumento = idTipoDocumento;
		this.idRol = idRol;
		this.documento = documento;
		this.nombre = nombre;
		this.correo = correo;
	}

	public long getIdTipoDocumento() {return idTipoDocumento;}

	public long getIdRol() {return idRol;}

	public String getDocumento() {	return documento;}

	public String getNombre() {return nombre;}

	public String getCorreo() {return correo;}

	public void setIdTipoDocumento(long idTipoDocumento) {this.idTipoDocumento = idTipoDocumento;}

	public void setIdRol(long idRol) {this.idRol = idRol;}

	public void setDocumento(String documento) {this.documento = documento;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setCorreo(String correo) {this.correo = correo;}

	@Override
	public String toString() {
		return "Persona [idTipoDocumento=" + idTipoDocumento + ", idRol=" + idRol + ", documento=" + documento
				+ ", nombre=" + nombre + ", correo=" + correo + "]";
	}
	
	
	
	
}
