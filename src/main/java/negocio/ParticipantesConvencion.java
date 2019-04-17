package negocio;

public class ParticipantesConvencion implements VOParticipantesConvencion
{
	private long idTipoDocumento, idConvencion;
	
	private String documentoPersona;

	public long getIdTipoDocumento() {return idTipoDocumento;}

	public void setIdTipoDocumento(long idTipoDocumento) {this.idTipoDocumento = idTipoDocumento;}

	public long getIdConvencion() {return idConvencion;}

	public void setIdConvencion(long idConvencion) {this.idConvencion = idConvencion;}

	public String getDocumentoPersona() {return documentoPersona;}

	public void setDocumentoPersona(String documentoPersona) {this.documentoPersona = documentoPersona;}

	@Override
	public String toString() 
	{
		return "ParticipantesConvencion [idTipoDocumento=" + idTipoDocumento + ", idConvencion=" + idConvencion
				+ ", documentoPersona=" + documentoPersona + "]";
	}
}
