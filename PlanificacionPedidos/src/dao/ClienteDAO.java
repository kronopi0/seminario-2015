package dao;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.Cliente;

public class ClienteDAO {

	private static ClienteDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static ClienteDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDAO();
		} 
		return instancia;
	}

	public Cliente buscarCliente(int cuit) {
		Cliente c;
		Session sesion = sf.openSession();
		
		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT c FROM Cliente c WHERE c.cuit = :cuit");
		q.setInteger("cuit", cuit);
		c = (Cliente) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		
		return c;
	}
	
}
