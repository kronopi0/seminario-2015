package controlador;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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

private static Sistema instancia;

	public static Sistema getInstancia(){
		if(instancia == null)
			instancia = new Sistema();
		return instancia;
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
		
		//duracion en dias
		float dur = (pedido.getTipoPedido().getCantDias()*pedido.getComplejidad().getFactorTiempo());
		int duracion = 0;
		if(dur>(int)dur){
			duracion = (int)dur+1;
		}else{
			duracion = (int)dur;
		}
		String mensaje = "";
		mensaje = "duracion: "+duracion;
		JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		
		//listado de id de empleados que cumplen complejidad
		
		List<Empleado> empleadosCapacitados = EmpleadoDAO.getInstancia().getEmpleadosCapacitados(tipo, complejidad);
		for(int i=0;i<empleadosCapacitados.size();i++){
			mensaje = "id: "+empleadosCapacitados.get(i).getId()+"  Nombre: "+empleadosCapacitados.get(i).getNombre()+"  Apellido: "+empleadosCapacitados.get(i).getApellido();
			JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//Cantidad de dias habiles entre fechaSolicitud y fechaEntregaEsperada
		
		int diasHabiles=CalendarioDAO.getInstancia().getDiasHabiles(pedido);
		mensaje = "dias habiles: "+diasHabiles;
		JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		
		//Por normas de la empresa no pueden tener un caso mas de 2 empleados
		
		//Si fechaEntrega-fechaPedido<=duracion busco empleado que tenga libre esa fecha, termino el pedido con ese empleado y pongo sus fechas ocupadas
		//Si fechaEntrega-fechaPedido>duracion busco 2 empleados y que tengan estas fechas libres, termino el pedido con ese empleado y pongo sus fechas ocupadas
		
		
		
		/*if (empleadosCapacitados != null) {
			pedido.setComplejidad(complejidad);
			pedido.setTipoPedido(tipo);
			pedido.setEmpleado(empleadosCapacitados.get(0));
			PedidoDAO.getInstancia().programarPedido(pedido);
		}*/
		
		/*String men = "";
		men = "LLego aca: ";
		JOptionPane.showMessageDialog(null, men, "OK", JOptionPane.INFORMATION_MESSAGE);*/
	}

	public List<Cliente> getClientes() {
		return ClienteDAO.getInstancia().getClientes();
	}
	
	//Clientes
	
	public void altaCliente(Cliente cliente) {
		ClienteDAO.getInstancia().grabarCliente(cliente);
	}
}
