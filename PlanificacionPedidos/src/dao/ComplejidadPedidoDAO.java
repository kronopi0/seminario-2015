package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComplejidadPedido;

public class ComplejidadPedidoDAO {
	private static ComplejidadPedidoDAO instancia = null;
	private static SessionFactory sf = null;

	public static ComplejidadPedidoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ComplejidadPedidoDAO();
		}
		return instancia;
	}

	// ALTAS
	public void grabarComplejidadPedido(ComplejidadPedido complejidadPedido) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(complejidadPedido);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// MODIFICAR
	public void ModificarComplejidadPedido(ComplejidadPedido complejidadPedido) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(complejidadPedido);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// ELIMINAR
	public void BajaComplejidadPedido(ComplejidadPedido complejidadPedido) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(complejidadPedido);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// BUSCAR

	public ComplejidadPedido buscarComplejidadPedidoPorId(int idComplejidad) {
		ComplejidadPedido c;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT c FROM ComplejidadPedido c WHERE c.idComplejidad = :idComplejidad");
		q.setInteger("idComplejidad", idComplejidad);
		c = (ComplejidadPedido) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return c;
	}

	public ComplejidadPedido buscarComplejidadPedido(String complejidad) {
		ComplejidadPedido cp;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT cp FROM ComplejidadPedido cp WHERE cp.nombre = :nombre");
		q.setString("nombre", complejidad);
		cp = (ComplejidadPedido) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return cp;
	}

	@SuppressWarnings("unchecked")
	public List<ComplejidadPedido> getComplejidadesPedido() {
		List<ComplejidadPedido> complejidades = new ArrayList<ComplejidadPedido>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM ComplejidadPedido p");
		complejidades = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return complejidades;
	}

}
