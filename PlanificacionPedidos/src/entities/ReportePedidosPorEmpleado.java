package entities;

public class ReportePedidosPorEmpleado {

	private Integer id;
	private String nombre;
	private String apellido;
	private Integer cantidad;
	
	public ReportePedidosPorEmpleado(Integer id, String nombre, String apellido,
			Integer cantidad) {
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
