package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.Calendario;
import entities.Empleado;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;

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
		
		/*
		List<Calendario> calendario = sistema.getCalendario();
		System.out.println("---- CALENDARIO 2015 ----\n");
		for (Calendario c : calendario)
			System.out.println(c.getId() + "  " + c.getFecha());
		*/
	}

}
