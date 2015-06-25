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

import controlador.Sistema;
import entities.ComplejidadPedido;
import entities.Empleado;
import entities.Pedido;
import entities.TipoPedido;

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
public class PedidoProgramar extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldCliente;
	private JLabel jLabelCliente;
	private JLabel jLabelFechaSolicitud;
	private JTextField jTextFieldFechaSolicitud;
	private JLabel jLabelId;
	private JTextField jTextFieldId;
	private JSeparator jSeparator1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private PedidoProgramar instancia;
	private JComboBox<String> comboPendientes;
	private JLabel jLabelPedidosPendientes;
	private Pedido pedido;
	private List<Pedido> pedidos;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JComboBox<String> comboComplejidad;
	private JComboBox<String> comboTipo;
	private TipoPedido tipo;
	private List<TipoPedido> tipos;
	private ComplejidadPedido complejidad;
	private List<ComplejidadPedido> complejidades;
	private JLabel jLabel5;
	private JTextField jTextFieldFecha;
	private JLabel jLabelPeriodicidad;
	private JTextField jTextFieldPeriodicidad;
	private JButton jButtonEmpleados;
	private JLabel jLabel10;
	private JComboBox<String> comboEmpleado;
	private List<Empleado> empleados;
	private Empleado empleado;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public PedidoProgramar(JTabbedPane p) {
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
				jLabelCliente = new JLabel();
				this.add(jLabelCliente);
				jLabelCliente.setText("Cliente:");
				jLabelCliente.setBounds(33, 157, 75, 38);
				jLabelCliente.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelPeriodicidad = new JLabel();
				this.add(jLabelPeriodicidad);
				jLabelPeriodicidad.setText("Periodicidad:");
				jLabelPeriodicidad.setBounds(33, 103, 75, 38);
				jLabelPeriodicidad.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelPedidosPendientes = new JLabel();
				this.add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("1) Seleccionar un pedido a programar:");
				jLabelPedidosPendientes.setBounds(39, 16, 248, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 13));
			}
			{
				comboPendientes = new JComboBox<String>();
				this.add(comboPendientes);
				comboPendientes.setBounds(37, 40, 254, 26);

				pedidos = Sistema.getInstancia().getPedidos("pendiente");
				for (int i = 0; i < pedidos.size(); i++)
					comboPendientes.addItem(pedidos.get(i).getDescripcion());

				comboPendientes.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < pedidos.size(); i++)
							if (comboPendientes.getSelectedItem().toString().equals(pedidos.get(i).getDescripcion()))
								pedido = pedidos.get(i);

						jTextFieldId.setText(pedido.getId() + "");
						jTextFieldFechaSolicitud.setText(pedido.getFechaSolicitud() + "");
						jTextFieldCliente.setText(pedido.getCliente().getNombre());
						if (pedido.getPeriodicidad() == 0)
							jTextFieldPeriodicidad.setText("No");
						else
							jTextFieldPeriodicidad.setText(pedido.getPeriodicidad() + "");
					}
				});

			}
			{
				jLabelFechaSolicitud = new JLabel();
				this.add(jLabelFechaSolicitud);
				jLabelFechaSolicitud.setText("Fecha de solicitud:");
				jLabelFechaSolicitud.setBounds(33, 131, 129, 38);
				jLabelFechaSolicitud.setFont(new java.awt.Font("SansSerif", 1, 12));
			}

			{
				jLabelId = new JLabel();
				this.add(jLabelId);
				jLabelId.setText("Id pedido:");
				jLabelId.setBounds(33, 75, 75, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jTextFieldCliente = new JTextField();
				this.add(jTextFieldCliente);
				jTextFieldCliente.setBounds(149, 163, 163, 28);
				jTextFieldCliente.setEnabled(false);
				jTextFieldCliente.setEditable(false);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("2) Seleccionar tipo de pedido:");
				jLabel1.setBounds(80, 207, 179, 16);
				jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("5) Seleccionar empleado:");
				jLabel10.setBounds(438, 205, 154, 16);
				jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("3) Seleccionar complejidad:");
				jLabel2.setBounds(432, 12, 193, 16);
				jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("4) Ingresar fecha de inicio:");
				jLabel5.setBounds(436, 76, 163, 16);
				jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12));
			}

			{
				comboEmpleado = new JComboBox<String>();
				this.add(comboEmpleado);
				comboEmpleado.setBounds(409, 232, 220, 26);
				comboEmpleado.setEnabled(false);
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
				jTextFieldFechaSolicitud = new JTextField();
				this.add(jTextFieldFechaSolicitud);
				jTextFieldFechaSolicitud.setBounds(149, 136, 163, 28);
				jTextFieldFechaSolicitud.setEditable(false);
				jTextFieldFechaSolicitud.setEnabled(false);
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(149, 82, 163, 28);
				jTextFieldId.setEditable(false);
				jTextFieldId.setEnabled(false);
			}
			{
				jTextFieldPeriodicidad = new JTextField();
				this.add(jTextFieldPeriodicidad);
				jTextFieldPeriodicidad.setBounds(149, 109, 163, 28);
				jTextFieldPeriodicidad.setEditable(false);
				jTextFieldPeriodicidad.setEnabled(false);
			}
			{
				jTextFieldFecha = new JTextField();
				this.add(jTextFieldFecha);
				jTextFieldFecha.setBounds(430, 100, 179, 27);
				jTextFieldFecha.setEnabled(true);
				jTextFieldFecha.setText("dd/mm/aaaa");
			}

			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}

			{
				comboTipo = new JComboBox<String>();
				this.add(comboTipo);
				comboTipo.setBounds(61, 232, 216, 26);

				tipos = Sistema.getInstancia().getTiposDePedido();

				for (int i = 0; i < tipos.size(); i++) {
					comboTipo.addItem((tipos.get(i).getDescripcion()));
				}

				comboTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < tipos.size(); i++)
							if (comboTipo.getSelectedItem().toString().equals(tipos.get(i).getDescripcion()))
								tipo = tipos.get(i);
					}
				});

			}

			{
				comboComplejidad = new JComboBox<String>();
				this.add(comboComplejidad);
				comboComplejidad.setBounds(413, 37, 216, 26);

				complejidades = Sistema.getInstancia().getComplejidadesPedido();

				for (int i = 0; i < complejidades.size(); i++) {
					comboComplejidad.addItem((complejidades.get(i).getNombre()));
				}

				comboComplejidad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < complejidades.size(); i++)
							if (comboComplejidad.getSelectedItem().toString().equals(complejidades.get(i).getNombre()))
								complejidad = complejidades.get(i);

					}

				});

			}
			{
				jButtonEmpleados = new JButton();
				jButtonEmpleados.setLayout(null);
				this.add(jButtonEmpleados);
				jButtonEmpleados.setText("Buscar Empleados");
				jButtonEmpleados.setBounds(442, 135, 157, 30);
				jButtonEmpleados.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonEmpleados.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {

						try {
							pedido.setComplejidad(complejidad);
							pedido.setTipoPedido(tipo);
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							Date fechaInicio = formatter.parse(jTextFieldFecha.getText());
							// int duracion =
							// Math.round(pedido.getTipoPedido().getTiempo() *
							// pedido.getComplejidad().getFactorTiempo());
							float dur = (pedido.getTipoPedido().getTiempo() * pedido.getComplejidad().getFactorTiempo());
							System.out.println("DURACION: " + dur);
							int duracion = 0;
							if (dur > (int) dur) {
								duracion = (int) dur + 1;
							} else {
								duracion = (int) dur;
							}
							Date fechaInicioTope = formatter.parse(Sistema.getInstancia().sumarRestarDiasFecha(pedido.getFechaEntrega(), -duracion));

							if (fechaInicio.after(fechaInicioTope))
								JOptionPane.showMessageDialog(null,
										"La fecha de inicio ingresada no es válida\n La fecha de inicio no puede ser posterior a " + fechaInicioTope.toString());
							else {
								pedido.setFechaInicio(formatter.parse(jTextFieldFecha.getText()));
								empleados = Sistema.getInstancia().getEmpleadosCapacitadosYDisponibles(pedido);

								if (empleados.size() == 0)
									JOptionPane.showMessageDialog(null, "No hay empleados disponibles para los requisitos seleccionados");
								else {

									comboEmpleado.setEnabled(true);
									for (int i = 0; i < empleados.size(); i++)
										comboEmpleado.addItem(empleados.get(i).getApellido());
								}
							}

						} catch (ParseException e) {
							e.printStackTrace();
						}

					}
				});
			}

			{
				jButtonConfirmar = new JButton();
				jButtonConfirmar.setLayout(null);
				this.add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(186, 304, 91, 40);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonConfirmar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {

						try {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							pedido.setFechaInicio(formatter.parse(jTextFieldFecha.getText()));
							// pedido.setEmpleado(empleado);
							// Sistema.getInstancia().programarPedido(pedido,
							// tipo, complejidad);
							Sistema.getInstancia().programarPedido(pedido, empleado);

						} catch (ParseException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Pedido Programado.");

						jTextFieldId.setText("");
						jTextFieldFechaSolicitud.setText("");
						jTextFieldCliente.setText("");
						jTextFieldPeriodicidad.setText("");

						pedidos.clear();
						comboPendientes.removeAllItems();
						pedidos.addAll(Sistema.getInstancia().getPedidos("pendiente"));
						for (int i = 0; i < pedidos.size(); i++)
							comboPendientes.addItem(pedidos.get(i).getDescripcion());

						empleados.clear();
						comboEmpleado.removeAllItems();

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
