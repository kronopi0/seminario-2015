package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
public class AltaCliente extends javax.swing.JFrame {
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
				AltaCliente inst = new AltaCliente();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AltaCliente() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta Cliente");
			{
				jLabelCuit = new JLabel();
				getContentPane().add(jLabelCuit);
				jLabelCuit.setText("Cuit :");
				jLabelCuit.setBounds(24, 25, 47, 16);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(24, 65, 51, 16);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelPais = new JLabel();
				getContentPane().add(jLabelPais);
				jLabelPais.setText("Pais :");
				jLabelPais.setBounds(24, 105, 31, 16);
				jLabelPais.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelTelefono = new JLabel();
				getContentPane().add(jLabelTelefono);
				jLabelTelefono.setText("Teléfono :");
				jLabelTelefono.setBounds(24, 143, 81, 16);
				jLabelTelefono.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelDireccion = new JLabel();
				getContentPane().add(jLabelDireccion);
				jLabelDireccion.setText("Dirección :");
				jLabelDireccion.setBounds(24, 183, 85, 16);
				jLabelDireccion.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelEmail = new JLabel();
				getContentPane().add(jLabelEmail);
				jLabelEmail.setText("Email :");
				jLabelEmail.setBounds(24, 223, 38, 16);
				jLabelEmail.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jTextFieldCuit = new JTextField();
				getContentPane().add(jTextFieldCuit);
				jTextFieldCuit.setBounds(93, 19, 114, 28);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(93, 59, 230, 28);
			}
			{
				jTextFieldPais = new JTextField();
				getContentPane().add(jTextFieldPais);
				jTextFieldPais.setBounds(93, 99, 230, 28);
			}
			{
				jTextFieldTelefono = new JTextField();
				getContentPane().add(jTextFieldTelefono);
				jTextFieldTelefono.setBounds(93, 137, 230, 28);
			}
			{
				jTextFieldDireccion = new JTextField();
				getContentPane().add(jTextFieldDireccion);
				jTextFieldDireccion.setBounds(94, 177, 229, 28);
			}
			{
				jTextFieldEmail = new JTextField();
				getContentPane().add(jTextFieldEmail);
				jTextFieldEmail.setBounds(94, 217, 230, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-7, 263, 391, 11);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(66, 280, 86, 33);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						ClienteDTO cliente = new ClienteDTO();
						cliente.setCuit(Integer.parseInt(jTextFieldCuit.getText()));
						cliente.setDireccion(jTextFieldDireccion.getText());
						cliente.setEmail(jTextFieldEmail.getText());
						cliente.setNombre(jTextFieldNombre.getText());
						cliente.setPais(jTextFieldPais.getText());
						cliente.setTelefono(jTextFieldTelefono.getText());
						Sistema.getInstancia().altaCliente(cliente);
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
				jButtonSalir.setBounds(228, 280, 85, 33);
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
