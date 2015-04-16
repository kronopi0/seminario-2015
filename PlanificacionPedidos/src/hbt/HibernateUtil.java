package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Calendario.class);
			config.addAnnotatedClass(Cliente.class);
			config.addAnnotatedClass(ComplejidadPedido.class);
			config.addAnnotatedClass(Disponibilidad.class);
			config.addAnnotatedClass(Empleado.class);
			config.addAnnotatedClass(Pedido.class);
			config.addAnnotatedClass(PedidoProgramado.class);
			config.addAnnotatedClass(PedidoProgramadoID.class);
			config.addAnnotatedClass(TipoPedido.class);	
			config.addAnnotatedClass(ComplejidadEmpleado.class);
			config.addAnnotatedClass(ComplejidadEmpleadoID.class);
			config.addAnnotatedClass(TipoPedidoEmpleado.class);
			config.addAnnotatedClass(TipoPedidoEmpleadoID.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
