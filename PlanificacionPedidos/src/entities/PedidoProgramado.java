package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOS_PROGRAMADOS")
public class PedidoProgramado {

	@EmbeddedId
	private PedidoProgramadoID id;

	public PedidoProgramado() {
		super();
	}

}