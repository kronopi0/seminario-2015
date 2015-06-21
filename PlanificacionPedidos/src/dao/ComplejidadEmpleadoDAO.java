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

}
