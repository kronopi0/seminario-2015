package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;
import entities.Cliente;
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
public class AltaPedido extends javax.swing.JFrame {

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
	private JLabel jLabelFechaDeEntrega;
	private JLabel jLabel1;
	private JComboBox<String> comboCliente;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator2;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldPeriodicidad;
	private JTextField jTextFieldFechaDeEntrega;
	private JLabel jLabelDescripcion;
	private JLabel jLabelPeriodicidad;
	private JSeparator jSeparator1;
	private Sistema sistema;
	private Cliente cliente;
	private List<Cliente> clientes;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaPedido inst = new AltaPedido();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AltaPedido(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}

	public AltaPedido() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta Pedido");
			{
				jLabelCuit = new JLabel();
				getContentPane().add(jLabelCuit);
				jLabelCuit.setText("Seleccionar un cliente:");
				jLabelCuit.setBounds(121, 16, 140, 16);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 12));
			}

			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-10, 82, 418, 10);
			}
			{
				jLabelFechaDeEntrega = new JLabel();
				getContentPane().add(jLabelFechaDeEntrega);
				jLabelFechaDeEntrega.setText("Fecha de Entrega :");
				jLabelFechaDeEntrega.setBounds(15, 178, 110, 16);
				jLabelFechaDeEntrega.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelPeriodicidad = new JLabel();
				getContentPane().add(jLabelPeriodicidad);
				jLabelPeriodicidad.setText("Periodicidad :");
				jLabelPeriodicidad.setBounds(15, 218, 110, 16);
				jLabelPeriodicidad.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(15, 135, 90, 16);
				jLabelDescripcion.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jTextFieldFechaDeEntrega = new JTextField();
				getContentPane().add(jTextFieldFechaDeEntrega);
				jTextFieldFechaDeEntrega.setText("dd/mm/aaaa");
				jTextFieldFechaDeEntrega.setBounds(138, 173, 110, 29);
			}
			{
				jTextFieldPeriodicidad = new JTextField();
				getContentPane().add(jTextFieldPeriodicidad);
				jTextFieldPeriodicidad.setBounds(138, 213, 53, 27);
			}
			{
				jTextFieldDescripcion = new JTextField();
				getContentPane().add(jTextFieldDescripcion);
				jTextFieldDescripcion.setBounds(138, 131, 235, 30);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(-10, 255, 400, 10);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(61, 267, 93, 35);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (jTextFieldFechaDeEntrega.getText().isEmpty() || jTextFieldPeriodicidad.getText().isEmpty() || jTextFieldDescripcion.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Faltan completar campos.");
						} else {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
							Pedido p = new Pedido();
							p.setCliente(cliente);
							p.setDescripcion(jTextFieldDescripcion.getText());
							p.setEstado("Pendiente");
							try {
								p.setFechaEntrega(formatter.parse(jTextFieldFechaDeEntrega.getText()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							p.setFechaSolicitud(new Date());
							p.setPeriodicidad(Integer.valueOf(jTextFieldPeriodicidad.getText()));

							sistema.altaPedido(p);
							JOptionPane.showMessageDialog(null, "Pedido cargado.");
							jTextFieldFechaDeEntrega.setText("dd/mm/aaaa");
							jTextFieldPeriodicidad.setText("");
							jTextFieldDescripcion.setText("");
						}

					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(218, 268, 93, 33);
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
				comboCliente.setBounds(60, 41, 254, 26);

				clientes = sistema.getClientes();
				for (int i = 0; i < clientes.size(); i++)
					comboCliente.addItem(clientes.get(i).getNombre());

				cliente = clientes.get(0);

				comboCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < clientes.size(); i++)
							if (comboCliente.getSelectedItem().toString().equals(clientes.get(i).getNombre()))
								cliente = clientes.get(i);

					}
				});

			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Ingresar datos del pedido:");
				jLabel1.setBounds(111, 95, 165, 16);
				jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			pack();
			this.setSize(400, 352);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
