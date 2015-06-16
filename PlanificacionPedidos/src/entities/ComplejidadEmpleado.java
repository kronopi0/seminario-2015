package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COMPLEJIDADES_EMPLEADO")
public class ComplejidadEmpleado {

	@EmbeddedId
	private ComplejidadEmpleadoID id;

	public ComplejidadEmpleado() {
		super();
	}

	public ComplejidadEmpleadoID getId() {
		return id;
	}

	public void setId(ComplejidadEmpleadoID id) {
		this.id = id;
	}
	
}
