package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Calendario;
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
	public int getDiasHabiles(Pedido pedido) {
		long dias;
		long d=0;
		Session sesion = sf.openSession();
		String query = "diashabiles " + pedido.getFechaSolicitud() + ", " + pedido.getFechaEntrega();
		//String query = "diashabiles " + "2015-05-01" + ", " +"2015-06-01";
		sesion.beginTransaction();
		//sesion.createSQLQuery(query).addEntity(Calendario.class);
		dias = (Long) sesion.createSQLQuery(query).addEntity(Calendario.class).uniqueResult();
		String mensaje = "";
		mensaje = "dias habiles: "+dias;
		JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
		return (int)dias;
	}

}
