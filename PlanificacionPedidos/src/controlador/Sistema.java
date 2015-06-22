package controlador;

import java.text.ParseException;
import java.util.List;

import dto.ClienteDTO;
import dto.ComplejidadPedidoDTO;
import dto.EmpleadoDTO;
import dto.PedidoDTO;
import negocio.AdmCliente;
import negocio.AdmComplejidadPedido;
import negocio.AdmEmpleado;
import negocio.AdmPedido;
import negocio.AdmTipoPedido;
import entities.Cliente;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;
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

	public void programarPedido(Pedido pedido, TipoPedido tipo, ComplejidadPedido complejidad) throws ParseException {
		AdmPedido.getInstancia().programarPedido(pedido, tipo, complejidad);
	}

	public void finalizarPedido(Pedido p) throws ParseException {
		AdmPedido.getInstancia().finalizarPedido(p);
	}

	public List<Pedido> getPedidos(String estado) {
		return AdmPedido.getInstancia().getPedidos(estado);
	}

	public List<TipoPedido> getTiposgetTiposDePedido() {
		return AdmTipoPedido.getInstancia().getTiposDePedido();
	}

	public List<ComplejidadPedido> getComplejidades() {
		return AdmComplejidadPedido.getInstancia().getComplejidadesPedido();
	}

	/*
	 * REPORTES
	 */

	public Double reportePorcentajeDeCumplimientoFechaDeEntrega() {
		return AdmPedido.getInstancia().getPorcentajeDeCumplimientoFechaDeEntrega();
	}

	public List<ReportePedidosPorEmpleado> reporteCantidadDePedidosResueltosPorEmpleado() {
		return AdmPedido.getInstancia().getCantidadDePedidosResueltosPorEmpleado();
	}

	public String[][] reportePedidosPorEstado(String estado) {
		return AdmPedido.getInstancia().reportePedidosPorEstado(estado);
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

	/*
	 * COMPLEJIDAD PEDIDO
	 */

	public void altaComplejidadPedidoo(ComplejidadPedidoDTO c) {
		AdmComplejidadPedido.getInstancia().AltaComplejidadPedido(c);
	}

	public List<ComplejidadPedidoDTO> listarComplejidades() {
		return AdmComplejidadPedido.getInstancia().listarComplejidades();
	}

	public void modificarComplejidadPedido(ComplejidadPedidoDTO complejidad) {
		AdmComplejidadPedido.getInstancia().ModificarComplejidadPedido(complejidad);
	}

	public void eliminarComplejidadPedido(ComplejidadPedidoDTO complejidad) {
		AdmComplejidadPedido.getInstancia().eliminarComplejidadPedido(complejidad);
	}

}
