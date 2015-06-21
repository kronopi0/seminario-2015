package dto;

import java.util.Date;

public class PedidoDTO {

	private int idPedido;
	private String descripcion;
	private ComplejidadPedidoDTO complejidad;
	private EmpleadoDTO empleado;
	private int periodicidad;
	private Date fechaSolicitud;
	private Date fechaInicio;
	private Date fechaFinalizado;
	private Date fechaEntrega;
	private ClienteDTO cliente;
	private TipoPedidoDTO tipoPedido;
	private String estado;

	public PedidoDTO() {
		super();
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ComplejidadPedidoDTO getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(ComplejidadPedidoDTO complejidad) {
		this.complejidad = complejidad;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDTO empleado) {
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public TipoPedidoDTO getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedidoDTO tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
