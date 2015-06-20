package negocio;

import java.util.Date;

public class AdmDisponibilidad {

	private int idDisponibilidad;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer cantidadDias;


	public AdmDisponibilidad() {
		super();
	}

	public int getId() {
		return idDisponibilidad;
	}

	public void setId(int idDisponibilidad) {
		this.idDisponibilidad = idDisponibilidad;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

}
