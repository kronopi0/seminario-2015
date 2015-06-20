package negocio;

import java.util.List;

import dao.TipoPedidoDAO;
import entities.TipoPedido;

public class AdmTipoPedido {

	private static AdmTipoPedido instancia;
	private static TipoPedidoDAO dao;
	
	public static AdmTipoPedido getInstancia() {
		if(instancia==null)
			instancia=new AdmTipoPedido();
		return instancia;
	}
	
	private AdmTipoPedido() {
		dao = TipoPedidoDAO.getInstancia();
	}
	
	public TipoPedido buscarTipoPedido(String tipoPedido) {
		return dao.buscarTipoPedido(tipoPedido);
	}

	public List<TipoPedido> getTiposDePedido() {
		return dao.getTiposDePedido();
	}

}
