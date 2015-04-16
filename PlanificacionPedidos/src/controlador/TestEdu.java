package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.EmpleadoDAO;
import entities.Calendario;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;
import entities.TipoPedido;

public class TestEdu {

	public static void main(String[] args) {
		new TestEdu();
	}

	public TestEdu() {
		iniciar();
	}

	private void iniciar() {
		
		Sistema sistema = new Sistema();

		List<Pedido> pedidos = sistema.getPedidos("Pendiente");

		System.out.println("Pedidos pendientes: \n");
		for (Pedido p : pedidos)
			System.out.println(p.getId() + "  " + p.getDescripcion());
		
		
		List<ReportePedidosPorEmpleado> reportes;

		reportes = sistema.reporteCantidadDePedidosResueltosPorEmpleado();
		
		System.out.println("Reporte pedidos Resuelto: \n");
		for (ReportePedidosPorEmpleado r : reportes)
			System.out.println(r.getId() + "  " + r.getNombre() + "  " + r.getApellido() + "  " + r.getCantidad());
		
		
		Double cumplimientoEntrega = sistema.reportePorcentajeDeCumplimientoFechaDeEntrega();
		System.out.println("Porcentaje de cumplimiento: " + cumplimientoEntrega);
		
		
		TipoPedido tipo = new TipoPedido();
		ComplejidadPedido complejidad = new ComplejidadPedido();
		tipo.setDescripcion("WPO");
		complejidad.setNombre("Intermedia");
		List<Empleado> empleadosCapacitados = EmpleadoDAO.getInstancia().getEmpleadosCapacitados(tipo, complejidad); 
		System.out.println("Empleados capacitados: \n");
		for (Empleado e : empleadosCapacitados)
			System.out.println(e.getId() + "  " + e.getNombre() + "  " + e.getApellido());
		
		/*
		List<Calendario> calendario = sistema.getCalendario();
		System.out.println("---- CALENDARIO 2015 ----\n");
		for (Calendario c : calendario)
			System.out.println(c.getId() + "  " + c.getFecha());
		*/
	}

}
