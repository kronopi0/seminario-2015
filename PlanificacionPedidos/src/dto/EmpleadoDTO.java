package dto;

import java.util.List;
import java.util.Set;

public class EmpleadoDTO {

	private int idEmpleado;
	private String nombre;
	private String apellido;

	public Set<PedidoDTO> pedidos;
	public List<DisponibilidadDTO> disponibilidades;

	public EmpleadoDTO() {
		super();
	}

	public EmpleadoDTO(int idEmpleado, String nombre, String apellido) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getId() {
		return idEmpleado;
	}

	public void setId(int id) {
		this.idEmpleado = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<DisponibilidadDTO> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<DisponibilidadDTO> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

}