package negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.PedidoDAO;
import entities.ComplejidadPedido;
import entities.Disponibilidad;
import entities.Empleado;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;
import entities.TipoPedido;

public class AdmPedido {

	private static AdmPedido instancia;
	private static PedidoDAO dao;
	
	public static AdmPedido getInstancia() {
		if(instancia==null)
			instancia=new AdmPedido();
		return instancia;
	}
	
	private AdmPedido() {
		dao = PedidoDAO.getInstancia();
	}
	
	public void guardarPedido(Pedido p) {
		dao.guardarPedido(p);
	}

	public List<Pedido> getPedidos(String estado) {
		return dao.getPedidos(estado);
	}
	
	public void finalizarPedido(Pedido p) throws ParseException {
		p.setEstado("Finalizado");
		p.setFechaFinalizado(new Date());
		
		//Liberar Empleado si la Fecha de Entrega es mayor a la Fecha de Finalizaci�n
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String StrfechaFinalizado = this.sumarRestarDiasFecha(p.getFechaFinalizado(), 0);
		Date fechaFinalizado = formatter.parse(StrfechaFinalizado);
		//duracion en dias
				float dur = (p.getTipoPedido().getCantDias()*p.getComplejidad().getFactorTiempo());
				int duracion = 0;
				if(dur>(int)dur){
					duracion = (int)dur+1;
				}else{
					duracion = (int)dur;
				}
		Date fechaFinTarea = formatter.parse(this.sumarRestarDiasFecha(p.getFechaInicio(), duracion));
		
		if(fechaFinalizado.before(fechaFinTarea)) {
			for(Disponibilidad d: p.getEmpleado().getDisponibilidades()) {
				if(d.getFechaFin().compareTo(fechaFinTarea) == 0) {
					d.setFechaFin(fechaFinalizado);
					AdmEmpleado.getInstancia().actualizarEmpleado(p.getEmpleado());
				}
			}		
		}
		
		dao.actualizarPedido(p);
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
		Date fechaFinTarea = formatter.parse(this.sumarRestarDiasFecha(pedido.getFechaInicio(), duracion));
		
		//listado de id de empleados que cumplen complejidad
		List<Empleado> empleadosCapacitados = AdmEmpleado.getInstancia().getEmpleadosCapacitados(tipo, complejidad);
				
		//Cantidad de dias habiles entre fechaSolicitud y fechaEntregaEsperada
		Integer diasHabiles=dao.getCantidadDiasHabiles(pedido);
		
		//Por normas de la empresa el pedido no puede tener un caso mas de 1 empleado
		//Si hay empleados capacitados
		int i=0;
		if (i<empleadosCapacitados.size()){
			//Si duraci�n<=d�as habiles
			if(duracion<=diasHabiles){
				//busco empleados libres en rango de fechas de empleadosCapacitados
				int disponible=1;
				int idDisponible=0;
				for(int j=0; j<empleadosCapacitados.size(); j++){
					List<Disponibilidad> disponibilidadPorEmpleadoCapacitado = empleadosCapacitados.get(j).getDisponibilidades();
					
					if(0<disponibilidadPorEmpleadoCapacitado.size()){
						for(int k=0;k<disponibilidadPorEmpleadoCapacitado.size();k++){
							
							String StrfechaEmpleadoInicio = this.sumarRestarDiasFecha(disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio(), -1);
							String StrfechaEmpleadoFin = this.sumarRestarDiasFecha(disponibilidadPorEmpleadoCapacitado.get(k).getFechaFin(), 1);
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
						empleadoSeleccionado = AdmEmpleado.getInstancia().buscarEmpleado(idDisponible);
						pedido.setEmpleado(empleadoSeleccionado);
						dao.actualizarPedido(pedido);
						
						//Agregar Disponibilidad
						Disponibilidad disp = new Disponibilidad();
						disp.setFechaInicio(fechaInicioTarea);
						disp.setFechaFin(fechaFinTarea);
						disp.setCantidadDias(duracion);
						empleadoSeleccionado.agregarDisponibilidad(disp);
						AdmEmpleado.getInstancia().actualizarEmpleado(empleadoSeleccionado);
						
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
				//Si los d�as habiles es mejor a la cantidad de d�as necesarios
				mensaje = "La Fecha de Entrega debe ser "+(duracion-diasHabiles)+" d�a/s habile/s m�s de la Fecha de Entrega pactada";
				JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			//Si no hay empleados que cumplen con la Condici�n de Tipo de Pedido y/o Complejidad 
			mensaje = "No hay empleados que cumplan con la Condici�n de Tipo de Pedido y/o Complejidad ";
			JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		}
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

	public Double getPorcentajeDeCumplimientoFechaDeEntrega() {
		return dao.getPorcentajeDeCumplimientoFechaDeEntrega();
	}

	public List<ReportePedidosPorEmpleado> getCantidadDePedidosResueltosPorEmpleado() {
		return dao.getCantidadDePedidosResueltosPorEmpleado();
	}
	 
}