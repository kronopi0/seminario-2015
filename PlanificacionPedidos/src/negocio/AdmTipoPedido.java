package negocio;

import java.util.List;

import dao.TipoPedidoDAO;
import dto.TipoPedidoDTO;
import entities.TipoPedido;

public class AdmTipoPedido {

	private static AdmTipoPedido instancia;
	private static TipoPedidoDAO dao;

	public static AdmTipoPedido getInstancia() {
		if (instancia == null)
			instancia = new AdmTipoPedido();
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

	public TipoPedido toEntity(TipoPedidoDTO t) {

		TipoPedido entity = new TipoPedido();
		entity.setIdTipoPedido(t.getIdTipoPedido());
		entity.setDescripcion(t.getDescripcion());
		entity.setTiempo(t.getTiempo());
		return entity;
	}

}
