package controlador;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import dao.CalendarioDAO;
import dao.ClienteDAO;
import dao.DisponibilidadDAO;
import dao.EmpleadoDAO;
import dao.PedidoDAO;
import entities.Calendario;
import entities.Cliente;
import entities.ComplejidadPedido;
import entities.Disponibilidad;
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
		Empleado empleadoSeleccionado;
		
		
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
				
		//Cantidad de dias habiles entre fechaSolicitud y fechaEntregaEsperada
		
		Integer diasHabiles=CalendarioDAO.getInstancia().getDiasHabiles(pedido);
		//System.out.println("Disponibilidad generada: ");
		//System.out.println("Fecha Inicio: " + disp.getFechaInicio() + " Fecha Fin: " + disp.getFechaFin());
		mensaje = "dias habiles: "+diasHabiles;
		JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		
		//Por normas de la empresa el pedido no puede tener un caso mas de 1 empleado
		
		//Si hay empleados capacitados
		int i=0;
		if (i<empleadosCapacitados.size()){
			//Si duración<=días habiles
			if(duracion<=diasHabiles){
				//busco empleados libres en rango de fechas de empleadosCapacitados
				int disponible=1;
				int idDisponible=0;
				for(int j=0; j<empleadosCapacitados.size(); j++){
					List<Disponibilidad> disponibilidadPorEmpleadoCapacitado = empleadosCapacitados.get(j).getDisponibilidades();

					mensaje = "id: "+empleadosCapacitados.get(j).getId()+"  Nombre: "+empleadosCapacitados.get(j).getNombre();
					JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					if(0<disponibilidadPorEmpleadoCapacitado.size()){
						for(int k=0;k<disponibilidadPorEmpleadoCapacitado.size();k++){
							//caso1
							if((disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio()==pedido.getFechaSolicitud())&&(disponibilidadPorEmpleadoCapacitado.get(k).getFechaFin()==pedido.getFechaEntrega())){
								disponible=0;
							}
							//caso2
							if((disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio().before(pedido.getFechaSolicitud()))&&(pedido.getFechaSolicitud().before(disponibilidadPorEmpleadoCapacitado.get(k).getFechaFin()))){
								disponible=0;
							}
							//caso3
							if((pedido.getFechaSolicitud().before(disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio()))&&(disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio().before(pedido.getFechaEntrega()))){
								disponible=0;
							}
							//caso4
							if((disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio().before(pedido.getFechaSolicitud()))&&(pedido.getFechaSolicitud().before(disponibilidadPorEmpleadoCapacitado.get(k).getFechaFin()))){
								disponible=0;
							}
						}
					}else{
						//Si no hay registros en disponibilidad
						disponible=1;
						idDisponible = empleadosCapacitados.get(j).getId();
					}
					
					if(disponible==1){
						idDisponible = empleadosCapacitados.get(j).getId();
						mensaje = "Disponible Final (1 ok) = "+disponible;
						JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						mensaje = "Agrego Empleado = "+idDisponible;
						JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						
						//Programar Pedido
						empleadoSeleccionado = EmpleadoDAO.getInstancia().buscarEmpleado(idDisponible);
						/*pedido.setEmpleado(empleadoSeleccionado);
						PedidoDAO.getInstancia().actualizarPedido(pedido);*/
						
						//Agregar Disponibilidad
						
						Disponibilidad disp = new Disponibilidad();
						disp.setFechaInicio(pedido.getFechaSolicitud());
						disp.setFechaFin(pedido.getFechaEntrega());
						disp.setCantidadDias(diasHabiles);
						
						empleadoSeleccionado.agregarDisponibilidad(disp);
						
						EmpleadoDAO.getInstancia().ModificarEmpleado(empleadoSeleccionado);

						j=empleadosCapacitados.size();
						JOptionPane.showMessageDialog(null, "Pedido programado.");
					}else{
						disponible=1;
					}

				}
				//Si todos los empleados capacitados estan ocupados
				if(idDisponible==0){
					mensaje = "No hay empleados Disponibles para este pedido";
					JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}else{
				//Si los días habiles es mejor a la cantidad de días necesarios
				mensaje = "La Fecha de Entrega debe ser "+(duracion-diasHabiles)+" día/s habile/s más de la Fecha de Entrega pactada";
				JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			//Si no hay empleados que cumplen con la Condición de Tipo de Pedido y/o Complejidad 
			mensaje = "No hay empleados que cumplan con la Condición de Tipo de Pedido y/o Complejidad ";
			JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public List<Cliente> getClientes() {
		return ClienteDAO.getInstancia().getClientes();
	}
	
	//Clientes
	
	public void altaCliente(Cliente cliente) {
		ClienteDAO.getInstancia().grabarCliente(cliente);
	}
}
