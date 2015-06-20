package dao;

import java.util.ArrayList;
import java.util.List;

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
	
	// ALTAS
	public void guardarCliente(Cliente cliente){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(cliente);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//MODIFICAR
	public void ModificarCliente(Cliente cliente){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(cliente);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//ELIMINAR
	public void BajaCliente(Cliente cliente){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(cliente);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	
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
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT c FROM Cliente c");
		clientes = (List<Cliente>) q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return clientes;
	}

}
