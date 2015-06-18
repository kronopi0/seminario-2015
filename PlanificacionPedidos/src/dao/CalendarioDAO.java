package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Calendario;
import entities.Disponibilidad;
import entities.Pedido;

public class CalendarioDAO {

	private static CalendarioDAO instancia = null;
	private static SessionFactory sf = null;

	public static CalendarioDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new CalendarioDAO();
		}
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<Calendario> getCalendario() {
		List<Calendario> calendario = new ArrayList<Calendario>();
		Session sesion = sf.openSession();

		sesion.beginTransaction();
		Query q = sesion.createQuery("SELECT c FROM Calendario c");
		calendario = (List<Calendario>) q.list();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

		return calendario;
	}
	
	
	@SuppressWarnings("unchecked")
	public Disponibilidad getDiasHabiles(Pedido pedido) {
		Disponibilidad disp;
		Session sesion = sf.openSession();
		
		sesion.beginTransaction();
		disp = (Disponibilidad) sesion.createSQLQuery("diashabiles :fechaDesde, :fechaHasta").addEntity(Disponibilidad.class).
				setParameter("fechaDesde", pedido.getFechaSolicitud()).setParameter("fechaHasta", pedido.getFechaEntrega()).uniqueResult();
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return disp;
	}

}
