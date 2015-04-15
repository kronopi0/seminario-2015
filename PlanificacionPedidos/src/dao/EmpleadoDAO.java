package dao;

import hbt.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.Empleado;

public class EmpleadoDAO {

	private static EmpleadoDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static EmpleadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpleadoDAO();
		} 
		return instancia;
	}

	public Empleado buscarEmpleado(int id) {
		Empleado e;
		Session sesion = sf.openSession();
		
		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT e FROM Empleado e WHERE e.idEmpleado = :id");
		q.setInteger("id", id);
		e = (Empleado) q.uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		
		return e;
	}
	
}
