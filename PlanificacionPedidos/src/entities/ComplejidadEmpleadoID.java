package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ComplejidadEmpleadoID implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idEmpleado;
	private int idComplejidad;
	
	public ComplejidadEmpleadoID() {
		super();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdComplejidadPedido() {
		return idComplejidad;
	}

	public void setIdComplejidadPedido(int idComplejidad) {
		this.idComplejidad = idComplejidad;
	}
	
}
