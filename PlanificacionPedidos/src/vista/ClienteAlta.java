package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
public class ClienteAlta extends javax.swing.JPanel {
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
	private ClienteAlta instancia;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public ClienteAlta(JTabbedPane p) {
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
				jLabelCuit.setBounds(184, 18, 75, 38);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelNombre = new JLabel();
				this.add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(184, 60, 75, 38);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelPais = new JLabel();
				this.add(jLabelPais);
				jLabelPais.setText("Pais :");
				jLabelPais.setBounds(184, 102, 75, 38);
				jLabelPais.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelTelefono = new JLabel();
				this.add(jLabelTelefono);
				jLabelTelefono.setText("Teléfono :");
				jLabelTelefono.setBounds(184, 144, 75, 38);
				jLabelTelefono.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelDireccion = new JLabel();
				this.add(jLabelDireccion);
				jLabelDireccion.setText("Dirección :");
				jLabelDireccion.setBounds(184, 186, 75, 38);
				jLabelDireccion.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelEmail = new JLabel();
				this.add(jLabelEmail);
				jLabelEmail.setText("Email :");
				jLabelEmail.setBounds(184, 228, 75, 38);
				jLabelEmail.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldCuit = new JTextField();
				this.add(jTextFieldCuit);
				jTextFieldCuit.setBounds(313, 22, 230, 28);
			}
			{
				jTextFieldNombre = new JTextField();
				this.add(jTextFieldNombre);
				jTextFieldNombre.setBounds(313, 64, 230, 28);
			}
			{
				jTextFieldPais = new JTextField();
				this.add(jTextFieldPais);
				jTextFieldPais.setBounds(313, 107, 230, 28);
			}
			{
				jTextFieldTelefono = new JTextField();
				this.add(jTextFieldTelefono);
				jTextFieldTelefono.setBounds(313, 150, 230, 28);
			}
			{
				jTextFieldDireccion = new JTextField();
				this.add(jTextFieldDireccion);
				jTextFieldDireccion.setBounds(313, 193, 230, 28);
			}
			{
				jTextFieldEmail = new JTextField();
				this.add(jTextFieldEmail);
				jTextFieldEmail.setBounds(313, 236, 230, 28);
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
