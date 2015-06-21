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
import dto.EmpleadoDTO;

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
public class AltaEmpleado extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelId;
	private JLabel jLabelNombre;
	private JTextField jTextFieldApellido;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator1;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldId;
	private JLabel jLabelApellido;

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
				AltaEmpleado inst = new AltaEmpleado();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AltaEmpleado() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta Empleado");
			{
				jLabelId = new JLabel();
				getContentPane().add(jLabelId);
				jLabelId.setText("Id:");
				jLabelId.setBounds(24, 25, 47, 16);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(24, 67, 51, 16);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelApellido = new JLabel();
				getContentPane().add(jLabelApellido);
				jLabelApellido.setText("Apellido:");
				jLabelApellido.setBounds(24, 109, 57, 16);
				jLabelApellido.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jTextFieldId = new JTextField();
				getContentPane().add(jTextFieldId);
				jTextFieldId.setBounds(93, 19, 114, 28);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(93, 61, 230, 28);
			}
			{
				jTextFieldApellido = new JTextField();
				getContentPane().add(jTextFieldApellido);
				jTextFieldApellido.setBounds(93, 104, 230, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-7, 147, 391, 11);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(75, 164, 86, 33);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						EmpleadoDTO empleado = new EmpleadoDTO();
						empleado.setId(Integer.parseInt(jTextFieldId.getText()));
						empleado.setNombre(jTextFieldNombre.getText());
						empleado.setApellido(jTextFieldNombre.getText());
						Sistema.getInstancia().altaEmpleado(empleado);
						jTextFieldId.setText("");
						jTextFieldNombre.setText("");
						jTextFieldApellido.setText("");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(218, 165, 85, 33);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

			}
			pack();
			this.setSize(400, 249);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
