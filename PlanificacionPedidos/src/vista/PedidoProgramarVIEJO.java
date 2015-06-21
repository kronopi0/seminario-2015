package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.joda.time.DateTime;

/*import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 //import java.util.Calendar;
 import java.util.Date;
 //import java.util.GregorianCalendar;
 import java.util.List;

 import javax.swing.JButton;
 import javax.swing.JComboBox;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JSeparator;
 import javax.swing.JTextField;
 import javax.swing.WindowConstants;
 import javax.swing.SwingUtilities;

 import org.joda.time.DateTime;*/

import controlador.Sistema;
import dao.PedidoDAO;
import entities.ComplejidadPedido;
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
public class PedidoProgramarVIEJO extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JComboBox<String> jComboBoxPedidosSinFinalizar;
	private JButton jButtonFinalizarPedido;
	private JButton jButtonSalir;
	private JLabel jLabelPedidosPendientes;
	private Sistema sistema;
	private JComboBox<String> comboComplejidad;
	private JComboBox<String> comboTipo;
	private JSeparator jSeparator2;
	private JLabel jLabel4;
	private JTextField jTextFieldFechaPedidoHasta;
	private JTextField jTextFieldFechapedidoDesde;
	private JTextField jTextFieldFechaInicio;
	private JLabel jLabel3;
	private JSeparator jSeparator3;
	private JButton botonDetalles;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JSeparator jSeparator1;
	private Pedido pedido;
	private List<Pedido> pedidos;
	private TipoPedido tipo;
	private List<TipoPedido> tipos;
	private ComplejidadPedido complejidad;
	private List<ComplejidadPedido> complejidades;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PedidoProgramarVIEJO inst = new PedidoProgramarVIEJO();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public PedidoProgramarVIEJO() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Programar Pedido");
			{

				jComboBoxPedidosSinFinalizar = new JComboBox<String>();
				getContentPane().add(jComboBoxPedidosSinFinalizar);
				jComboBoxPedidosSinFinalizar.setBounds(71, 41, 260, 27);

				pedidos = PedidoDAO.getInstancia().getPedidos("Pendiente");
				System.out.println(pedidos.get(0).getDescripcion());
				for (int i = 0; i < pedidos.size(); i++)
					jComboBoxPedidosSinFinalizar.addItem(pedidos.get(i).getDescripcion());

				pedido = pedidos.get(0);

				jComboBoxPedidosSinFinalizar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < pedidos.size(); i++)
							if (jComboBoxPedidosSinFinalizar.getSelectedItem().toString().equals(pedidos.get(i).getDescripcion()))
								pedido = pedidos.get(i);

					}
				});
			}
			{
				jLabelPedidosPendientes = new JLabel();
				getContentPane().add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("Pedidos pendientes a programar:");
				jLabelPedidosPendientes.setBounds(86, 15, 243, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 14));
			}
			{
				jButtonFinalizarPedido = new JButton();
				getContentPane().add(jButtonFinalizarPedido);
				jButtonFinalizarPedido.setText("Programar Pedido");
				jButtonFinalizarPedido.setBounds(51, 411, 133, 35);
				jButtonFinalizarPedido.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonFinalizarPedido.setEnabled(false);
				jButtonFinalizarPedido.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonOK.actionPerformed, event=" + evt);
						// pedido.setFechaInicio(new Date());
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						try {
							pedido.setFechaInicio(formatter.parse(jTextFieldFechaInicio.getText()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Sistema.getInstancia().programarPedido(pedido, tipo, complejidad);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// JOptionPane.showMessageDialog(null,
						// "Pedido programado.");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(224, 411, 107, 34);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 121, 394, 10);
			}
			{
				botonDetalles = new JButton();
				getContentPane().add(botonDetalles);
				botonDetalles.setText("Detalles");
				botonDetalles.setBounds(152, 78, 94, 30);
				botonDetalles.setFont(new java.awt.Font("SansSerif", 1, 12));
				botonDetalles.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonDetalles.actionPerformed, event=" + evt);

						DateTime solicitud = new DateTime(pedido.getFechaSolicitud());
						DateTime entrega = new DateTime(pedido.getFechaEntrega());

						String a = pedido.getDescripcion() + "\n\n";
						String b = "Id pedido:  " + pedido.getId() + "\n";
						String c;
						if (pedido.getPeriodicidad() == 0)
							c = "Periodicidad:  No aplica\n\n";
						else
							c = "Periodicidad:  " + pedido.getPeriodicidad() + " días\n\n";
						String d = "Cliente:  " + pedido.getCliente().getNombre() + "\n";
						String e = "Fecha de solicitud:  " + Integer.parseInt(solicitud.toString("dd")) + "/"
								+ Integer.parseInt(solicitud.toString("MM")) + "/" + Integer.parseInt(solicitud.toString("YYYY")) + "\n";
						String f = "Fecha de entrega esperada:  " + Integer.parseInt(entrega.toString("dd")) + "/"
								+ Integer.parseInt(entrega.toString("MM")) + "/" + Integer.parseInt(entrega.toString("YYYY")) + "\n";

						JOptionPane.showMessageDialog(null, a + b + c + d + e + f);
					}
				});
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 271, 394, 10);
			}
			{
				comboTipo = new JComboBox<String>();
				getContentPane().add(comboTipo);
				comboTipo.setBounds(88, 159, 216, 26);

				tipos = PedidoDAO.getInstancia().getTipos();

				for (int i = 0; i < tipos.size(); i++) {
					comboTipo.addItem((tipos.get(i).getDescripcion()));
				}

				comboTipo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboTipo.actionPerformed, event=" + evt);

						for (int i = 0; i < tipos.size(); i++)
							if (comboTipo.getSelectedItem().toString().equals(tipos.get(i).getDescripcion()))
								tipo = tipos.get(i);
					}
				});

			}

			{
				comboComplejidad = new JComboBox<String>();
				getContentPane().add(comboComplejidad);
				comboComplejidad.setBounds(89, 227, 216, 26);

				complejidades = PedidoDAO.getInstancia().getComplejidades();

				for (int i = 0; i < complejidades.size(); i++) {
					comboComplejidad.addItem((complejidades.get(i).getNombre()));
				}

				comboComplejidad.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboComplejidad.actionPerformed, event=" + evt);
						for (int i = 0; i < tipos.size(); i++)
							if (comboComplejidad.getSelectedItem().toString().equals(complejidades.get(i).getNombre()))
								complejidad = complejidades.get(i);
						jButtonFinalizarPedido.setEnabled(true);
						// Fecha Desde
						DateTime solicitud = new DateTime(new Date());
						jTextFieldFechapedidoDesde.setText(Integer.parseInt(solicitud.toString("dd")) + "/"
								+ Integer.parseInt(solicitud.toString("MM")) + "/" + Integer.parseInt(solicitud.toString("YYYY")));

						// Fecha Hasta
						// duracion en dias
						float d = (tipo.getCantDias() * complejidad.getFactorTiempo());
						int dur = 0;
						if (d > (int) d) {
							dur = (int) d + 1;
						} else {
							dur = (int) d;
						}

						String solicitud1 = null;
						try {
							solicitud1 = Sistema.getInstancia().sumarRestarDiasFecha(pedido.getFechaEntrega(), -dur);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						jTextFieldFechaPedidoHasta.setText(solicitud1);

						jTextFieldFechaPedidoHasta.setEnabled(false);
						jTextFieldFechapedidoDesde.setEnabled(false);
					}

				});
				complejidad = complejidades.get(0);

			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Seleccione tipo de pedido:");
				jLabel1.setBounds(118, 137, 162, 16);
				jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Seleccionar complejidad:");
				jLabel2.setBounds(121, 206, 159, 16);
				jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jSeparator3 = new JSeparator();
				getContentPane().add(jSeparator3);
				jSeparator3.setBounds(0, 392, 401, 40);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Ingresar fecha de inicio del pedido entre:");
				jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12));
				jLabel3.setBounds(42, 307, 231, 16);
			}
			{
				jTextFieldFechaInicio = new JTextField();
				getContentPane().add(jTextFieldFechaInicio);
				jTextFieldFechaInicio.setText("dd/mm/aaaa");
				jTextFieldFechaInicio.setBounds(292, 353, 82, 28);
			}
			{
				jTextFieldFechapedidoDesde = new JTextField();
				getContentPane().add(jTextFieldFechapedidoDesde);
				jTextFieldFechapedidoDesde.setBounds(292, 286, 82, 28);
			}
			{
				jTextFieldFechaPedidoHasta = new JTextField();
				getContentPane().add(jTextFieldFechaPedidoHasta);
				jTextFieldFechaPedidoHasta.setBounds(292, 314, 82, 28);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Fecha de inicio del pedido :");
				jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12));
				jLabel4.setBounds(42, 359, 231, 16);
			}
			pack();
			this.setSize(410, 504);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
