package negocio;

import java.util.Date;

public class Calendario {

	private int id;
	private Date fecha;
	private boolean diahabil;
	
	public Calendario() {
	}

	public Calendario(int id, Date fecha, boolean esDiaHabil) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.diahabil = esDiaHabil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isEsDiaHabil() {
		return diahabil;
	}

	public void setEsDiaHabil(boolean diahabil) {
		this.diahabil = diahabil;
	}
	
}
