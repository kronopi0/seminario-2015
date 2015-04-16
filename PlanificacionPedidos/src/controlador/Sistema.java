package controlador;

import java.util.Date;
import java.util.List;

import dao.CalendarioDAO;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import dao.PedidoDAO;
import entities.Calendario;
import entities.Cliente;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;
import entities.TipoPedido;

public class Sistema {

	// private static Sistema instancia;

	public Sistema() {
	}

	/*
	 * public static Sistema getInstancia() { if (instancia == null) instancia =
	 * new Sistema(); return instancia; }
	 */

	/*
	 * LEVANTAR CALENDARIO EN MEMORIA
	 */
	public List<Calendario> getCalendario() {
		return CalendarioDAO.getInstancia().getCalendario();
	}

	/*
	 * BUSQUEDAS
	 */
	public Empleado buscarEmpleado(int id) {
		return EmpleadoDAO.getInstancia().buscarEmpleado(id);
	}

	public Cliente buscarCliente(int cuit) {
		return ClienteDAO.getInstancia().buscarCliente(cuit);
	}

	public ComplejidadPedido buscarComplejidadPedido(String complejidad) {
		return PedidoDAO.getInstancia().buscarComplejidadPedido(complejidad);
	}

	public TipoPedido buscarTipoPedido(String tipoPedido) {
		return PedidoDAO.getInstancia().buscarTipoPedido(tipoPedido);
	}

	/*
	 * GESTION DE PEDIDOS
	 */
	public void altaPedido(Pedido p) {
		PedidoDAO.getInstancia().grabarPedido(p);
	}

	public void finalizarPedido(Pedido p) {
		p.setEstado("Finalizado");
		p.setFechaFinalizado(new Date());
		PedidoDAO.getInstancia().actualizarPedido(p);
	}

	public List<Pedido> getPedidos(String estado) {
		return PedidoDAO.getInstancia().getPedidos(estado);
	}

	public List<TipoPedido> getTipos() {
		return PedidoDAO.getInstancia().getTipos();
	}

	public List<ComplejidadPedido> getComplejidades() {
		return PedidoDAO.getInstancia().getComplejidades();
	}

	/*
	 * REPORTES
	 */
	public Double reportePorcentajeDeCumplimientoFechaDeEntrega() {
		return PedidoDAO.getInstancia().getPorcentajeDeCumplimientoFechaDeEntrega();
	}

	public List<ReportePedidosPorEmpleado> reporteCantidadDePedidosResueltosPorEmpleado() {
		return PedidoDAO.getInstancia().getCantidadDePedidosResueltosPorEmpleado();
	}

	public void programarPedido(Pedido pedido, TipoPedido tipo, ComplejidadPedido complejidad) {
		pedido.setEstado("Programado");
		pedido.setComplejidad(complejidad);
		pedido.setTipoPedido(tipo);
		int duracion = (int) (pedido.getTipoPedido().getCantDias()*pedido.getComplejidad().getFactorTiempo());
		List<Empleado> empleadosCapacitados = EmpleadoDAO.getInstancia().getEmpleadosCapacitados(tipo, complejidad);
		if (empleadosCapacitados != null) {
			pedido.setComplejidad(complejidad);
			pedido.setTipoPedido(tipo);
			pedido.setEmpleado(empleadosCapacitados.get(0));
			PedidoDAO.getInstancia().programarPedido(pedido);
		}
	}

	public List<Cliente> getClientes() {
		return ClienteDAO.getInstancia().getClientes();
	}
}
