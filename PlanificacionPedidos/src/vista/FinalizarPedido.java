package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.joda.time.DateTime;

import controlador.Sistema;
import entities.Pedido;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FinalizarPedido extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JComboBox<String> jComboBoxPedidosSinFinalizar;
	private JButton jButtonFinalizarPedido;
	private JButton jButtonSalir;
	private JLabel jLabelPedidosPendientes;
	private Sistema sistema;
	private JButton botonDetalles;
	private JSeparator jSeparator1;
	private Pedido pedido;
	private List<Pedido> pedidos;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FinalizarPedido inst = new FinalizarPedido();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public FinalizarPedido(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}

	public FinalizarPedido() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Finalizar Pedido");
			{

				jComboBoxPedidosSinFinalizar = new JComboBox<String>();
				getContentPane().add(jComboBoxPedidosSinFinalizar);
				jComboBoxPedidosSinFinalizar.setBounds(71, 44, 260, 27);

				pedidos = sistema.getPedidos("Programado");
				System.out.println(pedidos.get(0).getDescripcion());
				for (int i = 0; i < pedidos.size(); i++)
					jComboBoxPedidosSinFinalizar.addItem(pedidos.get(i).getDescripcion());

				pedido = pedidos.get(0);

				jComboBoxPedidosSinFinalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < pedidos.size(); i++)
							if (jComboBoxPedidosSinFinalizar.getSelectedItem().toString().equals(pedidos.get(i).getDescripcion()))
								pedido = pedidos.get(i);

					}
				});
			}
			{
				jLabelPedidosPendientes = new JLabel();
				getContentPane().add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("Pedidos pendientes de finalización:");
				jLabelPedidosPendientes.setBounds(81, 15, 243, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 14));
			}
			{
				jButtonFinalizarPedido = new JButton();
				getContentPane().add(jButtonFinalizarPedido);
				jButtonFinalizarPedido.setText("Finalizar Pedido");
				jButtonFinalizarPedido.setBounds(55, 145, 120, 35);
				jButtonFinalizarPedido.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonFinalizarPedido.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonFinalizarPedido.actionPerformed, event=" + evt);
						sistema.finalizarPedido(pedido);
						JOptionPane.showMessageDialog(null, "Pedido finalizado.");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(226, 146, 107, 34);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 131, 394, 10);
			}
			{
				botonDetalles = new JButton();
				getContentPane().add(botonDetalles);
				botonDetalles.setText("Detalles");
				botonDetalles.setBounds(152, 84, 94, 30);
				botonDetalles.setFont(new java.awt.Font("SansSerif", 1, 12));
				botonDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonDetalles.actionPerformed, event=" + evt);

						DateTime solicitud = new DateTime(pedido.getFechaSolicitud());
						DateTime entrega = new DateTime(pedido.getFechaEntrega());

						String a = pedido.getDescripcion() + "\n\n";
						String b = "Id pedido:  " + pedido.getId() + "\n";
						String c;
						if (pedido.getPeriodicidad() == 0)
							c = "Periodicidad:  No aplica\n\n";
						else
							c = "Periodicidad:  " + pedido.getPeriodicidad() + " días\n\n";
						String d = "Cliente:  " + pedido.getCliente().getNombre() + "\n";
						String e = "Fecha de solicitud:  " + Integer.parseInt(solicitud.toString("dd")) + "/" + Integer.parseInt(solicitud.toString("MM")) + "/"
								+ Integer.parseInt(solicitud.toString("YYYY")) + "\n";
						String f = "Fecha de entrega esperada:  " + Integer.parseInt(entrega.toString("dd")) + "/" + Integer.parseInt(entrega.toString("MM")) + "/"
								+ Integer.parseInt(entrega.toString("YYYY")) + "\n";

						JOptionPane.showMessageDialog(null, a + b + c + d + e + f);
					}
				});
			}
			pack();
			this.setSize(410, 236);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
