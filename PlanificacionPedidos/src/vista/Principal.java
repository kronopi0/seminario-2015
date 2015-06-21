package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import controlador.Sistema;
import entities.Pedido;
import entities.ReportePedidosPorEmpleado;

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
public class Principal extends javax.swing.JFrame {

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

	private JMenuItem helpMenuItem;
	private JMenu jMenuOtros;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenuReportes;
	private JMenuItem saveAsMenuItem;
	private JTabbedPane panel;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenuPedidos;
	private JMenuBar jMenuBar1;
	private Sistema sistema;
	private JMenu jMenuClientes;
	private JMenu jMenuEmpleados;
	private JMenuItem altaMenuItem;
	private JMenuItem modificarMenuItem;
	private JMenuItem bajaMenuItem;
	private JMenu jMenuComplejidadPedidos;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Principal inst = new Principal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Principal() {
		super();
		sistema = Sistema.getInstancia();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Kantar World Panel");
				getContentPane().setBackground(new java.awt.Color(149, 156, 172));
				{
					panel = new JTabbedPane();
					getContentPane().add(panel);
					panel.setBounds(0, 0, 697, 408);
				}
			}
			this.setSize(713, 494);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenuPedidos = new JMenu();
					jMenuBar1.add(jMenuPedidos);
					jMenuPedidos.setText("Pedidos");
					jMenuPedidos.setFont(new java.awt.Font("SansSerif", 1, 12));
					{
						newFileMenuItem = new JMenuItem();
						jMenuPedidos.add(newFileMenuItem);
						newFileMenuItem.setText("Nuevo");
						newFileMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								PedidoAlta tab = new PedidoAlta(panel);
								panel.addTab("Generar Pedido", tab);
							}
						});
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenuPedidos.add(openFileMenuItem);
						openFileMenuItem.setText("Programar");
						openFileMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								PedidoProgramar tab = new PedidoProgramar(panel);
								panel.addTab("Programar Pedido", tab);
							}
						});
					}
					{
						saveMenuItem = new JMenuItem();
						jMenuPedidos.add(saveMenuItem);
						saveMenuItem.setText("Finalizar");
						saveMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								PedidoFinalizar tab = new PedidoFinalizar(panel);
								panel.addTab("Finalizar Pedido", tab);
							}
						});
					}

				}

				{
					jMenuReportes = new JMenu();
					jMenuBar1.add(jMenuReportes);
					jMenuReportes.setText("Reportes");
					jMenuReportes.setFont(new java.awt.Font("SansSerif", 1, 12));
					{
						saveAsMenuItem = new JMenuItem();
						jMenuReportes.add(saveAsMenuItem);
						saveAsMenuItem.setText("Listar pedidos pendientes");
						saveAsMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {

								List<Pedido> pedidos = sistema.getPedidos("pendiente");

								final Object[][] data = new Object[pedidos.size()][4];

								for (int i = 0; i < pedidos.size(); i++) {

									Pedido p = pedidos.get(i);
									data[i][0] = Integer.toString(p.getId());
									data[i][1] = p.getDescripcion();
									data[i][2] = p.getCliente().getNombre();
									data[i][3] = p.getFechaSolicitud();
								}

								ReportePedidosSegunEstado tab = new ReportePedidosSegunEstado();
								tab.main(data);
							}
						});
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenuReportes.add(saveAsMenuItem);
						saveAsMenuItem.setText("Listar pedidos programados");
						saveAsMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								List<Pedido> pedidos = sistema.getPedidos("programado");

								final Object[][] data = new Object[pedidos.size()][4];

								for (int i = 0; i < pedidos.size(); i++) {

									Pedido p = pedidos.get(i);
									data[i][0] = Integer.toString(p.getId());
									data[i][1] = p.getDescripcion();
									data[i][2] = p.getCliente().getNombre();
									data[i][3] = p.getFechaSolicitud();
								}

								ReportePedidosSegunEstado tab = new ReportePedidosSegunEstado();
								tab.main(data);
							}
						});
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenuReportes.add(saveAsMenuItem);
						saveAsMenuItem.setText("Listar pedidos finalizados");
						saveAsMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								List<Pedido> pedidos = sistema.getPedidos("finalizado");

								final Object[][] data = new Object[pedidos.size()][4];

								for (int i = 0; i < pedidos.size(); i++) {

									Pedido p = pedidos.get(i);
									data[i][0] = Integer.toString(p.getId());
									data[i][1] = p.getDescripcion();
									data[i][2] = p.getCliente().getNombre();
									data[i][3] = p.getFechaSolicitud();
								}

								ReportePedidosSegunEstado tab = new ReportePedidosSegunEstado();
								tab.main(data);
							}
						});
					}
					jMenuReportes.add(new JSeparator());
					{
						cutMenuItem = new JMenuItem();
						jMenuReportes.add(cutMenuItem);
						cutMenuItem.setText("Listar pedidos resueltos por empleado");
						cutMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {

								List<ReportePedidosPorEmpleado> l = sistema.reporteCantidadDePedidosResueltosPorEmpleado();

								final Object[][] data = new Object[l.size()][4];

								for (int i = 0; i < l.size(); i++) {

									ReportePedidosPorEmpleado p = l.get(i);
									data[i][0] = Integer.toString(p.getId());
									data[i][1] = p.getNombre();
									data[i][2] = p.getApellido();
									data[i][3] = p.getCantidad();
								}

								javax.swing.SwingUtilities.invokeLater(new Runnable() {
									@Override
									public void run() {
										ReportePedidosResueltosPorEmpleado t = new ReportePedidosResueltosPorEmpleado();
										t.main(data);
									}
								});
							}
						});
					}
					{
						copyMenuItem = new JMenuItem();
						jMenuReportes.add(copyMenuItem);
						copyMenuItem.setText("Cumplimiento Fecha de Entrega");
						copyMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								double porcentaje = sistema.reportePorcentajeDeCumplimientoFechaDeEntrega();
								ReportePorcentajeEntregaEnFecha tab = new ReportePorcentajeEntregaEnFecha(sistema, porcentaje);
								tab.setVisible(true);
								tab.setLocationRelativeTo(null);
							}
						});
					}

					{
						jMenuComplejidadPedidos = new JMenu();
						jMenuBar1.add(jMenuComplejidadPedidos);
						jMenuComplejidadPedidos.setText("Complejidades");
						jMenuComplejidadPedidos.setFont(new java.awt.Font("SansSerif", 1, 12));
						{
							altaMenuItem = new JMenuItem();
							jMenuComplejidadPedidos.add(altaMenuItem);
							altaMenuItem.setText("Alta");
							altaMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									ComplejidadPedidoAlta tab = new ComplejidadPedidoAlta(panel);
									panel.addTab("Agregar Complejidad", tab);
								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuComplejidadPedidos.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									ComplejidadPedidoModificar tab = new ComplejidadPedidoModificar(panel);
									panel.addTab("Modificar Complejidad", tab);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuComplejidadPedidos.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									ComplejidadPedidoBaja tab = new ComplejidadPedidoBaja(panel);
									panel.addTab("Eliminar Complejidad", tab);
								}
							});
						}
					}
					{
						jMenuClientes = new JMenu();
						jMenuBar1.add(jMenuClientes);
						jMenuClientes.setText("Clientes");
						jMenuClientes.setFont(new java.awt.Font("SansSerif", 1, 12));
						{
							altaMenuItem = new JMenuItem();
							jMenuClientes.add(altaMenuItem);
							altaMenuItem.setText("Alta");
							altaMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									ClienteAlta tab = new ClienteAlta(panel);
									panel.addTab("Agregar Cliente", tab);

								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuClientes.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									ClienteModificar tab = new ClienteModificar(panel);
									panel.addTab("Modificar Cliente", tab);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuClientes.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									ClienteBaja tab = new ClienteBaja(panel);
									panel.addTab("Eliminar Cliente", tab);
								}
							});
						}
					}
					{
						jMenuEmpleados = new JMenu();
						jMenuBar1.add(jMenuEmpleados);
						jMenuEmpleados.setText("Empleados");
						jMenuEmpleados.setFont(new java.awt.Font("SansSerif", 1, 12));
						{
							altaMenuItem = new JMenuItem();
							jMenuEmpleados.add(altaMenuItem);
							altaMenuItem.setText("Alta");
							altaMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									EmpleadoAlta tab = new EmpleadoAlta(panel);
									panel.addTab("Agregar Empleado", tab);

								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuEmpleados.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									EmpleadoModificar tab = new EmpleadoModificar(panel);
									panel.addTab("Modificar Empleado", tab);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuEmpleados.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									EmpleadoBaja tab = new EmpleadoBaja(panel);
									panel.addTab("Eliminar Empleado", tab);
								}
							});
						}
					}
					{
						jMenuOtros = new JMenu();
						jMenuBar1.add(jMenuOtros);
						jMenuOtros.setText("Otros");
						jMenuOtros.setFont(new java.awt.Font("SansSerif", 1, 12));
						{
							helpMenuItem = new JMenuItem();
							jMenuOtros.add(helpMenuItem);
							helpMenuItem.setText("Integrantes");
							helpMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									Integrantes tab = new Integrantes(panel);
									panel.addTab("Integrantes", tab);
								}
							});
						}
						{
							helpMenuItem = new JMenuItem();
							jMenuOtros.add(helpMenuItem);
							helpMenuItem.setText("Salir");
							helpMenuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evt) {
									System.exit(0);
								}
							});
						}
						BufferedImage myPicture = ImageIO.read(new File("img/kantar.png"));
						JLabel picLabel = new JLabel(new ImageIcon(myPicture));
						add(picLabel);
						picLabel.setBounds(137, 112, 430, 215);
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
