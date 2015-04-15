package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLEJIDADES_PEDIDOS")
public class ComplejidadPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComplejidad;
	private String nombre;
	private float factorTiempo;

	public ComplejidadPedido() {
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
