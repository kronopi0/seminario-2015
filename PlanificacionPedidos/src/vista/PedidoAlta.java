package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import controlador.Sistema;
import dto.ClienteDTO;
import dto.PedidoDTO;
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
public class PedidoAlta extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelPeriodicidad;
	private JLabel jLabelDescripcion;
	private JLabel jLabelFechaEntrega;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldFechaEntrega;
	private JTextField jTextFieldPeriodicidad;
	private JSeparator jSeparator1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private PedidoAlta instancia;
	private JLabel jLabelSeleccionar;
	private JComboBox<String> comboCliente;
	private List<ClienteDTO> clientes;
	private ClienteDTO cliente;
	private JLabel jLabelIngresar;
	private JSeparator jSeparator2;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public PedidoAlta(JTabbedPane p) {
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
				comboCliente = new JComboBox<String>();
				this.add(comboCliente);
				comboCliente.setBounds(200, 49, 254, 26);

				clientes = Sistema.getInstancia().listarClientes();
				for (int i = 0; i < clientes.size(); i++)
					comboCliente.addItem(clientes.get(i).getNombre());

				comboCliente.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < clientes.size(); i++)
							if (comboCliente.getSelectedItem().toString().equals(clientes.get(i).getNombre()))
								cliente = clientes.get(i);

					}
				});

			}
			{
				jLabelSeleccionar = new JLabel();
				this.add(jLabelSeleccionar);
				jLabelSeleccionar.setText("1) Seleccionar un cliente:");
				jLabelSeleccionar.setBounds(242, 18, 166, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelIngresar = new JLabel();
				this.add(jLabelIngresar);
				jLabelIngresar.setText("2) Ingresar datos del pedido:");
				jLabelIngresar.setBounds(239, 115, 190, 16);
				jLabelIngresar.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelDescripcion = new JLabel();
				this.add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(173, 149, 106, 38);
				jLabelDescripcion.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelFechaEntrega = new JLabel();
				this.add(jLabelFechaEntrega);
				jLabelFechaEntrega.setText("Fecha de entrega:");
				jLabelFechaEntrega.setBounds(173, 190, 129, 38);
				jLabelFechaEntrega.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelPeriodicidad = new JLabel();
				this.add(jLabelPeriodicidad);
				jLabelPeriodicidad.setText("Periodicidad:");
				jLabelPeriodicidad.setBounds(173, 233, 106, 38);
				jLabelPeriodicidad.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldDescripcion = new JTextField();
				this.add(jTextFieldDescripcion);
				jTextFieldDescripcion.setBounds(313, 151, 230, 28);
			}
			{
				jTextFieldFechaEntrega = new JTextField();
				this.add(jTextFieldFechaEntrega);
				jTextFieldFechaEntrega.setBounds(313, 194, 230, 28);
				jTextFieldFechaEntrega.setText("dd/mm/aaaa");
			}
			{
				jTextFieldPeriodicidad = new JTextField();
				this.add(jTextFieldPeriodicidad);
				jTextFieldPeriodicidad.setBounds(313, 236, 230, 28);
				jTextFieldPeriodicidad.setText("0");
			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}
			{
				jSeparator2 = new JSeparator();
				this.add(jSeparator2);
				jSeparator2.setBounds(-8, 90, 700, 11);
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
						if (jTextFieldFechaEntrega.getText().isEmpty() || jTextFieldPeriodicidad.getText().isEmpty() || jTextFieldDescripcion.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Faltan completar campos.");
						} else {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							PedidoDTO p = new PedidoDTO();
							p.setCliente(cliente);
							p.setDescripcion(jTextFieldDescripcion.getText());
							p.setEstado("Pendiente");
							try {
								p.setFechaEntrega(formatter.parse(jTextFieldFechaEntrega.getText()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							p.setFechaSolicitud(new Date());
							p.setPeriodicidad(Integer.valueOf(jTextFieldPeriodicidad.getText()));
							Sistema.getInstancia().altaPedido(p);
							JOptionPane.showMessageDialog(null, "Pedido cargado.");
							jTextFieldFechaEntrega.setText("dd/mm/aaaa");
							jTextFieldPeriodicidad.setText("");
							jTextFieldDescripcion.setText("");
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
					@Override
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
