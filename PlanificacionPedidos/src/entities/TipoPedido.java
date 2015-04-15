package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOS_PEDIDO")
public class TipoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipoPedido;
	private String descripcion;
	private int tiempo;

	public TipoPedido() {
		super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantDias() {
		return tiempo;
	}

	public void setCantDias(int cantDias) {
		this.tiempo = cantDias;
	}

}
