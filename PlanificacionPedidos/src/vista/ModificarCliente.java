package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class ModificarCliente extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCuit;
	private JLabel jLabelNombre;
	private JLabel jLabelEmail;
	private JTextField jTextFieldPais;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator1;
	private JTextField jTextFieldEmail;
	private JTextField jTextFieldDireccion;
	private JTextField jTextFieldTelefono;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldCuit;
	private JLabel jLabelDireccion;
	private JLabel jLabelTelefono;
	private JLabel jLabelPais;
	private JLabel jLabelSeleccionar;
	private List<ClienteDTO> clientes;
	private ClienteDTO cliente;
	private JComboBox<String> comboCliente;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ModificarCliente inst = new ModificarCliente();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ModificarCliente() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificar Cliente");
			{
				jLabelSeleccionar = new JLabel();
				getContentPane().add(jLabelSeleccionar);
				jLabelSeleccionar.setText("Seleccionar un cliente:");
				jLabelSeleccionar.setBounds(123, 13, 140, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelCuit = new JLabel();
				getContentPane().add(jLabelCuit);
				jLabelCuit.setText("Cuit :");
				jLabelCuit.setBounds(29, 78, 47, 16);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(29, 113, 51, 16);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelPais = new JLabel();
				getContentPane().add(jLabelPais);
				jLabelPais.setText("Pais :");
				jLabelPais.setBounds(29, 146, 31, 16);
				jLabelPais.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelTelefono = new JLabel();
				getContentPane().add(jLabelTelefono);
				jLabelTelefono.setText("Teléfono :");
				jLabelTelefono.setBounds(29, 180, 81, 16);
				jLabelTelefono.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelDireccion = new JLabel();
				getContentPane().add(jLabelDireccion);
				jLabelDireccion.setText("Dirección :");
				jLabelDireccion.setBounds(29, 213, 85, 16);
				jLabelDireccion.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelEmail = new JLabel();
				getContentPane().add(jLabelEmail);
				jLabelEmail.setText("Email :");
				jLabelEmail.setBounds(30, 248, 38, 16);
				jLabelEmail.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				comboCliente = new JComboBox<String>();
				getContentPane().add(comboCliente);
				comboCliente.setBounds(61, 34, 254, 26);

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
				jTextFieldCuit = new JTextField();
				getContentPane().add(jTextFieldCuit);
				jTextFieldCuit.setBounds(98, 72, 114, 28);
				jTextFieldCuit.setEnabled(false);
				jTextFieldCuit.setEditable(false);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(98, 107, 230, 28);
			}
			{
				jTextFieldPais = new JTextField();
				getContentPane().add(jTextFieldPais);
				jTextFieldPais.setBounds(98, 140, 230, 28);
			}
			{
				jTextFieldTelefono = new JTextField();
				getContentPane().add(jTextFieldTelefono);
				jTextFieldTelefono.setBounds(99, 174, 230, 28);
			}
			{
				jTextFieldDireccion = new JTextField();
				getContentPane().add(jTextFieldDireccion);
				jTextFieldDireccion.setBounds(99, 207, 229, 28);
			}
			{
				jTextFieldEmail = new JTextField();
				getContentPane().add(jTextFieldEmail);
				jTextFieldEmail.setBounds(99, 241, 230, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-7, 277, 391, 11);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(67, 285, 86, 33);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						cliente.setCuit(Integer.parseInt(jTextFieldCuit.getText()));
						cliente.setDireccion(jTextFieldDireccion.getText());
						cliente.setEmail(jTextFieldEmail.getText());
						cliente.setNombre(jTextFieldNombre.getText());
						cliente.setPais(jTextFieldPais.getText());
						cliente.setTelefono(jTextFieldTelefono.getText());
						Sistema.getInstancia().modificarCliente(cliente);
						jTextFieldCuit.setText("");
						jTextFieldDireccion.setText("");
						jTextFieldEmail.setText("");
						jTextFieldNombre.setText("");
						jTextFieldPais.setText("");
						jTextFieldTelefono.setText("");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(227, 286, 85, 33);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

			}
			pack();
			this.setSize(400, 365);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
