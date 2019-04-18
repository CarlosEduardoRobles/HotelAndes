package negocio;

public class PersonasHabitacion implements VOPersonasHabitacion 
{
	private long id,idTipoDocumentoPersona;
	
	private String numeroHabitacion, documentoPersona;

	public long getId() {return id;}

	public void setId(long id) {this.id = id;}

	public long getIdTipoDocumentoPersona() {return idTipoDocumentoPersona;}

	public void setIdTipoDocumentoPersona(long idTipoDocumentoPersona) {this.idTipoDocumentoPersona = idTipoDocumentoPersona;}

	public String getNumeroHabitacion() {return numeroHabitacion;}

	public void setNumeroHabitacion(String numeroHabitacion) {this.numeroHabitacion = numeroHabitacion;}

	public String getDocumentoPersona() {return documentoPersona;}

	public void setDocumentoPersona(String documentoPersona) {this.documentoPersona = documentoPersona;}

	@Override
	public String toString() 
	{
		return "PersonasHabitacion [id=" + id + ", idTipoDocumentoPersona=" + idTipoDocumentoPersona
				+ ", numeroHabitacion=" + numeroHabitacion + ", documentoPersona=" + documentoPersona + "]";
	}	
}
