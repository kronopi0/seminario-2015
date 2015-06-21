package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.joda.time.DateTime;

import controlador.Sistema;
import dao.PedidoDAO;
import dto.ClienteDTO;
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
	private JComboBox<String> comboProgramados;
	private List<ClienteDTO> clientes;
	private JLabel jLabelPedidosPendientes;
	private Pedido pedido;
	private List<Pedido> pedidos;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JComboBox<String> jComboBoxPedidosSinFinalizar;
	private JButton jButtonFinalizarPedido;
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
	private TipoPedido tipo;
	private List<TipoPedido> tipos;
	private ComplejidadPedido complejidad;
	private List<ComplejidadPedido> complejidades;
	private JLabel jLabel5;
	private JTextField jTextFieldFecha;

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
				jLabelCliente.setBounds(22, 137, 75, 38);
				jLabelCliente.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelPedidosPendientes = new JLabel();
				this.add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("1) Seleccionar un pedido a programar:");
				jLabelPedidosPendientes.setBounds(33, 22, 248, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 13));
			}
			{
				comboProgramados = new JComboBox<String>();
				this.add(comboProgramados);
				comboProgramados.setBounds(26, 49, 254, 26);

				pedidos = Sistema.getInstancia().getPedidos("pendiente");
				for (int i = 0; i < pedidos.size(); i++)
					comboProgramados.addItem(pedidos.get(i).getDescripcion());

				comboProgramados.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < pedidos.size(); i++)
							if (comboProgramados.getSelectedItem().toString().equals(pedidos.get(i).getDescripcion()))
								pedido = pedidos.get(i);

						jTextFieldId.setText(pedido.getId() + "");
						jTextFieldFechaSolicitud.setText(pedido.getFechaSolicitud() + "");
						jTextFieldCliente.setText(pedido.getCliente().getNombre());
					}
				});

			}
			{
				jLabelFechaSolicitud = new JLabel();
				this.add(jLabelFechaSolicitud);
				jLabelFechaSolicitud.setText("Fecha de solicitud:");
				jLabelFechaSolicitud.setBounds(22, 111, 129, 38);
				jLabelFechaSolicitud.setFont(new java.awt.Font("SansSerif", 1, 12));
			}

			{
				jLabelId = new JLabel();
				this.add(jLabelId);
				jLabelId.setText("Id pedido:");
				jLabelId.setBounds(24, 83, 75, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jTextFieldCliente = new JTextField();
				this.add(jTextFieldCliente);
				jTextFieldCliente.setBounds(141, 146, 163, 21);
				jTextFieldCliente.setEnabled(false);
				jTextFieldCliente.setEditable(false);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("2) Seleccionar tipo de pedido:");
				jLabel1.setBounds(437, 28, 179, 16);
				jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("3) Seleccionar complejidad:");
				jLabel2.setBounds(437, 98, 193, 16);
				jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("4) Ingresar fecha de inicio:");
				jLabel5.setBounds(260, 211, 163, 16);
				jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12));
			}

			{
				jTextFieldFechaSolicitud = new JTextField();
				this.add(jTextFieldFechaSolicitud);
				jTextFieldFechaSolicitud.setBounds(141, 119, 163, 21);
				jTextFieldFechaSolicitud.setEditable(false);
				jTextFieldFechaSolicitud.setEnabled(false);
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(141, 90, 163, 21);
				jTextFieldId.setEditable(false);
				jTextFieldId.setEnabled(false);
			}
			{
				jTextFieldFecha = new JTextField();
				this.add(jTextFieldFecha);
				jTextFieldFecha.setBounds(251, 238, 179, 27);
				jTextFieldFecha.setEnabled(true);
				jTextFieldFecha.setText("dd/mm/aaaa");
			}

			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}
			{
				jSeparator2 = new JSeparator();
				this.add(jSeparator2);
				jSeparator2.setBounds(-1, 188, 700, 11);
			}

			{
				comboTipo = new JComboBox<String>();
				this.add(comboTipo);
				comboTipo.setBounds(418, 53, 216, 26);

				tipos = Sistema.getInstancia().getTipos();

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
				comboComplejidad.setBounds(418, 123, 216, 26);

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
						jTextFieldFechapedidoDesde.setText(Integer.parseInt(solicitud.toString("dd")) + "/" + Integer.parseInt(solicitud.toString("MM")) + "/"
								+ Integer.parseInt(solicitud.toString("YYYY")));

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
				jButtonConfirmar = new JButton();
				jButtonConfirmar.setLayout(null);
				this.add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(183, 304, 91, 40);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						System.out.println("jButtonFinalizarPedido.actionPerformed, event=" + evt);
						try {
							Sistema.getInstancia().finalizarPedido(pedido);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						jTextFieldId.setText("");
						jTextFieldFechaSolicitud.setText("");
						jTextFieldCliente.setText("");

						pedidos.clear();
						comboProgramados.removeAllItems();
						pedidos = Sistema.getInstancia().getPedidos("pendiente");
						for (int i = 0; i < clientes.size(); i++)
							comboProgramados.addItem(pedidos.get(i).getDescripcion());

						JOptionPane.showMessageDialog(null, "Pedido finalizado.");
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
