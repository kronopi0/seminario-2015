package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TipoPedidoEmpleadoID implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idEmpleado;
	private int idTipoPedido;
	
	public TipoPedidoEmpleadoID() {
		super();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(int idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}
	
}
