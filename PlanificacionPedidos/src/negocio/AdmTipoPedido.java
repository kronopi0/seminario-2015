package negocio;

import java.util.ArrayList;
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

	public List<TipoPedidoDTO> getTiposDePedidoDTO() {
		List<TipoPedido> entities = dao.getTiposDePedido();
		List<TipoPedidoDTO> result = new ArrayList<TipoPedidoDTO>();

		for (int i = 0; i < entities.size(); i++)
			result.add(toDTO(entities.get(i)));

		return result;
	}

	public TipoPedidoDTO toDTO(TipoPedido t) {

		TipoPedidoDTO result = new TipoPedidoDTO();

		result.setIdTipoPedido(t.getIdTipoPedido());
		result.setDescripcion(t.getDescripcion());
		result.setTiempo(t.getTiempo());

		return result;
	}

	public TipoPedido toEntity(TipoPedidoDTO t) {

		TipoPedido entity = new TipoPedido();
		entity.setIdTipoPedido(t.getIdTipoPedido());
		entity.setDescripcion(t.getDescripcion());
		entity.setTiempo(t.getTiempo());
		return entity;
	}

	public void AltaTipoPedido(TipoPedidoDTO c) {
		dao.grabarTipoPedido(toEntity(c));
	}

	public void ModificarTipoPedido(TipoPedidoDTO c) {
		dao.ModificarTipoPedido(toEntity(c));
	}

	public void eliminarTipoPedido(TipoPedidoDTO TipoPedido) {
		dao.BajaTipoPedido(toEntity(TipoPedido));
	}
}
