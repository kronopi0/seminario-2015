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
public class EmpleadoAltaP extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldId;
	private JLabel jLabelId;
	private JLabel jLabelNombre;
	private JLabel jLabelApellido;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldApellido;
	private JSeparator jSeparator1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private EmpleadoAltaP instancia;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public EmpleadoAltaP(JTabbedPane p) {
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
				jLabelId = new JLabel();
				this.add(jLabelId);
				jLabelId.setText("Id :");
				jLabelId.setBounds(184, 18, 75, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelNombre = new JLabel();
				this.add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(184, 60, 75, 38);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelApellido = new JLabel();
				this.add(jLabelApellido);
				jLabelApellido.setText("Apellido :");
				jLabelApellido.setBounds(184, 103, 75, 38);
				jLabelApellido.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(313, 22, 230, 28);
			}
			{
				jTextFieldNombre = new JTextField();
				this.add(jTextFieldNombre);
				jTextFieldNombre.setBounds(313, 64, 230, 28);
			}
			{
				jTextFieldApellido = new JTextField();
				this.add(jTextFieldApellido);
				jTextFieldApellido.setBounds(313, 107, 230, 28);
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
						EmpleadoDTO Empleado = new EmpleadoDTO();
						Empleado.setId(Integer.parseInt(jTextFieldId.getText()));
						Empleado.setNombre(jTextFieldNombre.getText());
						Empleado.setApellido(jTextFieldApellido.getText());
						Sistema.getInstancia().altaEmpleado(Empleado);
						jTextFieldId.setText("");
						jTextFieldNombre.setText("");
						jTextFieldApellido.setText("");
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
