package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import negocio.AdmEmpleado;
import controlador.Sistema;
import dto.EmpleadoDTO;
import entities.Disponibilidad;
import entities.Empleado;

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
public class EmpleadoLicencia extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelFechaDesde;
	private JLabel jLabelFechaHasta;
	private JSeparator jSeparator1;
	private JTextField jTextFieldFechaHasta;
	private JTextField jTextFieldFechaDesde;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private EmpleadoLicencia instancia;
	private List<Empleado> empleados;
	private Empleado empleado;
	private JComboBox<String> comboEmpleado;
	private JLabel jLabelSeleccionar;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public EmpleadoLicencia(JTabbedPane p) {
		super();
		panel = p;
		instancia = this;
		initGUI();

	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(676, 295));
			this.setLayout(null);
			{
				jLabelFechaDesde = new JLabel();
				this.add(jLabelFechaDesde);
				jLabelFechaDesde.setText("Fecha Desde :");
				jLabelFechaDesde.setBounds(185, 88, 103, 38);
				jLabelFechaDesde.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelFechaHasta = new JLabel();
				this.add(jLabelFechaHasta);
				jLabelFechaHasta.setText("Fecha Hasta :");
				jLabelFechaHasta.setBounds(185, 130, 103, 38);
				jLabelFechaHasta.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				comboEmpleado = new JComboBox<String>();
				this.add(comboEmpleado);
				comboEmpleado.setBounds(212, 38, 254, 26);

				empleados = Sistema.getInstancia().getEmpleados();
				for (int i = 0; i < empleados.size(); i++)
					comboEmpleado.addItem(empleados.get(i).getApellido());

				comboEmpleado.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < empleados.size(); i++)
							if (comboEmpleado.getSelectedItem().toString().equals(empleados.get(i).getApellido())) {
								empleado = empleados.get(i);
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
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(-14, 201, 700, 11);
			}
			{
				jButtonConfirmar = new JButton();
				jButtonConfirmar.setLayout(null);
				this.add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(185, 228, 91, 40);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonConfirmar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent evt) {				
						Disponibilidad disponibilidad = new Disponibilidad();
						disponibilidad.setCantidadDias(1);
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						try {
							disponibilidad.setFechaInicio(formatter.parse(jTextFieldFechaDesde.getText()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							disponibilidad.setFechaFin(formatter.parse(jTextFieldFechaHasta.getText()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						Sistema.getInstancia().agregarLicencia(empleado, disponibilidad);
						JOptionPane.showMessageDialog(null, "Licencia Cargada.");

						empleados.clear();
						comboEmpleado.removeAllItems();
						empleados.addAll(Sistema.getInstancia().getEmpleados());
						for (int i = 0; i < empleados.size(); i++)
							comboEmpleado.addItem(empleados.get(i).getNombre());
					}
					
				});
			}
			{
				jButtonSalir = new JButton();
				this.add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(396, 228, 91, 40);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonSalir.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						panel.remove(instancia);
					}
				});

			}
			{
				jTextFieldFechaDesde = new JTextField();
				this.add(jTextFieldFechaDesde);
				jTextFieldFechaDesde.setText("dd/MM/aaaa");
				jTextFieldFechaDesde.setBounds(314, 96, 230, 23);
			}
			{
				jTextFieldFechaHasta = new JTextField();
				this.add(jTextFieldFechaHasta);
				jTextFieldFechaHasta.setText("dd/MM/aaaa");
				jTextFieldFechaHasta.setBounds(314, 138, 230, 24);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
