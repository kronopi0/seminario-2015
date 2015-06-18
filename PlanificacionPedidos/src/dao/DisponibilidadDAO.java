package dao;

import java.util.ArrayList;
import java.util.List;

import hbt.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ComplejidadPedido;
import entities.Disponibilidad;
import entities.Empleado;
import entities.TipoPedido;


public class DisponibilidadDAO {
	private static DisponibilidadDAO instancia = null;
	private static SessionFactory sf = null;

	public static DisponibilidadDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new DisponibilidadDAO();
		} 
		return instancia;
	}
	
	// ALTAS
	public void grabarDisponibilidad(Disponibilidad disponibilidad){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(disponibilidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//MODIFICAR
	public void ModificarDisponibilidad(Disponibilidad disponibilidad){
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(disponibilidad);  
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//ELIMINAR
	public void BajaDisponibilidad(Disponibilidad disponibilidad){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(disponibilidad);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	// BUSCAR
	
	@SuppressWarnings("unchecked")
	public List<Disponibilidad> buscarDisponibilidadPorEmpleado(int idEmpleado) {
		List<Disponibilidad> disponibilidades = new ArrayList<Disponibilidad>();
		Session sesion = sf.openSession();
		String query = "disponibilidad " + idEmpleado;
		sesion.beginTransaction();
		disponibilidades = (List<Disponibilidad>) sesion.createSQLQuery(query).addEntity(Disponibilidad.class).list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return disponibilidades;
	}

}
