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
public class EmpleadoBaja extends javax.swing.JPanel {
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
	private EmpleadoBaja instancia;
	private List<EmpleadoDTO> empleados;
	private EmpleadoDTO empleado;
	private JComboBox<String> comboEmpleado;
	private JLabel jLabelSeleccionar;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public EmpleadoBaja(JTabbedPane p) {
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
				jLabelId.setBounds(185, 88, 75, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelNombre = new JLabel();
				this.add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(185, 130, 75, 38);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				comboEmpleado = new JComboBox<String>();
				this.add(comboEmpleado);
				comboEmpleado.setBounds(212, 38, 254, 26);

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
				jLabelSeleccionar = new JLabel();
				this.add(jLabelSeleccionar);
				jLabelSeleccionar.setText("Seleccionar un empleado:");
				jLabelSeleccionar.setBounds(258, 15, 161, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelApellido = new JLabel();
				this.add(jLabelApellido);
				jLabelApellido.setText("Apellido :");
				jLabelApellido.setBounds(185, 173, 75, 38);
				jLabelApellido.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(314, 92, 230, 28);
				jTextFieldId.setEditable(false);
				jTextFieldId.setEnabled(false);
			}
			{
				jTextFieldNombre = new JTextField();
				this.add(jTextFieldNombre);
				jTextFieldNombre.setBounds(314, 134, 230, 28);
				jTextFieldNombre.setEditable(false);
				jTextFieldNombre.setEnabled(false);
			}
			{
				jTextFieldApellido = new JTextField();
				this.add(jTextFieldApellido);
				jTextFieldApellido.setBounds(314, 177, 230, 28);
				jTextFieldApellido.setEditable(false);
				jTextFieldApellido.setEnabled(false);
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
						empleado.setNombre(jTextFieldNombre.getText());
						empleado.setApellido(jTextFieldNombre.getText());
						Sistema.getInstancia().eliminarEmpleado(empleado);
						jTextFieldId.setText("");
						jTextFieldNombre.setText("");
						jTextFieldApellido.setText("");

						empleados.clear();
						comboEmpleado.removeAllItems();
						empleados = Sistema.getInstancia().listarEmpleados();
						for (int i = 0; i < empleados.size(); i++)
							comboEmpleado.addItem(empleados.get(i).getNombre());
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
