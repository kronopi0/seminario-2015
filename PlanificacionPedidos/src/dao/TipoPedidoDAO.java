package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.TipoPedido;

public class TipoPedidoDAO {

	private static TipoPedidoDAO instancia = null;
	private static SessionFactory sf = null;

	public static TipoPedidoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new TipoPedidoDAO();
		} 
		return instancia;
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
	
	@SuppressWarnings("unchecked")
	public List<TipoPedido> getTiposDePedido() {
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
	
}
