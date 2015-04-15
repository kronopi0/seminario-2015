package controlador;

import java.util.List;
import dao.ClienteDAO;
import dao.ComplejidadPedidoDAO;
import dao.EmpleadoDAO;
import dao.PedidoDAO;
import dao.TipoPedidoDAO;
import entities.Cliente;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.Pedido;
import entities.PedidoProgramado;
import entities.TipoPedido;

public class Sistema {

	private static Sistema instancia;

	public Sistema() {
	}
	
	public static Sistema getInstancia() {
		if(instancia == null)
			instancia = new Sistema();
		return instancia;
	}
	
	/*
		BUSQUEDAS
	*/
	public Empleado buscarEmpleado(int id) {
		return EmpleadoDAO.getInstancia().buscarEmpleado(id);
	}
	
	public Cliente buscarCliente(int cuit) {
		return ClienteDAO.getInstancia().buscarCliente(cuit);
	}
	
	public ComplejidadPedido buscarComplejidadPedido(String complejidad) {
		return ComplejidadPedidoDAO.getInstancia().buscarComplejidadPedido(complejidad);
	}
	
	public TipoPedido buscarTipoPedido(String tipoPedido) {
		return TipoPedidoDAO.getInstancia().buscarTipoPedido(tipoPedido);
	}
	

	/*
		GESTION DE PEDIDOS
	*/
	public void altaPedido(Pedido p) {
		PedidoDAO.getInstancia().grabarPedido(p);
	}
	
	public void finalizarPedido(Pedido p) {
		PedidoDAO.getInstancia().actualizarPedido(p);
	}
	
	public List<Pedido> getPedidosPendientes() {
		return PedidoDAO.getInstancia().getPedidosPendientes();
	}
	
	
	/*
		REPORTES
	*/
	public float reportePorcentajeDeCumplimientoFechaDeEntrega() {
		return PedidoDAO.getInstancia().getPorcentajeDeCumplimientoFechaDeEntrega();
	}
	
	public List<Pedido> reporteCantidadDePedidosResueltosPorEmpleado(Empleado e) {
		return PedidoDAO.getInstancia().getCantidadDePedidosResueltosPorEmpleado(e);
	}
	
	public PedidoProgramado programarPedido(Pedido p) {
		return null;
	}
	
}
