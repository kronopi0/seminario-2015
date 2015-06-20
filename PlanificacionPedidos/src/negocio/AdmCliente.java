package negocio;

import dao.ClienteDAO;
import entities.Cliente;

public class AdmCliente {

	private static AdmCliente instancia;
	private static ClienteDAO dao;
	
	public static AdmCliente getInstancia() {
		if(instancia==null)
			instancia=new AdmCliente();
		return instancia;
	}
	
	private AdmCliente() {
		dao = ClienteDAO.getInstancia();
	}
	
	public Cliente buscarCliente(int cuit) {
		return dao.buscarCliente(cuit);
	}

	public void guardarCliente(Cliente cliente) {
		dao.guardarCliente(cliente);
	}

}
