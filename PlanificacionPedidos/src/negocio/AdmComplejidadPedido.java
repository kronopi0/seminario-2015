package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ComplejidadPedidoDAO;
import dto.ComplejidadPedidoDTO;
import entities.ComplejidadPedido;

public class AdmComplejidadPedido {

	private static AdmComplejidadPedido instancia;
	private static ComplejidadPedidoDAO dao;

	public static AdmComplejidadPedido getInstancia() {
		if (instancia == null)
			instancia = new AdmComplejidadPedido();
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

	public void AltaComplejidadPedido(ComplejidadPedidoDTO c) {
		dao.grabarComplejidadPedido(toEntity(c));
	}

	public void ModificarComplejidadPedido(ComplejidadPedidoDTO c) {
		dao.ModificarComplejidadPedido(toEntity(c));
	}

	public void eliminarComplejidadPedido(ComplejidadPedidoDTO ComplejidadPedido) {
		dao.BajaComplejidadPedido(toEntity(ComplejidadPedido));
	}

	private ComplejidadPedidoDTO toDTO(ComplejidadPedido c) {
		ComplejidadPedidoDTO dto = new ComplejidadPedidoDTO();
		dto.setId(c.getId());
		dto.setNombre(c.getNombre());
		dto.setFactorTiempo(c.getFactorTiempo());
		return dto;
	}

	private ComplejidadPedido toEntity(ComplejidadPedidoDTO c) {
		ComplejidadPedido entity = new ComplejidadPedido();
		entity.setId(c.getId());
		entity.setNombre(c.getNombre());
		entity.setFactorTiempo(c.getFactorTiempo());
		return entity;
	}

	public List<ComplejidadPedidoDTO> listarComplejidades() {

		List<ComplejidadPedidoDTO> dtos = new ArrayList<ComplejidadPedidoDTO>();
		List<ComplejidadPedido> entities = dao.getComplejidadesPedido();
		for (int i = 0; i < entities.size(); i++)
			dtos.add(toDTO(entities.get(i)));
		return dtos;
	}
}
