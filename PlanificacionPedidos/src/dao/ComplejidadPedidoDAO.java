package dao;

import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
