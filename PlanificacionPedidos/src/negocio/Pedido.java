package negocio;

import java.util.Date;

public class Pedido {

	private int idPedido;
	private String descripcion;
	private ComplejidadPedido complejidad;
	private Empleado empleado;
	private int periodicidad;
	private Date fechaSolicitud;
	private Date fechaFinalizado;
	private Date fechaEntrega;
	private Cliente cliente;
	private TipoPedido tipoPedido;
	private String estado;

	public Pedido() {
		super();
	}

	public int getId() {
		return idPedido;
	}

	public void setId(int id) {
		this.idPedido = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ComplejidadPedido getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(ComplejidadPedido complejidad) {
		this.complejidad = complejidad;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaFinalizado() {
		return fechaFinalizado;
	}

	public void setFechaFinalizado(Date fechaFinalizado) {
		this.fechaFinalizado = fechaFinalizado;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
