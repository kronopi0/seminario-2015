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
	
}
