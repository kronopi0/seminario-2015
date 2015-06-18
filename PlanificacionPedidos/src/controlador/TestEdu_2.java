package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.EmpleadoDAO;
import entities.Calendario;
import entities.Disponibilidad;
import entities.Empleado;
import entities.Pedido;

public class TestEdu_2 {

	public static void main(String[] args) {
		new TestEdu_2();
	}

	public TestEdu_2() {
		iniciar();
	}

	private void iniciar() {
		Sistema sistema = new Sistema();
		/*
		List<Pedido> pedidos = sistema.getPedidos("Pendiente");

		System.out.println("Pedidos pendientes: \n");
		for (Pedido p : pedidos)
			System.out.println(p.getId() + "  " + p.getDescripcion());
		
		
		pedidos=null;
		
		Empleado e = sistema.buscarEmpleado(136378);
		pedidos = sistema.reporteCantidadDePedidosResueltosPorEmpleado(e);
		
		System.out.println("Reporte pedidos Resuelto: \n");
		for (Pedido p : pedidos)
			System.out.println(p.getId() + "  " + p.getDescripcion());
		
		
		List<Calendario> calendario = sistema.getCalendario();
		System.out.println("---- CALENDARIO 2015 ----\n");
		for (Calendario c : calendario)
			System.out.println(c.getId() + "  " + c.getFecha());
		*/
		
		Empleado e = new Empleado();
		e.setApellido("Pereyra");
		e.setNombre("Pepe");
		e.setId(500);

		Disponibilidad d = new Disponibilidad();
		d.setCantidadDias(4);
		d.setFechaFin(new Date());
		d.setFechaInicio(new Date());
		//d.setIdDisponibilidad(1);
		
		e.disponibilidades = new ArrayList<Disponibilidad>();
		e.agregarDisponibilidad(d);
		
		EmpleadoDAO.getInstancia().grabarEmpleado(e);
		
	}

}
