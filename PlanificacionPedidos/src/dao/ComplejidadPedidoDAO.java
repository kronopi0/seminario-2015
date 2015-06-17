package dao;

import hbt.HibernateUtil;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.QuerySyntaxException;
import entities.ComplejidadPedido;

public class ComplejidadPedidoDAO {
	private static ComplejidadPedidoDAO instancia = null;
	private static SessionFactory sf = null;

	public static ComplejidadPedidoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ComplejidadPedidoDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarComplejidadPedido(ComplejidadPedido complejidadPedido){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(complejidadPedido);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//MODIFICAR
	public void ModificarComplejidadPedido(ComplejidadPedido complejidadPedido){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(complejidadPedido);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//ELIMINAR
	public void BajaComplejidadPedido(ComplejidadPedido complejidadPedido){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(complejidadPedido);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	
	public ComplejidadPedido buscarComplejidadPedido(int idComplejidad) {
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
	
	public List<ComplejidadPedido> getComplejidadPedidos(){
		List<ComplejidadPedido> complejidadPedido = null;
		try {
			Session session = sf.openSession();
	
			String hql = "SELECT *FROM ComplejidadPedido";
			
			Query query = session.createQuery(hql);
			complejidadPedido = (List<ComplejidadPedido>) query.list();
			
			session.close();
			
		}catch (QuerySyntaxException q){
			JOptionPane.showMessageDialog(null, q, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Exception de sintaxis en ComplejidadPedidoDAO: buscarComplejidadPedidoByComplejidadPedidos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complejidadPedido;
	}

}
