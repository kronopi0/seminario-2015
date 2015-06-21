package dto;

public class ComplejidadPedidoDTO {

	private int idComplejidad;
	private String nombre;
	private float factorTiempo;

	public ComplejidadPedidoDTO() {
		super();
	}

	public int getId() {
		return idComplejidad;
	}

	public void setId(int id) {
		this.idComplejidad = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getFactorTiempo() {
		return factorTiempo;
	}

	public void setFactorTiempo(float factorTiempo) {
		this.factorTiempo = factorTiempo;
	}

}
