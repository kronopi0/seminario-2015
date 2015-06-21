package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Disponibilidad;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;

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

	public void guardarPedido(Pedido p) {
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
		q.setString("estado", estado);
		pedidos = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return pedidos;
	}

	@SuppressWarnings("unchecked")
	public List<ReportePedidosPorEmpleado> getCantidadDePedidosResueltosPorEmpleado() {
		List<ReportePedidosPorEmpleado> reportes = new ArrayList<ReportePedidosPorEmpleado>();
		;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT new entities.ReportePedidosPorEmpleado(e.idEmpleado, e.nombre, e.apellido, COUNT(*) as cant) "
				+ "FROM Pedido p join p.empleado e WHERE p.estado = :estado GROUP BY e.idEmpleado, e.nombre, e.apellido");
		q.setString("estado", "Finalizado");
		reportes = q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return reportes;
	}

	public Double getPorcentajeDeCumplimientoFechaDeEntrega() {
		Long totalPedidosFinalizados;
		Long pedidosCumplidosOk;
		Double porcentaje;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT count(*) FROM Pedido p WHERE p.estado = :estado AND p.fechaEntrega >= p.fechaFinalizado");
		q.setString("estado", "Finalizado");
		pedidosCumplidosOk = (Long) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();

		sesion.beginTransaction();
		Query q2 = sesion.createQuery("SELECT count(*) FROM Pedido p WHERE p.estado = :estado");
		q2.setString("estado", "Finalizado");
		totalPedidosFinalizados = (Long) q2.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		porcentaje = (double) pedidosCumplidosOk / totalPedidosFinalizados;
		return porcentaje * 100;

	}

	public void programarPedido(Pedido p) {
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		sesion.update(p);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		System.out.println("ID PEDIDO: " + p.getId());
	}

	public void finalizarPedido(Pedido p) {
		p.setEstado("Finalizado");
		p.setFechaFinalizado(new Date());

		Session sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.update(p);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
	}

	public Integer getCantidadDiasHabiles(Pedido pedido) {
		Disponibilidad disp;
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		disp = (Disponibilidad) sesion.createSQLQuery("diashabiles :fechaDesde, :fechaHasta").addEntity(Disponibilidad.class)
				.setParameter("fechaDesde", pedido.getFechaSolicitud()).setParameter("fechaHasta", pedido.getFechaEntrega()).uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return disp.getCantidadDias();
	}

}