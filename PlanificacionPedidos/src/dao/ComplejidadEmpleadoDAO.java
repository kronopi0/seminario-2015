package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComplejidadEmpleado;

public class ComplejidadEmpleadoDAO {

	private static ComplejidadEmpleadoDAO instancia = null;
	private static SessionFactory sf = null;

	public static ComplejidadEmpleadoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ComplejidadEmpleadoDAO();
		}
		return instancia;
	}
	
	// ALTAS
	public void guardarComplejidadEmpleado(ComplejidadEmpleado complejidadEmpleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(complejidadEmpleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// MODIFICAR
	public void ModificarComplejidadEmpleado(ComplejidadEmpleado complejidadEmpleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(complejidadEmpleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// ELIMINAR
	public void BajaComplejidadEmpleado(ComplejidadEmpleado complejidadEmpleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(complejidadEmpleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// BUSCAR

	@SuppressWarnings("unchecked")
	public List<ComplejidadEmpleado> getComplejidadEmpleados() {
		List<ComplejidadEmpleado> empleados = new ArrayList<ComplejidadEmpleado>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT e FROM ComplejidadEmpleado e");

		empleados = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return empleados;
	}
	@SuppressWarnings("unchecked")
	public List<ComplejidadEmpleado> getComplejidadEmpleados(int idEmpleado) {
		List<ComplejidadEmpleado> complejidadEmpleados = new ArrayList<ComplejidadEmpleado>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM TipoPedidoEmpleado p WHERE p.idEmpleado = :idEmpleado");
		q.setString(idEmpleado, "idEmpleado");
		complejidadEmpleados = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return complejidadEmpleados;
	}

}
