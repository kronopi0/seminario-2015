package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Empleado;
import entities.ComplejidadPedido;
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

	// ALTAS
	public void grabarEmpleado(Empleado empleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(empleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// MODIFICAR
	public void actualizarEmpleado(Empleado empleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(empleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// ELIMINAR
	public void BajaEmpleado(Empleado empleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(empleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// BUSCAR

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
		empleados = sesion.createSQLQuery(query).addEntity(Empleado.class).list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return empleados;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> getEmpleados() {
		List<Empleado> Empleados = new ArrayList<Empleado>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT e FROM Empleado e");
		Empleados = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return Empleados;
	}

}
