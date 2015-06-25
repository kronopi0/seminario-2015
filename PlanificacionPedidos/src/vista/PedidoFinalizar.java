package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
public class PedidoFinalizar extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldCliente;
	private JLabel jLabelEmpleado;
	private JLabel jLabelCliente;
	private JLabel jLabelFechaSolicitud;
	private JTextField jTextFieldFechaSolicitud;
	private JLabel jLabelId;
	private JTextField jTextFieldEmpleado;
	private JTextField jTextFieldId;
	private JSeparator jSeparator1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private PedidoFinalizar instancia;
	private JComboBox<String> comboProgramados;
	private JLabel jLabelPedidosPendientes;
	private Pedido pedido;
	private List<Pedido> pedidos;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public PedidoFinalizar(JTabbedPane p) {
		super();
		panel = p;
		instancia = this;
		initGUI();

	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(676, 360));
			this.setLayout(null);
			{
				jLabelCliente = new JLabel();
				this.add(jLabelCliente);
				jLabelCliente.setText("Cliente:");
				jLabelCliente.setBounds(176, 153, 75, 38);
				jLabelCliente.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelPedidosPendientes = new JLabel();
				this.add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("Seleccionar pedido pendientes de finalización:");
				jLabelPedidosPendientes.setBounds(189, 12, 298, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 13));
			}
			{
				comboProgramados = new JComboBox<String>();
				this.add(comboProgramados);
				comboProgramados.setBounds(205, 38, 254, 26);

				pedidos = Sistema.getInstancia().getPedidos("programado");
				for (int i = 0; i < pedidos.size(); i++)
					comboProgramados.addItem(pedidos.get(i).getDescripcion());

				comboProgramados.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < pedidos.size(); i++)
							if (comboProgramados.getSelectedItem().toString().equals(pedidos.get(i).getDescripcion()))
								pedido = pedidos.get(i);

						jTextFieldId.setText(pedido.getId() + "");
						jTextFieldFechaSolicitud.setText(pedido.getFechaSolicitud() + "");
						jTextFieldCliente.setText(pedido.getCliente().getNombre());
						if (pedido.getEmpleado() != null)
							jTextFieldEmpleado.setText(pedido.getEmpleado().getNombre() + " " + pedido.getEmpleado().getApellido());
					}
				});

			}
			{
				jLabelFechaSolicitud = new JLabel();
				this.add(jLabelFechaSolicitud);
				jLabelFechaSolicitud.setText("Fecha de solicitud:");
				jLabelFechaSolicitud.setBounds(175, 119, 129, 38);
				jLabelFechaSolicitud.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelEmpleado = new JLabel();
				this.add(jLabelEmpleado);
				jLabelEmpleado.setText("Empleado:");
				jLabelEmpleado.setBounds(176, 188, 75, 38);
				jLabelEmpleado.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelId = new JLabel();
				this.add(jLabelId);
				jLabelId.setText("Id pedido:");
				jLabelId.setBounds(175, 85, 75, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldCliente = new JTextField();
				this.add(jTextFieldCliente);
				jTextFieldCliente.setBounds(313, 159, 230, 28);
				jTextFieldCliente.setEnabled(false);
				jTextFieldCliente.setEditable(false);
			}
			{
				jTextFieldFechaSolicitud = new JTextField();
				this.add(jTextFieldFechaSolicitud);
				jTextFieldFechaSolicitud.setBounds(313, 124, 230, 28);
				jTextFieldFechaSolicitud.setEditable(false);
				jTextFieldFechaSolicitud.setEnabled(false);
			}
			{
				jTextFieldEmpleado = new JTextField();
				this.add(jTextFieldEmpleado);
				jTextFieldEmpleado.setBounds(313, 194, 230, 28);
				jTextFieldEmpleado.setEditable(false);
				jTextFieldEmpleado.setEnabled(false);
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(313, 90, 230, 28);
				jTextFieldId.setEditable(false);
				jTextFieldId.setEnabled(false);
			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}
			{
				jButtonConfirmar = new JButton();
				jButtonConfirmar.setLayout(null);
				this.add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(183, 304, 91, 40);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonConfirmar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {
						try {
							Sistema.getInstancia().finalizarPedido(pedido);
							jTextFieldId.setText("");
							jTextFieldFechaSolicitud.setText("");
							jTextFieldCliente.setText("");
							jTextFieldEmpleado.setText("");
							pedidos.clear();
							comboProgramados.removeAllItems();
							pedidos = Sistema.getInstancia().getPedidos("programado");
							for (int i = 0; i < pedidos.size(); i++)
								comboProgramados.addItem(pedidos.get(i).getDescripcion());

							JOptionPane.showMessageDialog(null, "Pedido finalizado.");

						} catch (ParseException e) {
							e.printStackTrace();
						}

					}
				});
			}
			{
				jButtonSalir = new JButton();
				this.add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(396, 304, 91, 40);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonSalir.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						panel.remove(instancia);
					}
				});

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
