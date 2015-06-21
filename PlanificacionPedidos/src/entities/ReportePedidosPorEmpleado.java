package entities;

public class ReportePedidosPorEmpleado {

	private int id;
	private String nombre;
	private String apellido;
	private long cantidad;

	public ReportePedidosPorEmpleado() {
		super();
	}

	public ReportePedidosPorEmpleado(int id, String nombre, String apellido, long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

}
