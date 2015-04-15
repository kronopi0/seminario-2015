package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CALENDARIO")
public class Calendario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private boolean diahabil;
	
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
