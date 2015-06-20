package negocio;

import java.util.List;

import dao.EmpleadoDAO;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.TipoPedido;

public class AdmEmpleado {

	private static AdmEmpleado instancia;
	private static EmpleadoDAO dao;
	
	public static AdmEmpleado getInstancia() {
		if(instancia==null)
			instancia=new AdmEmpleado();
		return instancia;
	}
	
	private AdmEmpleado() {
		dao = EmpleadoDAO.getInstancia();
	}
	
	public Empleado buscarEmpleado(int id) {
		return dao.buscarEmpleado(id);
	}
	
	public void actualizarEmpleado(Empleado e) {
		dao.actualizarEmpleado(e);
	}
	
	public List<Empleado> getEmpleadosCapacitados(TipoPedido tipo, ComplejidadPedido complejidad) {
		return dao.getEmpleadosCapacitados(tipo, complejidad);
	}
	
}