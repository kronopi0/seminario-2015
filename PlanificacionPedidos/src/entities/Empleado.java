package entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {

	@Id
	private int idEmpleado;
	private String nombre;
	private String apellido;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empleado", cascade = CascadeType.ALL)
	public Set<Pedido> pedidos;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idEmpleado")
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
		this.disponibilidades.add(disp);
	}

}