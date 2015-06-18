package negocio;

public class TipoPedido {

	private int idTipoPedido;
	private String descripcion;
	private int tiempo;

	public TipoPedido() {
		super();
	}

	public int getId() {
		return idTipoPedido;
	}

	public void setId(int idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
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
