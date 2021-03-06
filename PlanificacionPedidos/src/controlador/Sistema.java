package controlador;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import dto.ClienteDTO;
import dto.ComplejidadPedidoDTO;
import dto.EmpleadoDTO;
import dto.PedidoDTO;
import dto.TipoPedidoDTO;
import negocio.AdmCliente;
import negocio.AdmComplejidadPedido;
import negocio.AdmDisponibilidad;
import negocio.AdmEmpleado;
import negocio.AdmPedido;
import negocio.AdmTipoPedido;
import entities.Cliente;
import entities.ComplejidadPedido;
import entities.Disponibilidad;
import entities.Empleado;
import entities.Pedido;
import entities.TipoPedido;

public class Sistema {

	private static Sistema instancia;

	public static Sistema getInstancia() {
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}

	/*
	 * BUSQUEDAS
	 */

	public Empleado buscarEmpleado(int id) {
		return AdmEmpleado.getInstancia().buscarEmpleado(id);
	}

	public Cliente buscarCliente(int cuit) {
		return AdmCliente.getInstancia().buscarCliente(cuit);
	}

	public ComplejidadPedido buscarComplejidadPedido(String complejidad) {
		return AdmComplejidadPedido.getInstancia().buscarComplejidadPedido(complejidad);
	}

	public TipoPedido buscarTipoPedido(String tipoPedido) {
		return AdmTipoPedido.getInstancia().buscarTipoPedido(tipoPedido);
	}

	/*
	 * GESTION DE PEDIDOS
	 */

	public void altaPedido(PedidoDTO p) {
		AdmPedido.getInstancia().altaPedido(p);
	}
	
	public void programarPedido(Pedido pedido, Empleado empleado) throws ParseException {
		AdmPedido.getInstancia().programarPedido(pedido, empleado);
	}
	
	public void finalizarPedido(Pedido p) throws ParseException {
		AdmPedido.getInstancia().finalizarPedido(p);
	}

	public void liberarDisponibilidadPedido(Pedido pedido) throws ParseException {
		AdmDisponibilidad.getInstancia().liberarDisponibilidadPedido(pedido);
	}

	public List<Pedido> getPedidos(String estado) {
		return AdmPedido.getInstancia().getPedidos(estado);
	}

	public List<TipoPedido> getTiposDePedido() {
		return AdmTipoPedido.getInstancia().getTiposDePedido();
	}

	public String sumarRestarDiasFecha(Date fechaEntrega, int dias) throws ParseException {
		return AdmPedido.getInstancia().sumarRestarDiasFecha(fechaEntrega, dias);
	}

	public List<Empleado> getEmpleadosCapacitadosYDisponibles(Pedido pedido) throws ParseException {
		return AdmPedido.getInstancia().getEmpleadosCapacitadosYDisponibles(pedido);
	}

	/*
	 * REPORTES
	 */

	public String[][] reporteResueltosPorEmpleado() {
		return AdmPedido.getInstancia().getPedidosResueltosPorEmpleado();
	}

	public String[][] reportePedidosPorEstado(String estado) {
		return AdmPedido.getInstancia().reportePedidosPorEstado(estado);
	}

	public Double reporteCumplimientoFechas() {
		return AdmPedido.getInstancia().getPorcentajeDeCumplimientoFechaDeEntrega();
	}

	/*
	 * GESTION DE CLIENTES
	 */

	public void altaCliente(ClienteDTO cliente) {
		AdmCliente.getInstancia().AltaCliente(cliente);
	}

	public void modificarCliente(ClienteDTO cliente) {
		AdmCliente.getInstancia().ModificarCliente(cliente);
	}

	public List<ClienteDTO> listarClientes() {
		return AdmCliente.getInstancia().listarClientes();
	}

	public void eliminarCliente(ClienteDTO cliente) {
		AdmCliente.getInstancia().eliminarCliente(cliente);
	}

	/*
	 * EMPLEADOS
	 */
	public List<EmpleadoDTO> listarEmpleados() {
		return AdmEmpleado.getInstancia().listarEmpleados();
	}

	public void altaEmpleado(EmpleadoDTO empleado) {
		AdmEmpleado.getInstancia().AltaEmpleado(empleado);
	}

	public void modificarEmpleado(EmpleadoDTO empleado) {
		AdmEmpleado.getInstancia().ModificarEmpleado(empleado);
	}

	public void eliminarEmpleado(EmpleadoDTO empleado) {
		AdmEmpleado.getInstancia().eliminarEmpleado(empleado);
	}

	public List<Empleado> getEmpleadosCapacitados(TipoPedido tipo, ComplejidadPedido complejidad) {
		return AdmEmpleado.getInstancia().getEmpleadosCapacitados(tipo, complejidad);
	}

	public List<EmpleadoDTO> getEmpleadosCapacitadosDTO(TipoPedido tipo, ComplejidadPedido complejidad) {
		return AdmEmpleado.getInstancia().getEmpleadosCapacitadosDTO(tipo, complejidad);
	}
	
	public void agregarLicencia(Empleado empleado,Disponibilidad disponibilidad) {
		AdmEmpleado.getInstancia().agregarLicencia(empleado,disponibilidad);
	}
	
	public List<Empleado> getEmpleados() {
		return AdmEmpleado.getInstancia().getEmpleados();
	}
	
	

	/*
	 * COMPLEJIDAD PEDIDO
	 */

	public List<ComplejidadPedidoDTO> listarComplejidades() {
		return AdmComplejidadPedido.getInstancia().listarComplejidades();
	}

	public void altaComplejidadPedidoo(ComplejidadPedidoDTO c) {
		AdmComplejidadPedido.getInstancia().AltaComplejidadPedido(c);
	}

	public void modificarComplejidadPedido(ComplejidadPedidoDTO complejidad) {
		AdmComplejidadPedido.getInstancia().ModificarComplejidadPedido(complejidad);
	}

	public void eliminarComplejidadPedido(ComplejidadPedidoDTO complejidad) {
		AdmComplejidadPedido.getInstancia().eliminarComplejidadPedido(complejidad);
	}

	public List<ComplejidadPedido> getComplejidadesPedido() {
		return AdmComplejidadPedido.getInstancia().getComplejidadesPedido();
	}

	/*
	 * TIPO PEDIDO
	 */
	public void altaTipoPedidoo(TipoPedidoDTO c) {
		AdmTipoPedido.getInstancia().AltaTipoPedido(c);
	}

	public void modificarTipoPedido(TipoPedidoDTO Tipo) {
		AdmTipoPedido.getInstancia().ModificarTipoPedido(Tipo);
	}

	public void eliminarTipoPedido(TipoPedidoDTO Tipo) {
		AdmTipoPedido.getInstancia().eliminarTipoPedido(Tipo);
	}

	public List<TipoPedidoDTO> listarTiposPedido() {
		return AdmTipoPedido.getInstancia().getTiposDePedidoDTO();
	}

}
