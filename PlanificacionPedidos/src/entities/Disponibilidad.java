package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISPONIBILIDADES")
public class Disponibilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDisponibilidad;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer cantidadDias;


	public Disponibilidad() {
		super();
	}
	
	public Integer getIdDisponibilidad() {
		return idDisponibilidad;
	}

	public void setIdDisponibilidad(Integer idDisponibilidad) {
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
