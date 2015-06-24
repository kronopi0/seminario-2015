package negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import dao.PedidoDAO;
import dto.PedidoDTO;
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
		if (instancia == null)
			instancia = new AdmPedido();
		return instancia;
	}

	private AdmPedido() {
		dao = PedidoDAO.getInstancia();
	}

	public List<Pedido> getPedidos(String estado) {
		return dao.getPedidos(estado);
	}

	public void finalizarPedido(Pedido p) throws ParseException {
		p.setEstado("Finalizado");
		p.setFechaFinalizado(new Date());

		// Liberar Empleado si la Fecha de Entrega es mayor a la Fecha de
		// Finalización
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String StrfechaFinalizado = this.sumarRestarDiasFecha(p.getFechaFinalizado(), 0);
		Date fechaFinalizado = formatter.parse(StrfechaFinalizado);
		// duracion en dias
		float dur = (p.getTipoPedido().getTiempo() * p.getComplejidad().getFactorTiempo());
		int duracion = 0;
		if (dur > (int) dur) {
			duracion = (int) dur + 1;
		} else {
			duracion = (int) dur;
		}
		Date fechaFinTarea = formatter.parse(this.sumarRestarDiasFecha(p.getFechaInicio(), duracion));

		if (fechaFinalizado.before(fechaFinTarea)) {
			for (Disponibilidad d : p.getEmpleado().getDisponibilidades()) {
				if (d.getFechaFin().compareTo(fechaFinTarea) == 0) {
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

		// duracion en dias
		float dur = (pedido.getTipoPedido().getTiempo() * pedido.getComplejidad().getFactorTiempo());
		System.out.println("DURACION: " + dur);
		int duracion = 0;
		if (dur > (int) dur) {
			duracion = (int) dur + 1;
		} else {
			duracion = (int) dur;
		}
		String mensaje = "";

		// Con la fecha de inicio y duracion en dias busco la fecha hasta
		Date fechaInicioTarea = pedido.getFechaInicio();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaFinTarea = formatter.parse(this.sumarRestarDiasFecha(pedido.getFechaInicio(), duracion));

		// listado de id de empleados que cumplen complejidad
		List<Empleado> empleadosCapacitados = AdmEmpleado.getInstancia().getEmpleadosCapacitados(tipo, complejidad);

		// Cantidad de dias habiles entre fechaSolicitud y fechaEntregaEsperada
		Integer diasHabiles = dao.getCantidadDiasHabiles(pedido);

		// Por normas de la empresa el pedido no puede tener un caso mas de 1
		// empleado
		// Si hay empleados capacitados
		int i = 0;
		if (i < empleadosCapacitados.size()) {
			// Si duración<=días habiles
			if (duracion <= diasHabiles) {
				// busco empleados libres en rango de fechas de
				// empleadosCapacitados
				int disponible = 1;
				int idDisponible = 0;
				for (int j = 0; j < empleadosCapacitados.size(); j++) {
					List<Disponibilidad> disponibilidadPorEmpleadoCapacitado = empleadosCapacitados.get(j).getDisponibilidades();

					if (0 < disponibilidadPorEmpleadoCapacitado.size()) {
						for (int k = 0; k < disponibilidadPorEmpleadoCapacitado.size(); k++) {

							String StrfechaEmpleadoInicio = this.sumarRestarDiasFecha(disponibilidadPorEmpleadoCapacitado.get(k).getFechaInicio(), -1);
							String StrfechaEmpleadoFin = this.sumarRestarDiasFecha(disponibilidadPorEmpleadoCapacitado.get(k).getFechaFin(), 1);
							Date fechaEmpleadoInicio = formatter.parse(StrfechaEmpleadoInicio);
							Date fechaEmpleadoFin = formatter.parse(StrfechaEmpleadoFin);

							// caso1
							if ((fechaEmpleadoInicio.equals(fechaInicioTarea)) && (fechaEmpleadoFin.equals(fechaFinTarea))) {
								disponible = 0;
							}
							// caso2
							if ((fechaInicioTarea.before(fechaEmpleadoFin)) && (fechaEmpleadoFin.before(fechaFinTarea))) {
								disponible = 0;
							}
							// caso3
							if ((fechaInicioTarea.before(fechaEmpleadoInicio)) && (fechaEmpleadoInicio.before(fechaFinTarea))) {
								disponible = 0;
							}
							// caso4
							if ((fechaInicioTarea.before(fechaEmpleadoInicio)) && (fechaEmpleadoFin.before(fechaInicioTarea))) {
								disponible = 0;
							}
							// caso5
							if ((fechaEmpleadoInicio.before(fechaInicioTarea)) && (fechaInicioTarea.before(fechaEmpleadoFin))) {
								disponible = 0;
							}
						}
					} else {
						// Si no hay registros en disponibilidad
						disponible = 1;
						idDisponible = empleadosCapacitados.get(j).getId();
					}

					if (disponible == 1) {
						idDisponible = empleadosCapacitados.get(j).getId();

						// Programar Pedido
						empleadoSeleccionado = AdmEmpleado.getInstancia().buscarEmpleado(idDisponible);
						pedido.setEmpleado(empleadoSeleccionado);
						dao.actualizarPedido(pedido);

						// Agregar Disponibilidad
						Disponibilidad disp = new Disponibilidad();
						disp.setFechaInicio(fechaInicioTarea);
						disp.setFechaFin(fechaFinTarea);
						disp.setCantidadDias(duracion);
						empleadoSeleccionado.agregarDisponibilidad(disp);
						AdmEmpleado.getInstancia().actualizarEmpleado(empleadoSeleccionado);

						mensaje = "Empleado Asignado  id : " + empleadoSeleccionado.getId() + " Nombre : " + empleadoSeleccionado.getNombre() + " Apellido : "
								+ empleadoSeleccionado.getApellido();
						JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);

						j = empleadosCapacitados.size();
						JOptionPane.showMessageDialog(null, "Pedido programado.");
					} else {
						disponible = 1;
					}

				}
				// Si todos los empleados capacitados estan ocupados
				if (idDisponible == 0) {
					mensaje = "No hay empleados Disponibles para este pedido";
					JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);

				}

			} else {
				// Si los días habiles es mejor a la cantidad de días necesarios
				mensaje = "La Fecha de Entrega debe ser " + (duracion - diasHabiles) + " día/s habile/s más de la Fecha de Entrega pactada";
				JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			// Si no hay empleados que cumplen con la Condición de Tipo de
			// Pedido y/o Complejidad
			mensaje = "No hay empleados que cumplan con la Condición de Tipo de Pedido y/o Complejidad ";
			JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public String sumarRestarDiasFecha(Date fecha, int dias) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH) + 1;
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		String fechaaux = dia + "/" + mes + "/" + ano;

		return fechaaux;
	}

	public List<Empleado> getEmpleadosCapacitadosYDisponibles(Pedido pedido) throws ParseException {
		List<Empleado> empleadosCapacitadosYDisponibles = new ArrayList<Empleado>();

		// Calculo la duración total en días que demanda el pedido
		int duracion = Math.round(pedido.getTipoPedido().getTiempo() * pedido.getComplejidad().getFactorTiempo());
		System.out.println("DURACION TOTAL: " + duracion);

		// Con la fecha de inicio del pedido junto con su duración en días
		// calculo la fecha fin
		Date fechaInicioTarea = pedido.getFechaInicio();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaFinTarea = formatter.parse(this.sumarRestarDiasFecha(pedido.getFechaInicio(), duracion));

		// Obtengo los empleados que están capacitados para realizar el pedido
		List<Empleado> empleadosCapacitados = AdmEmpleado.getInstancia().getEmpleadosCapacitados(pedido.getTipoPedido(), pedido.getComplejidad());

		// Obtengo la cantidad de días hábiles entre la fecha de inicio y la
		// fecha de entrega del pedido
		Integer diasHabiles = dao.getCantidadDiasHabiles(pedido);

		// Si hay empleados capacitados
		if (empleadosCapacitados.size() > 0) {
			// Compruebo que la duración del pedido no exceda a la cantidad de
			// días hábiles disponibles hasta
			// la fecha de entrega
			if (duracion <= diasHabiles) {
				// Para cada empleado verifico si está disponible dentro del
				// rango fecha inicio y fecha fin del pedido
				for (Empleado e : empleadosCapacitados) {
					int disponible = 1;
					List<Disponibilidad> disponibilidadesDelEmpleadoCapacitado = e.getDisponibilidades();
					// Si el empleado tiene disponibilidades dadas de alta
					if (disponibilidadesDelEmpleadoCapacitado.size() > 0) {
						for (Disponibilidad d : disponibilidadesDelEmpleadoCapacitado) {

							String StrfechaEmpleadoInicio = this.sumarRestarDiasFecha(d.getFechaInicio(), -1);
							String StrfechaEmpleadoFin = this.sumarRestarDiasFecha(d.getFechaFin(), 1);
							Date fechaEmpleadoInicio = formatter.parse(StrfechaEmpleadoInicio);
							Date fechaEmpleadoFin = formatter.parse(StrfechaEmpleadoFin);

							// caso1
							if ((fechaEmpleadoInicio.equals(fechaInicioTarea)) && (fechaEmpleadoFin.equals(fechaFinTarea)))
								disponible = 0;

							// caso2
							if ((fechaInicioTarea.before(fechaEmpleadoFin)) && (fechaEmpleadoFin.before(fechaFinTarea)))
								disponible = 0;

							// caso3
							if ((fechaInicioTarea.before(fechaEmpleadoInicio)) && (fechaEmpleadoInicio.before(fechaFinTarea)))
								disponible = 0;

							// caso4
							if ((fechaEmpleadoInicio.before(fechaInicioTarea)) && (fechaInicioTarea.before(fechaEmpleadoFin)))
								disponible = 0;
						}
					}
					if (disponible == 1)
						empleadosCapacitadosYDisponibles.add(e);
				}
			}

		}

		return empleadosCapacitadosYDisponibles;

	}

	public void programarPedido(Pedido pedido, Empleado empleado) throws ParseException {
		// Calculo la duración total en días que demanda el pedido
		int duracion = Math.round(pedido.getTipoPedido().getTiempo() * pedido.getComplejidad().getFactorTiempo());
		String mensaje = "";

		// Con la fecha de inicio del pedido junto con su duración en días
		// calculo la fecha fin
		Date fechaInicioTarea = pedido.getFechaInicio();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaFinTarea = formatter.parse(this.sumarRestarDiasFecha(pedido.getFechaInicio(), duracion));

		// Programo el pedido
		pedido.setEstado("Programado");
		pedido.setEmpleado(empleado);
		dao.actualizarPedido(pedido);

		// Genero la disponibilidad y se la cargo al empleado
		Disponibilidad disp = new Disponibilidad();
		disp.setFechaInicio(fechaInicioTarea);
		disp.setFechaFin(fechaFinTarea);
		disp.setCantidadDias(duracion);
		empleado.agregarDisponibilidad(disp);
		AdmEmpleado.getInstancia().actualizarEmpleado(empleado);

		mensaje = "Empleado Asignado  id : " + empleado.getId() + " Nombre : " + empleado.getNombre() + " Apellido : " + empleado.getApellido();
		JOptionPane.showMessageDialog(null, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Pedido programado.");

	}

	public void altaPedido(PedidoDTO p) {
		dao.guardarPedido(toEntity(p));

	}

	private Pedido toEntity(PedidoDTO dto) {
		Pedido entity = new Pedido();

		entity.setDescripcion(dto.getDescripcion());
		entity.setPeriodicidad(dto.getPeriodicidad());
		entity.setFechaSolicitud(dto.getFechaSolicitud());
		entity.setFechaInicio(dto.getFechaInicio());
		entity.setFechaFinalizado(dto.getFechaFinalizado());
		entity.setFechaEntrega(dto.getFechaEntrega());
		entity.setEstado(dto.getEstado());

		if (dto.getEmpleado() == null)
			entity.setEmpleado(null);
		else
			entity.setEmpleado(AdmEmpleado.getInstancia().toEntity(dto.getEmpleado()));

		if (dto.getComplejidad() == null)
			entity.setComplejidad(null);
		else
			entity.setComplejidad(AdmComplejidadPedido.getInstancia().toEntity(dto.getComplejidad()));

		entity.setCliente(AdmCliente.getInstancia().toEntity(dto.getCliente()));

		if (dto.getTipoPedido() == null)
			entity.setTipoPedido(null);
		else
			entity.setTipoPedido(AdmTipoPedido.getInstancia().toEntity(dto.getTipoPedido()));

		return entity;

	}

	/*
	 * REPORTES
	 */

	public Double getPorcentajeDeCumplimientoFechaDeEntrega() {
		return dao.getPorcentajeDeCumplimientoFechaDeEntrega();
	}

	public String[][] getPedidosResueltosPorEmpleado() {
		List<ReportePedidosPorEmpleado> lista = dao.getReportesResueltosPorEmpleadoDTO();
		String[][] data = new String[lista.size()][4];

		for (int i = 0; i < lista.size(); i++) {
			data[i][0] = lista.get(i).getId() + "";
			data[i][1] = lista.get(i).getNombre();
			data[i][2] = lista.get(i).getApellido();
			data[i][3] = lista.get(i).getCantidad() + "";
		}
		return data;
	}

	public String[][] reportePedidosPorEstado(String estado) {

		List<Pedido> pedidos = getPedidos(estado);
		String[][] data = new String[pedidos.size()][4];

		for (int i = 0; i < pedidos.size(); i++) {
			Pedido p = pedidos.get(i);
			data[i][0] = Integer.toString(p.getId());
			data[i][1] = p.getDescripcion();
			data[i][2] = p.getCliente().getNombre();
			data[i][3] = p.getFechaSolicitud() + "";
		}
		return data;
	}

}
