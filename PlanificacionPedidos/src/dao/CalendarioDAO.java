package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Calendario;

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

}