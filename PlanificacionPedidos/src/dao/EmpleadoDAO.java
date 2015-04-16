package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Cliente;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.TipoPedido;

public class EmpleadoDAO {

	private static EmpleadoDAO instancia = null;
	private static SessionFactory sf = null;

	public static EmpleadoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpleadoDAO();
		}
		return instancia;
	}

	public Empleado buscarEmpleado(int id) {
		Empleado e;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id");
		q.setInteger("id", id);
		e = (Empleado) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> getEmpleadosCapacitados(TipoPedido tipo, ComplejidadPedido complejidad) {
		List<Empleado> empleados = new ArrayList<Empleado>();
		Session sesion = sf.openSession();

		String query = "empleados_capacitados " + complejidad.getNombre() + ", " + tipo.getDescripcion();
		sesion.beginTransaction();
		empleados = (List<Empleado>) sesion.createSQLQuery(query).addEntity(Empleado.class).list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return empleados;
	}

}
