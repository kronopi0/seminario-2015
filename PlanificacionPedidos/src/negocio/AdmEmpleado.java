package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.EmpleadoDAO;
import dto.EmpleadoDTO;
import entities.Disponibilidad;
import entities.Empleado;
import entities.ComplejidadPedido;
import entities.TipoPedido;

public class AdmEmpleado {

	private static AdmEmpleado instancia;
	private static EmpleadoDAO dao;

	public static AdmEmpleado getInstancia() {
		if (instancia == null)
			instancia = new AdmEmpleado();
		return instancia;
	}

	private AdmEmpleado() {
		dao = EmpleadoDAO.getInstancia();
	}

	public Empleado buscarEmpleado(int id) {
		return dao.buscarEmpleado(id);
	}

	public void actualizarEmpleado(Empleado e) {
		dao.actualizarEmpleado(e);
	}

	public List<Empleado> getEmpleadosCapacitados(TipoPedido tipo, ComplejidadPedido complejidad) {
		return dao.getEmpleadosCapacitados(tipo, complejidad);
	}

	public void AltaEmpleado(EmpleadoDTO Empleado) {
		dao.grabarEmpleado(toEntity(Empleado));
	}

	public void ModificarEmpleado(EmpleadoDTO Empleado) {
		dao.actualizarEmpleado(toEntity(Empleado));
	}

	public void eliminarEmpleado(EmpleadoDTO Empleado) {
		dao.BajaEmpleado(toEntity(Empleado));
	}

	private EmpleadoDTO toDTO(Empleado c) {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.setId(c.getId());
		dto.setNombre(c.getNombre());
		dto.setApellido(c.getApellido());
		return dto;

	}

	private Empleado toEntity(EmpleadoDTO c) {
		Empleado entity = new Empleado();
		List<Disponibilidad> disponibilidades = new ArrayList<Disponibilidad>();

		entity.setId(c.getId());
		entity.setNombre(c.getNombre());
		entity.setApellido(c.getApellido());
		entity.setDisponibilidades(disponibilidades);
		return entity;

	}

	public List<EmpleadoDTO> listarEmpleados() {
		List<EmpleadoDTO> dtos = new ArrayList<EmpleadoDTO>();
		List<Empleado> entities = dao.getEmpleados();
		for (int i = 0; i < entities.size(); i++)
			dtos.add(toDTO(entities.get(i)));
		return dtos;
	}

}