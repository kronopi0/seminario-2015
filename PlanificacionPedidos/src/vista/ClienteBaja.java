package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import controlador.Sistema;
import dto.ClienteDTO;

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
public class ClienteBaja extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldCuit;
	private JLabel jLabelEmail;
	private JLabel jLabelTelefono;
	private JLabel jLabelCuit;
	private JLabel jLabelNombre;
	private JLabel jLabelPais;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldPais;
	private JLabel jLabelDireccion;
	private JTextField jTextFieldTelefono;
	private JTextField jTextFieldDireccion;
	private JTextField jTextFieldEmail;
	private JSeparator jSeparator1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private ClienteBaja instancia;
	private JLabel jLabelSeleccionar;
	private JComboBox<String> comboCliente;
	private List<ClienteDTO> clientes;
	private ClienteDTO cliente;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public ClienteBaja(JTabbedPane p) {
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
				jLabelCuit = new JLabel();
				this.add(jLabelCuit);
				jLabelCuit.setText("Cuit :");
				jLabelCuit.setBounds(184, 72, 75, 38);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				comboCliente = new JComboBox<String>();
				this.add(comboCliente);
				comboCliente.setBounds(201, 35, 254, 26);

				clientes = Sistema.getInstancia().listarClientes();
				for (int i = 0; i < clientes.size(); i++)
					comboCliente.addItem(clientes.get(i).getNombre());

				comboCliente.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < clientes.size(); i++)
							if (comboCliente.getSelectedItem().toString().equals(clientes.get(i).getNombre())) {
								cliente = clientes.get(i);
								jTextFieldCuit.setText(cliente.getCuit() + "");
								jTextFieldDireccion.setText(cliente.getDireccion());
								jTextFieldEmail.setText(cliente.getEmail());
								jTextFieldNombre.setText(cliente.getNombre());
								jTextFieldPais.setText(cliente.getPais());
								jTextFieldTelefono.setText(cliente.getTelefono());

							}

					}
				});

			}
			{
				jLabelSeleccionar = new JLabel();
				this.add(jLabelSeleccionar);
				jLabelSeleccionar.setText("Seleccionar un cliente:");
				jLabelSeleccionar.setBounds(252, 10, 166, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelNombre = new JLabel();
				this.add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(184, 108, 75, 38);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelPais = new JLabel();
				this.add(jLabelPais);
				jLabelPais.setText("Pais :");
				jLabelPais.setBounds(184, 144, 75, 38);
				jLabelPais.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelTelefono = new JLabel();
				this.add(jLabelTelefono);
				jLabelTelefono.setText("Teléfono :");
				jLabelTelefono.setBounds(184, 179, 75, 38);
				jLabelTelefono.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelDireccion = new JLabel();
				this.add(jLabelDireccion);
				jLabelDireccion.setText("Dirección :");
				jLabelDireccion.setBounds(184, 212, 75, 38);
				jLabelDireccion.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelEmail = new JLabel();
				this.add(jLabelEmail);
				jLabelEmail.setText("Email :");
				jLabelEmail.setBounds(184, 246, 75, 38);
				jLabelEmail.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldCuit = new JTextField();
				this.add(jTextFieldCuit);
				jTextFieldCuit.setBounds(313, 76, 230, 28);
				jTextFieldCuit.setEnabled(false);
				jTextFieldCuit.setEditable(false);
			}
			{
				jTextFieldNombre = new JTextField();
				this.add(jTextFieldNombre);
				jTextFieldNombre.setBounds(313, 111, 230, 28);
				jTextFieldNombre.setEnabled(false);
				jTextFieldNombre.setEditable(false);
			}
			{
				jTextFieldPais = new JTextField();
				this.add(jTextFieldPais);
				jTextFieldPais.setBounds(313, 146, 230, 28);
				jTextFieldPais.setEnabled(false);
				jTextFieldPais.setEditable(false);
			}
			{
				jTextFieldTelefono = new JTextField();
				this.add(jTextFieldTelefono);
				jTextFieldTelefono.setBounds(313, 181, 230, 28);
				jTextFieldTelefono.setEnabled(false);
				jTextFieldTelefono.setEditable(false);
			}
			{
				jTextFieldDireccion = new JTextField();
				this.add(jTextFieldDireccion);
				jTextFieldDireccion.setBounds(313, 216, 230, 28);
				jTextFieldDireccion.setEnabled(false);
				jTextFieldDireccion.setEditable(false);
			}
			{
				jTextFieldEmail = new JTextField();
				this.add(jTextFieldEmail);
				jTextFieldEmail.setBounds(313, 251, 230, 28);
				jTextFieldEmail.setEnabled(false);
				jTextFieldEmail.setEditable(false);
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
					@Override
					public void actionPerformed(ActionEvent evt) {
						cliente.setCuit(Integer.parseInt(jTextFieldCuit.getText()));
						cliente.setDireccion(jTextFieldDireccion.getText());
						cliente.setEmail(jTextFieldEmail.getText());
						cliente.setNombre(jTextFieldNombre.getText());
						cliente.setPais(jTextFieldPais.getText());
						cliente.setTelefono(jTextFieldTelefono.getText());
						Sistema.getInstancia().eliminarCliente(cliente);
						jTextFieldCuit.setText("");
						jTextFieldDireccion.setText("");
						jTextFieldEmail.setText("");
						jTextFieldNombre.setText("");
						jTextFieldPais.setText("");
						jTextFieldTelefono.setText("");

						clientes.clear();
						comboCliente.removeAllItems();
						clientes.addAll(Sistema.getInstancia().listarClientes());
						for (int i = 0; i < clientes.size(); i++)
							comboCliente.addItem(clientes.get(i).getNombre());
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
