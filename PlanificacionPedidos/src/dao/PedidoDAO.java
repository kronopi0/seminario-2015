package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Empleado;
import entities.Pedido;

public class PedidoDAO {

	private static PedidoDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static PedidoDAO getInstancia(){
		if(instancia == null){
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
	public List<Pedido> getPedidosPendientes() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Session sesion = sf.openSession();
		
		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT p FROM Pedido p WHERE p.estado = :estado");
		q.setString("estado", "Pendiente");
		pedidos = (List<Pedido>)q.list();
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
		pedidos = (List<Pedido>)q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		
		return pedidos;
	}

	public float getPorcentajeDeCumplimientoFechaDeEntrega() {
		Long  totalPedidosFinalizados;
		Long  pedidosCumplidosOk;
		Session sesion = sf.openSession();
		
		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT count(*) FROM Pedido p WHERE p.estado = :estado AND p.fechaSolicitud >= p.fechaFinalizado");
		q.setString("estado", "Finalizado");
		pedidosCumplidosOk = (Long)q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		
		Query q2 = sesion.createQuery("SELECT count(*) FROM Pedido p WHERE p.estado = :estado");
		q2.setString("estado", "Finalizado");
		totalPedidosFinalizados = (Long)q2.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		
		return (pedidosCumplidosOk/totalPedidosFinalizados) * 100;
	}

}
