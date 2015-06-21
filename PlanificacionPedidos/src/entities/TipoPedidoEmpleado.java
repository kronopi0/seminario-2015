package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOS_PEDIDO_EMPLEADO")
public class TipoPedidoEmpleado {

	@EmbeddedId
	private TipoPedidoEmpleadoID id;

	public TipoPedidoEmpleado() {
		super();
	}

}
