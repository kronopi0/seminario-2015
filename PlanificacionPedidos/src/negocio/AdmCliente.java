package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dto.ClienteDTO;
import entities.Cliente;

public class AdmCliente {

	private static AdmCliente instancia;
	private static ClienteDAO dao;

	public static AdmCliente getInstancia() {
		if (instancia == null)
			instancia = new AdmCliente();
		return instancia;
	}

	private AdmCliente() {
		dao = ClienteDAO.getInstancia();
	}

	public void AltaCliente(ClienteDTO cliente) {
		dao.guardarCliente(toEntity(cliente));
	}

	public void ModificarCliente(ClienteDTO cliente) {
		dao.ModificarCliente(toEntity(cliente));
	}

	public void eliminarCliente(ClienteDTO cliente) {
		dao.BajaCliente(toEntity(cliente));
	}

	public Cliente buscarCliente(int cuit) {
		return dao.buscarCliente(cuit);
	}

	public List<ClienteDTO> listarClientes() {
		List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();
		List<Cliente> entities = dao.getClientes();
		for (int i = 0; i < entities.size(); i++)
			dtos.add(toDTO(entities.get(i)));
		return dtos;
	}

	private ClienteDTO toDTO(Cliente c) {
		ClienteDTO dto = new ClienteDTO();
		dto.setCuit(c.getCuit());
		dto.setDireccion(c.getDireccion());
		dto.setEmail(c.getEmail());
		dto.setNombre(c.getNombre());
		dto.setPais(c.getPais());
		dto.setTelefono(c.getTelefono());
		return dto;

	}

	private Cliente toEntity(ClienteDTO c) {
		Cliente entity = new Cliente();
		entity.setCuit(c.getCuit());
		entity.setDireccion(c.getDireccion());
		entity.setEmail(c.getEmail());
		entity.setNombre(c.getNombre());
		entity.setPais(c.getPais());
		entity.setTelefono(c.getTelefono());
		return entity;

	}

}
