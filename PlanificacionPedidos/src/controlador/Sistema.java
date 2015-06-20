package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;

import dao.CalendarioDAO;
import dao.ClienteDAO;
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
		
		//Liberar Empleado si la Fecha de Entrega es mayor a la Fecha de Finalización
		
		if(p.getFechaFinalizado().before(p.getFechaEntrega())) {
			for(Disponibilidad d: p.getEmpleado().getDisponibilidades()) {
				if(d.getFechaFin().compareTo(p.getFechaEntrega()) == 0) {
					d.setFechaFin(p.getFechaFinalizado());
					//Calculo cantidad de días real					
					long diferenciaEn_ms = p.getFechaFinalizado().getTime() - p.getFechaInicio().getTime();
					long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
					d.setCantidadDias((int) dias+1);

					EmpleadoDAO.getInstancia().ModificarEmpleado(p.getEmpleado());
				}
			}		
		}
		
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
	
	 public String sumarRestarDiasFecha(Date fecha, int dias) throws ParseException{
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(fecha);
		 calendar.add(Calendar.DAY_OF_YEAR, dias);
		 int ano = calendar.get(Calendar.YEAR);
	     int mes = calendar.get(Calendar.MONTH)+1;
	     int dia = calendar.get(Calendar.DAY_OF_MONTH);
		 String fechaaux = dia+"/"+mes+"/"+ano;
		 
		 return fechaaux; 
	 }

	public void programarPedido(Pedido pedido, TipoPedido tipo, ComplejidadPedido complejidad) throws ParseException {
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
		
		//Con la fecha de inicio y duracion en dias busco la fecha hasta
		
		Date fechaInicioTarea = pedido.getFechaInicio();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaFinTarea = formatter.parse(Sistema.getInstancia().sumarRestarDiasFecha(pedido.getFechaInicio(), duracion));
		
		//listado de id de empleados que cumplen complejidad
		
		List<Empleado> empleadosCapacitados = EmpleadoDAO.getInstancia().getEmpleadosCapacitados(tipo, complejidad);
				
		//Cantidad de dias habiles entre fechaSolicitud y fechaEntregaEsperada
		
		Integer diasHabiles=CalendarioDAO.getInstancia().getDiasHabiles(pedido);
		
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
					
					if(0<disponibilidadPorEmpleadoCapacitado.size()){
						for(int k=0;k<disponibilidadPorEmpleadoCapacitado.size();k++){
							
							String StrfechaEmpleadoInicio = Sistema.getInstancia().sumarRestarDiasFecha(disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio(), -1);
							String StrfechaEmpleadoFin = Sistema.getInstancia().sumarRestarDiasFecha(disponibilidadPorEmpleadoCapacitado.get(k).getFechaFin(), 1);
							Date fechaEmpleadoInicio = formatter.parse(StrfechaEmpleadoInicio);
							Date fechaEmpleadoFin = formatter.parse(StrfechaEmpleadoFin);	
							
							//caso1
							if((fechaEmpleadoInicio.equals(fechaInicioTarea))&&(fechaEmpleadoFin.equals(fechaFinTarea))){
								disponible=0;
							}
							//caso2
							if((fechaInicioTarea.before(fechaEmpleadoFin))&&(fechaEmpleadoFin.before(fechaFinTarea))){	
								disponible=0;
							}
							//caso3
							if((fechaInicioTarea.before(fechaEmpleadoInicio))&&(fechaEmpleadoInicio.before(fechaFinTarea))){
								disponible=0;
							}
							//caso4
							if((fechaEmpleadoInicio.before(fechaInicioTarea))&&(fechaInicioTarea.before(fechaEmpleadoFin))){
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

						//Programar Pedido
						empleadoSeleccionado = EmpleadoDAO.getInstancia().buscarEmpleado(idDisponible);
						pedido.setEmpleado(empleadoSeleccionado);
						PedidoDAO.getInstancia().actualizarPedido(pedido);
						
						//Agregar Disponibilidad
						Disponibilidad disp = new Disponibilidad();
						disp.setFechaInicio(fechaInicioTarea);
						disp.setFechaFin(fechaFinTarea);
						disp.setCantidadDias(duracion);
						empleadoSeleccionado.agregarDisponibilidad(disp);
						EmpleadoDAO.getInstancia().ModificarEmpleado(empleadoSeleccionado);
						
						mensaje = "Empleado Asignado  id : "+empleadoSeleccionado.getId()+" Nombre : "+empleadoSeleccionado.getNombre()+" Apellido : "+empleadoSeleccionado.getApellido();
						JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
						
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
