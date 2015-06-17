package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;
import dao.ClienteDAO;
import entities.Cliente;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AltaCliente extends javax.swing.JFrame {
	private JLabel jLabelCuit;
	private JLabel jLabelNombre;
	private JLabel jLabelEmail;
	private JTextField jTextFieldPais;
	private JButton jButtonSalir;
	private JButton jButtonAgregar;
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
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
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
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(24, 65, 51, 16);
			}
			{
				jLabelPais = new JLabel();
				getContentPane().add(jLabelPais);
				jLabelPais.setText("Pais :");
				jLabelPais.setBounds(24, 105, 31, 16);
			}
			{
				jLabelTelefono = new JLabel();
				getContentPane().add(jLabelTelefono);
				jLabelTelefono.setText("Tel�fono :");
				jLabelTelefono.setBounds(24, 143, 54, 16);
			}
			{
				jLabelDireccion = new JLabel();
				getContentPane().add(jLabelDireccion);
				jLabelDireccion.setText("Direcci�n :");
				jLabelDireccion.setBounds(24, 183, 58, 16);
			}
			{
				jLabelEmail = new JLabel();
				getContentPane().add(jLabelEmail);
				jLabelEmail.setText("Email :");
				jLabelEmail.setBounds(24, 223, 38, 16);
			}
			{
				jTextFieldCuit = new JTextField();
				getContentPane().add(jTextFieldCuit);
				jTextFieldCuit.setBounds(93, 19, 110, 28);
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
				jSeparator1.setBounds(-7, 265, 391, 11);
			}
			{
				jButtonAgregar = new JButton();
				getContentPane().add(jButtonAgregar);
				jButtonAgregar.setText("Agregar");
				jButtonAgregar.setBounds(62, 282, 71, 28);
				jButtonAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						Cliente cliente = new Cliente();
						cliente.setCuit(Integer.parseInt(jTextFieldCuit.getText()));
						cliente.setDireccion(jTextFieldDireccion.getText());
						cliente.setEmail(jTextFieldEmail.getText());
						cliente.setNombre(jTextFieldNombre.getText());
						cliente.setPais(jTextFieldPais.getText());
						cliente.setTelefono(jTextFieldTelefono.getText());
						ClienteDAO.getInstancia().grabarCliente(cliente);
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
				jButtonSalir.setBounds(236, 282, 80, 28);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
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
