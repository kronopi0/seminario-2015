package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.TipoPedidoEmpleado;

public class TipoPedidoEmpleadoDAO {
	
	private static TipoPedidoEmpleadoDAO instancia = null;
	private static SessionFactory sf = null;

	public static TipoPedidoEmpleadoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new TipoPedidoEmpleadoDAO();
		}
		return instancia;
	}

	// ALTAS
	public void guardarTipoPedidoEmpleado(TipoPedidoEmpleado tipoPedidoEmpleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(tipoPedidoEmpleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// MODIFICAR
	public void ModificarTipoPedidoEmpleado(TipoPedidoEmpleado tipoPedidoEmpleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(tipoPedidoEmpleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// ELIMINAR
	public void BajaTipoPedidoEmpleado(TipoPedidoEmpleado tipoPedidoEmpleado) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(tipoPedidoEmpleado);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	// BUSCAR

	public TipoPedidoEmpleado buscarTipoPedidoEmpleado(int idEmpleado) {
		TipoPedidoEmpleado c;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT c FROM TipoPedidoEmpleado c WHERE c.idEmpleado = :idEmpleado");
		q.setInteger("idEmpleado", idEmpleado);
		c = (TipoPedidoEmpleado) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoPedidoEmpleado> getTipoPedidoEmpleados(int idEmpleado) {
		List<TipoPedidoEmpleado> tipoPedidoEmpleados = new ArrayList<TipoPedidoEmpleado>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM TipoPedidoEmpleado p WHERE p.idEmpleado = :idEmpleado");
		q.setString(idEmpleado, "idEmpleado");
		tipoPedidoEmpleados = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return tipoPedidoEmpleados;
	}

}
