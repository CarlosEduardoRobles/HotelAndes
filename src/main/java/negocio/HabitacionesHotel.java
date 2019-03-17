package negocio;

public class HabitacionesHotel implements VOHabitacionesHotel
{
	private long idHotel;
	
	private String numeroHabitacion;
	
	public HabitacionesHotel() {
		this.idHotel = 0;
		this.numeroHabitacion = "";
	}
	
	public HabitacionesHotel(long idHotel, String numeroHabitacion)
	{
		this.idHotel = idHotel;
		this.numeroHabitacion = numeroHabitacion;
	}

	public long getIdHotel() {return idHotel;}

	public String getNumeroHabitacion() {return numeroHabitacion;}

	public void setIdHotel(long idHotel) {this.idHotel = idHotel;}

	public void setNumeroHabitacion(String numeroHabitacion) {this.numeroHabitacion = numeroHabitacion;}

	@Override
	public String toString() {
		return "HabitacionesHotel [idHotel=" + idHotel + ", numeroHabitacion=" + numeroHabitacion + "]";
	}
	
	
}
