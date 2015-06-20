package controlador;

import java.text.ParseException;
import java.util.List;

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

	public static Sistema getInstancia(){
		if(instancia == null)
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
	
	public void altaPedido(Pedido p) {
		AdmPedido.getInstancia().guardarPedido(p);
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
	
	
	/*
	 * GESTION DE CLIENTES
	 */
	
	public void altaCliente(Cliente cliente) {
		AdmCliente.getInstancia().guardarCliente(cliente);
	}
	
}
