package negocio;

public class PersonasHotel implements VOPersonasHotel
{
	private long idHotel, idTipoDocumentoPersona, documentoPersona;

	public PersonasHotel() 
	{
		this.idHotel = 0;
		this.idTipoDocumentoPersona = 0;
		this.documentoPersona = 0;
	}
	
	public PersonasHotel(long idHotel, long idTipoDocumentoPersona, long documentoPersona) 
	{
		this.idHotel = idHotel;
		this.idTipoDocumentoPersona = idTipoDocumentoPersona;
		this.documentoPersona = documentoPersona;
	}

	public long getIdHotel() {return idHotel;}

	public long getIdTipoDocumentoPersona() {return idTipoDocumentoPersona;}

	public long getDocumentoPersona() {return documentoPersona;}

	public void setIdHotel(long idHotel) {this.idHotel = idHotel;}

	public void setIdTipoDocumentoPersona(long idTipoDocumentoPersona) {this.idTipoDocumentoPersona = idTipoDocumentoPersona;}

	public void setDocumentoPersona(long documentoPersona) {this.documentoPersona = documentoPersona;}

	@Override
	public String toString() {
		return "PersonasHotel [idHotel=" + idHotel + ", idTipoDocumentoPersona=" + idTipoDocumentoPersona
				+ ", documentoPersona=" + documentoPersona + "]";
	}
	
	
}
