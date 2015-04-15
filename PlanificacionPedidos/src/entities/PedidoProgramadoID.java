package entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoProgramadoID implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idEmpleado;
	private int idPedido;

	public PedidoProgramadoID() {
		super();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

}
