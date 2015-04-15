package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado {

	@Id
	private int idEmpleado;
	private String nombre;
	private String apellido;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idEmpleado")
	public Set<PedidoProgramado> pedidos;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idEmpleado")
	public Set<Disponibilidad> disponibilidades;
	
	public Empleado() {
		super();
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

	public Set<PedidoProgramado> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoProgramado> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(Set<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
	
}
