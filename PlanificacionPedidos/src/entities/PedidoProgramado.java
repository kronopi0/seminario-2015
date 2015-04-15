package entities;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOS_PROGRAMADOS")
public class PedidoProgramado {

	@EmbeddedId
	private PedidoProgramadoID id;
	private Date fechaComienzo;
	private Date fechaFinalizado;

	public PedidoProgramado() {
		super();
	}

	public Date getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public Date getFechaFinalizado() {
		return fechaFinalizado;
	}

	public void setFechaFinalizado(Date fechaFinalizado) {
		this.fechaFinalizado = fechaFinalizado;
	}

}
