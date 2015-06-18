package negocio;

import java.util.List;
import java.util.Set;

public class Empleado {

	private int idEmpleado;
	private String nombre;
	private String apellido;
	public Set<Pedido> pedidos;
	public List<Disponibilidad> disponibilidades;

	public Empleado() {
		super();
	}

	public Empleado(int idEmpleado, String nombre, String apellido) {
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

	public List<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	public void agregarDisponibilidad(Disponibilidad disp) {
		disponibilidades.add(disp);
	}
	
}