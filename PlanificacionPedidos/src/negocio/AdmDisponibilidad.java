package negocio;

import java.text.ParseException;
import javax.swing.JOptionPane;

import dao.DisponibilidadDAO;
import entities.Disponibilidad;
import entities.Pedido;

public class AdmDisponibilidad {

	private static AdmDisponibilidad instancia;
	private static DisponibilidadDAO dao;

	public static AdmDisponibilidad getInstancia() {
		if (instancia == null)
			instancia = new AdmDisponibilidad();
		return instancia;
	}

	private AdmDisponibilidad() {
		dao = DisponibilidadDAO.getInstancia();
	}
	
	public void liberarDisponibilidadPedido(Pedido p) throws ParseException {

		String mensaje = "Entra a liberarDisponibilidadPedido ";
		JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		
		for (Disponibilidad d : p.getEmpleado().getDisponibilidades()) {
			if (d.getFechaInicio().compareTo(p.getFechaInicio()) == 0) {
				dao.BajaDisponibilidad(d);
			}
		}
	}

}
