package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

import controlador.Sistema;

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

			public void run() {
				Principal inst = new Principal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Principal() {
		super();
		Sistema.getInstancia();
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

							public void actionPerformed(ActionEvent evt) {
								PedidoAlta tabPedidoAlta = new PedidoAlta(panel);
								panel.addTab("Generar Pedido", tabPedidoAlta);
							}
						});
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenuPedidos.add(openFileMenuItem);
						openFileMenuItem.setText("Programar");
						openFileMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {
								PedidoProgramar tabPedidoProgramar = new PedidoProgramar(panel);
								panel.addTab("Programar Pedido", tabPedidoProgramar);
							}
						});
					}
					{
						saveMenuItem = new JMenuItem();
						jMenuPedidos.add(saveMenuItem);
						saveMenuItem.setText("Finalizar");
						saveMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {
								PedidoFinalizar tabPedidoFinalizar = new PedidoFinalizar(panel);
								panel.addTab("Finalizar Pedido", tabPedidoFinalizar);
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
						saveAsMenuItem.setText("Pedidos Pendientes");
						saveAsMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {

								String[] columnasPedidosPendientes = { "Id", "Descripción", "Cliente", "Fecha" };
								ReporteTemplate tabPedidosPendientes = new ReporteTemplate(panel, Sistema.getInstancia().reportePedidosPorEstado("pendiente"),
										columnasPedidosPendientes);
								panel.addTab("Pedidos Pendientes", tabPedidosPendientes);

							}
						});
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenuReportes.add(saveAsMenuItem);
						saveAsMenuItem.setText("Pedidos Programados");
						saveAsMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {

								String[] columnasPedidosProgramados = { "Id", "Descripción", "Cliente", "Fecha" };
								ReporteTemplate tabPedidosProgramados = new ReporteTemplate(panel, Sistema.getInstancia().reportePedidosPorEstado("programado"),
										columnasPedidosProgramados);
								panel.addTab("Pedidos Programados", tabPedidosProgramados);
							}
						});
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenuReportes.add(saveAsMenuItem);
						saveAsMenuItem.setText("Pedidos Finalizados");
						saveAsMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {

								String[] columnasPedidosFinalizados = { "Id", "Descripción", "Cliente", "Fecha" };
								ReporteTemplate tabPedidosFinalizados = new ReporteTemplate(panel, Sistema.getInstancia().reportePedidosPorEstado("finalizado"),
										columnasPedidosFinalizados);
								panel.addTab("Pedidos Finalizados", tabPedidosFinalizados);
							}
						});
					}
					jMenuReportes.add(new JSeparator());
					{
						cutMenuItem = new JMenuItem();
						jMenuReportes.add(cutMenuItem);
						cutMenuItem.setText("Pedidos resueltos por empleado (FALTA)");
						cutMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {
								String[] columnasResueltosPorEmpleado = { "Id", "Descripción", "Cliente", "Fecha" };
								ReporteTemplate tabResueltosPorEmpleado = new ReporteTemplate(panel, Sistema.getInstancia().reporteResueltosPorEmpleado(),
										columnasResueltosPorEmpleado);
								panel.addTab("Pedidos Finalizados", tabResueltosPorEmpleado);

							}
						});
					}
					{
						copyMenuItem = new JMenuItem();
						jMenuReportes.add(copyMenuItem);
						copyMenuItem.setText("% Cumplimiento con Fecha de Entrega (FALTA)");
						copyMenuItem.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent evt) {
								
								ReporteCumplimientoFechas tabReporteCumplimientoFechas = new ReporteCumplimientoFechas(panel, Sistema.getInstancia().reporteCumplimientoFechas());
								panel.addTab("% Cumplimiento Fechas", tabReporteCumplimientoFechas);

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

								public void actionPerformed(ActionEvent evt) {
									ComplejidadPedidoAlta tabComplejidadPedidoAlta = new ComplejidadPedidoAlta(panel);
									panel.addTab("Agregar Complejidad", tabComplejidadPedidoAlta);
								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuComplejidadPedidos.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evt) {
									ComplejidadPedidoModificar tabComplejidadPedidoModificar = new ComplejidadPedidoModificar(panel);
									panel.addTab("Modificar Complejidad", tabComplejidadPedidoModificar);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuComplejidadPedidos.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evt) {
									ComplejidadPedidoBaja tabComplejidadPedidoBaja = new ComplejidadPedidoBaja(panel);
									panel.addTab("Eliminar Complejidad", tabComplejidadPedidoBaja);
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

								public void actionPerformed(ActionEvent evt) {
									ClienteAlta tabClienteAlta = new ClienteAlta(panel);
									panel.addTab("Agregar Cliente", tabClienteAlta);

								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuClientes.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evt) {
									ClienteModificar tabClienteModificar = new ClienteModificar(panel);
									panel.addTab("Modificar Cliente", tabClienteModificar);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuClientes.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evt) {
									ClienteBaja tabClienteBaja = new ClienteBaja(panel);
									panel.addTab("Eliminar Cliente", tabClienteBaja);
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

								public void actionPerformed(ActionEvent evt) {
									EmpleadoAlta tabEmpleadoAlta = new EmpleadoAlta(panel);
									panel.addTab("Agregar Empleado", tabEmpleadoAlta);

								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuEmpleados.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evt) {
									EmpleadoModificar tabEmpleadoModificar = new EmpleadoModificar(panel);
									panel.addTab("Modificar Empleado", tabEmpleadoModificar);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuEmpleados.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evt) {
									EmpleadoBaja tabEmpleadoBaja = new EmpleadoBaja(panel);
									panel.addTab("Eliminar Empleado", tabEmpleadoBaja);
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

								public void actionPerformed(ActionEvent evt) {
									Integrantes tabIntegrantes = new Integrantes(panel);
									panel.addTab("Integrantes", tabIntegrantes);
								}
							});
						}
						{
							helpMenuItem = new JMenuItem();
							jMenuOtros.add(helpMenuItem);
							helpMenuItem.setText("Salir");
							helpMenuItem.addActionListener(new ActionListener() {

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
