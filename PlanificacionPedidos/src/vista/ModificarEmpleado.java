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
public class ModificarEmpleado extends javax.swing.JFrame {
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
	private JLabel jLabelSeleccionar;
	private List<EmpleadoDTO> empleados;
	private EmpleadoDTO empleado;
	private JComboBox<String> comboEmpleado;

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
				ModificarEmpleado inst = new ModificarEmpleado();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ModificarEmpleado() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Modificar Empleado");
			{
				jLabelId = new JLabel();
				getContentPane().add(jLabelId);
				jLabelId.setText("Id:");
				jLabelId.setBounds(36, 81, 47, 16);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelSeleccionar = new JLabel();
				getContentPane().add(jLabelSeleccionar);
				jLabelSeleccionar.setText("Seleccionar un empleado:");
				jLabelSeleccionar.setBounds(110, 11, 161, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(33, 115, 51, 16);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelApellido = new JLabel();
				getContentPane().add(jLabelApellido);
				jLabelApellido.setText("Apellido:");
				jLabelApellido.setBounds(33, 149, 57, 16);
				jLabelApellido.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				comboEmpleado = new JComboBox<String>();
				getContentPane().add(comboEmpleado);
				comboEmpleado.setBounds(59, 34, 254, 26);

				empleados = Sistema.getInstancia().listarEmpleados();
				for (int i = 0; i < empleados.size(); i++)
					comboEmpleado.addItem(empleados.get(i).getApellido());

				comboEmpleado.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < empleados.size(); i++)
							if (comboEmpleado.getSelectedItem().toString().equals(empleados.get(i).getApellido())) {
								empleado = empleados.get(i);
								jTextFieldId.setText(empleado.getId() + "");
								jTextFieldNombre.setText(empleado.getNombre());
								jTextFieldApellido.setText(empleado.getApellido());

							}
					}
				});

			}

			{
				jTextFieldId = new JTextField();
				getContentPane().add(jTextFieldId);
				jTextFieldId.setBounds(104, 74, 114, 28);
				jTextFieldId.setEnabled(false);
				jTextFieldId.setEditable(false);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(104, 108, 230, 28);
			}
			{
				jTextFieldApellido = new JTextField();
				getContentPane().add(jTextFieldApellido);
				jTextFieldApellido.setBounds(104, 144, 230, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 189, 391, 11);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(75, 200, 86, 33);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						empleado.setNombre(jTextFieldNombre.getText());
						empleado.setApellido(jTextFieldNombre.getText());
						Sistema.getInstancia().modificarEmpleado(empleado);
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
				jButtonSalir.setBounds(218, 200, 85, 33);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

			}
			pack();
			this.setSize(400, 286);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
