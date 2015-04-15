package controlador;

import java.util.List;

import entities.Pedido;

public class Test {

	public static void main(String[] args) {
		new Test();
	}

	public Test() {
		iniciar();
	}

	private void iniciar() {
		Sistema sistema = new Sistema();

		List<Pedido> pedidos = sistema.getPedidos("Pendiente");

		System.out.println("Pedidos pendientes: \n");
		for (Pedido p : pedidos)
			System.out.println(p.getId() + "  " + p.getDescripcion());
	}

}
