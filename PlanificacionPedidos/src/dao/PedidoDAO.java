package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComplejidadPedido;
import entities.Empleado;
import entities.Pedido;
import entities.TipoPedido;

public class PedidoDAO {

	private static PedidoDAO instancia = null;
	private static SessionFactory sf = null;

	public static PedidoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new PedidoDAO();
		}
		return instancia;
	}

	public void grabarPedido(Pedido p) {
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		sesion.save(p);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
	}

	public void actualizarPedido(Pedido p) {
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		sesion.update(p);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos(String estado) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM Pedido p WHERE p.estado = :estado");
		q.setString("estado", "Pendiente");
		pedidos = (List<Pedido>) q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return pedidos;
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> getCantidadDePedidosResueltosPorEmpleado(Empleado e) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM Pedido p WHERE p.estado = :estado AND p.idEmpleado = :idEmpleado");
		q.setString("estado", "Finalizado");
		q.setInteger("idEmpleado", e.getId());
		pedidos = (List<Pedido>) q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return pedidos;
	}

	public float getPorcentajeDeCumplimientoFechaDeEntrega() {
		Long totalPedidosFinalizados;
		Long pedidosCumplidosOk;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT count(*) FROM Pedido p WHERE p.estado = :estado AND p.fechaSolicitud >= p.fechaFinalizado");
		q.setString("estado", "Finalizado");
		pedidosCumplidosOk = (Long) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();

		Query q2 = sesion.createQuery("SELECT count(*) FROM Pedido p WHERE p.estado = :estado");
		q2.setString("estado", "Finalizado");
		totalPedidosFinalizados = (Long) q2.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return (pedidosCumplidosOk / totalPedidosFinalizados) * 100;
	}

	@SuppressWarnings("unchecked")
	public List<TipoPedido> getTipos() {
		List<TipoPedido> tipos = new ArrayList<TipoPedido>();
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM TipoPedido p");
		tipos = (List<TipoPedido>) q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return tipos;
	}

	@SuppressWarnings("unchecked")
	public List<ComplejidadPedido> getComplejidades() {
		List<ComplejidadPedido> complejidades = new ArrayList<ComplejidadPedido>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM ComplejidadPedido p");
		complejidades = (List<ComplejidadPedido>) q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return complejidades;
	}

	public TipoPedido buscarTipoPedido(String tipoPedido) {
		TipoPedido tp;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM Pedido p WHERE p.estado = :estado");
		q.setString("estado", "Pendiente");
		tp = (TipoPedido) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return tp;
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

}
