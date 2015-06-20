package negocio;

import java.util.List;

import dao.ComplejidadPedidoDAO;
import entities.ComplejidadPedido;

public class AdmComplejidadPedido {

	private static AdmComplejidadPedido instancia;
	private static ComplejidadPedidoDAO dao;
	
	public static AdmComplejidadPedido getInstancia() {
		if(instancia==null)
			instancia=new AdmComplejidadPedido();
		return instancia;
	}
	
	private AdmComplejidadPedido() {
		dao = ComplejidadPedidoDAO.getInstancia();
	}

	public ComplejidadPedido buscarComplejidadPedido(String complejidad) {
		return dao.buscarComplejidadPedido(complejidad);
	}

	public List<ComplejidadPedido> getComplejidadesPedido() {
		return dao.getComplejidadesPedido();
	}
	
}
