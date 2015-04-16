package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class ListarPedidosPorEstado extends javax.swing.JFrame {

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

	private JLabel jLabelCuit;
	private JComboBox<String> comboCliente;
	private JButton jButtonSalir;
	private JSeparator jSeparator2;
	private Sistema sistema;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ListarPedidosPorEstado inst = new ListarPedidosPorEstado();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ListarPedidosPorEstado(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}

	public ListarPedidosPorEstado() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelCuit = new JLabel();
				getContentPane().add(jLabelCuit);
				jLabelCuit.setText("Seleccione un estado de pedidos a listar:");
				jLabelCuit.setBounds(49, 10, 300, 40);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 14));
			}

			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(-16, 94, 400, 10);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(144, 110, 93, 33);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				comboCliente = new JComboBox<String>();
				getContentPane().add(comboCliente);
				comboCliente.setBounds(62, 52, 254, 26);

				String[] estados = { "Pendiente", "Programado", "Finalizado" };
				for (int i = 0; i < estados.length; i++)
					comboCliente.addItem(estados[i]);

				comboCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String eleccion = comboCliente.getSelectedItem().toString();

						List<Pedido> pedidos = sistema.getPedidos(eleccion);

						final Object[][] data = new Object[pedidos.size()][4];

						for (int i = 0; i < pedidos.size(); i++) {

							Pedido p = pedidos.get(i);
							data[i][0] = Integer.toString(p.getId());
							data[i][1] = p.getDescripcion();
							data[i][2] = p.getCliente().getNombre();
							data[i][3] = p.getFechaSolicitud();
						}

						javax.swing.SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								TablaListarPedidos t = new TablaListarPedidos();
								t.main(data);
							}
						});
					}

				});

			}
			pack();
			this.setSize(400, 194);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
