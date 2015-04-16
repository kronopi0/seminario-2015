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
import entities.ComplejidadPedido;
import entities.Pedido;
import entities.TipoPedido;

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
public class ProgramarPedidos extends javax.swing.JFrame {

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
	private JComboBox<String> comboComplejidad;
	private JComboBox<String> comboTipo;
	private JSeparator jSeparator2;
	private JButton botonDetalles;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JSeparator jSeparator1;
	private Pedido pedido;
	private List<Pedido> pedidos;
	private TipoPedido tipo;
	private List<TipoPedido> tipos;
	private ComplejidadPedido complejidad;
	private List<ComplejidadPedido> complejidades;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ProgramarPedidos inst = new ProgramarPedidos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ProgramarPedidos(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}

	public ProgramarPedidos() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Programar Pedido");
			{

				jComboBoxPedidosSinFinalizar = new JComboBox<String>();
				getContentPane().add(jComboBoxPedidosSinFinalizar);
				jComboBoxPedidosSinFinalizar.setBounds(71, 41, 260, 27);

				pedidos = sistema.getPedidos("Pendiente");
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
				jLabelPedidosPendientes.setText("Pedidos pendientes a programar:");
				jLabelPedidosPendientes.setBounds(86, 15, 243, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 14));
			}
			{
				jButtonFinalizarPedido = new JButton();
				getContentPane().add(jButtonFinalizarPedido);
				jButtonFinalizarPedido.setText("Programar Pedido");
				jButtonFinalizarPedido.setBounds(48, 283, 133, 35);
				jButtonFinalizarPedido.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonFinalizarPedido.setEnabled(false);
				jButtonFinalizarPedido.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonOK.actionPerformed, event=" + evt);
						sistema.programarPedido(pedido, tipo, complejidad);
						JOptionPane.showMessageDialog(null, "Pedido programado.");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(224, 285, 107, 34);
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
				jSeparator1.setBounds(0, 121, 394, 10);
			}
			{
				botonDetalles = new JButton();
				getContentPane().add(botonDetalles);
				botonDetalles.setText("Detalles");
				botonDetalles.setBounds(152, 78, 94, 30);
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
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 271, 394, 10);
			}
			{
				comboTipo = new JComboBox<String>();
				getContentPane().add(comboTipo);
				comboTipo.setBounds(88, 159, 216, 26);

				tipos = sistema.getTipos();

				for (int i = 0; i < tipos.size(); i++) {
					comboTipo.addItem((tipos.get(i).getDescripcion()));
				}

				comboTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboTipo.actionPerformed, event=" + evt);

						for (int i = 0; i < tipos.size(); i++)
							if (comboTipo.getSelectedItem().toString().equals(tipos.get(i).getDescripcion()))
								tipo = tipos.get(i);
					}
				});

			}

			{
				comboComplejidad = new JComboBox<String>();
				getContentPane().add(comboComplejidad);
				comboComplejidad.setBounds(89, 227, 216, 26);

				complejidades = sistema.getComplejidades();

				for (int i = 0; i < complejidades.size(); i++) {
					comboComplejidad.addItem((complejidades.get(i).getNombre()));
				}

				comboComplejidad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboComplejidad.actionPerformed, event=" + evt);
						for (int i = 0; i < tipos.size(); i++)
							if (comboComplejidad.getSelectedItem().toString().equals(complejidades.get(i).getNombre()))
								complejidad = complejidades.get(i);
						jButtonFinalizarPedido.setEnabled(true);
					}

				});
				complejidad = complejidades.get(0);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Seleccione tipo de pedido:");
				jLabel1.setBounds(118, 137, 162, 16);
				jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Seleccionar complejidad:");
				jLabel2.setBounds(121, 206, 159, 16);
				jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			pack();
			this.setSize(410, 366);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
