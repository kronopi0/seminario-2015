package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import controlador.Sistema;
import dto.ComplejidadPedidoDTO;
import dto.EmpleadoDTO;
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
public class EmpleadoAsignarComplejidades extends javax.swing.JPanel {
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
	private JLabel jLabelComplejidadesEmpleado;
	private JTable jTable1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private JScrollPane jScrollPane1;
	private EmpleadoAsignarComplejidades instancia;
	private List<EmpleadoDTO> empleados;
	private EmpleadoDTO empleado;
	private List<ComplejidadPedidoDTO> complejidades;
	private ComplejidadPedidoDTO complejidad;
	private JComboBox<String> comboEmpleado;
	private JLabel jLabelSeleccionar;
	private JLabel jLabelComplejidades;
	private TableModel model1;
	private TableModel model2;
	private JTable jTable2;
	private JScrollPane jScrollPane2;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public EmpleadoAsignarComplejidades(JTabbedPane p) {
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
				jLabelId.setBounds(12, 110, 32, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelNombre = new JLabel();
				this.add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(12, 152, 66, 38);
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
				jLabelApellido.setBounds(12, 195, 66, 38);
				jLabelApellido.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(96, 114, 143, 28);
				jTextFieldId.setEditable(false);
				jTextFieldId.setEnabled(false);
			}
			{
				jTextFieldNombre = new JTextField();
				this.add(jTextFieldNombre);
				jTextFieldNombre.setBounds(96, 156, 143, 28);
				jTextFieldNombre.setEditable(false);
				jTextFieldNombre.setEnabled(false);
			}
			{
				jTextFieldApellido = new JTextField();
				this.add(jTextFieldApellido);
				jTextFieldApellido.setBounds(96, 199, 143, 28);
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

					public void actionPerformed(ActionEvent evt) {

						// Sistema.getInstancia().modificarEmpleado(empleado);
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

					public void actionPerformed(ActionEvent e) {
						panel.remove(instancia);
					}
				});

			}
			{
				jLabelComplejidadesEmpleado = new JLabel();
				this.add(jLabelComplejidadesEmpleado);
				jLabelComplejidadesEmpleado.setText("Complejidades permitidas:");
				jLabelComplejidadesEmpleado.setBounds(293, 88, 159, 16);
				jLabelComplejidadesEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12));
			}
			{
				jLabelComplejidades = new JLabel();
				this.add(jLabelComplejidades);
				jLabelComplejidades.setText("Complejidades restantes:");
				jLabelComplejidades.setBounds(487, 88, 159, 16);
				jLabelComplejidades.setFont(new java.awt.Font("Segoe UI", 1, 12));
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(293, 110, 148, 117);
				{

					Object[][] data1 = { { "Late1", true }, { "Late2", true } };
					model1 = new ModeloTablaConCheckBox(data1);
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(model1);
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				this.add(jScrollPane2);
				jScrollPane2.setBounds(487, 111, 139, 116);
				{
					Object[][] data2 = { { "Nola1", false }, { "Nola2", false } };
					model2 = new ModeloTablaConCheckBox(data2);
					jTable2 = new JTable();
					jScrollPane2.setViewportView(jTable2);
					jTable2.setModel(model2);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
