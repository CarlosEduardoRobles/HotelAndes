package negocio;

public class ReservaParticipanteConvencion implements VOReservaParticipanteConvencion
{
	private long idTipoDocumento, idConvencion, idReserva;
	
	private String documentoPersona;

	public long getIdTipoDocumento() {return idTipoDocumento;}

	public void setIdTipoDocumento(long idTipoDocumento) {this.idTipoDocumento = idTipoDocumento;}

	public long getIdConvencion() {return idConvencion;}

	public void setIdConvencion(long idConvencion) {this.idConvencion = idConvencion;}

	public long getIdReserva() {return idReserva;}

	public void setIdReserva(long idReserva) {this.idReserva = idReserva;}

	public String getDocumentoPersona() {return documentoPersona;}

	public void setDocumentoPersona(String documentoPersona) {this.documentoPersona = documentoPersona;}

	@Override
	public String toString() 
	{
		return "ReservaParticipanteConvencion [idTipoDocumento=" + idTipoDocumento + ", idConvencion=" + idConvencion
				+ ", idReserva=" + idReserva + ", documentoPersona=" + documentoPersona + "]";
	}
}
