package dto;

public class TipoPedidoDTO {

	private int idTipoPedido;
	private String descripcion;
	private int tiempo;

	public TipoPedidoDTO() {
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

	public int getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(int idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

}
