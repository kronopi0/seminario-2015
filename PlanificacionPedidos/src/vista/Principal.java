package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controlador.Sistema;
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
	private JTabbedPane jTabbedPane1;
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
		sistema = new Sistema();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Kantar World Panel");
				getContentPane().setBackground(new java.awt.Color(149, 156, 172));
				{
					jTabbedPane1 = new JTabbedPane();
					getContentPane().add(jTabbedPane1);
					jTabbedPane1.setBounds(0, 0, 697, 408);
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
								AltaPedido app = new AltaPedido();
								app.setVisible(true);
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
								ProgramarPedidos app = new ProgramarPedidos();
								app.setVisible(true);
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
								FinalizarPedido app = new FinalizarPedido();
								app.setVisible(true);
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
						saveAsMenuItem.setText("Listar pedidos según estado");
						saveAsMenuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								ListarPedidosPorEstado app = new ListarPedidosPorEstado(sistema);
								app.setVisible(true);
								app.setLocationRelativeTo(null);
							}
						});
					}
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
										TablaPedidosResueltosPorEmpleado t = new TablaPedidosResueltosPorEmpleado();
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
								PorcentajeEntregaEnFecha app = new PorcentajeEntregaEnFecha(sistema, porcentaje);
								app.setVisible(true);
								app.setLocationRelativeTo(null);
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
									AltaComplejidadPedido app = new AltaComplejidadPedido();
									app.setVisible(true);
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
									ModificarComplejidadPedido app = new ModificarComplejidadPedido();
									app.setVisible(true);
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
									EliminarComplejidadPedido app = new EliminarComplejidadPedido();
									app.setVisible(true);
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
									ClienteAltaP app = new ClienteAltaP(jTabbedPane1);
									jTabbedPane1.addTab("Agregar Cliente", app);

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
									ClienteModificarP app = new ClienteModificarP(jTabbedPane1);
									jTabbedPane1.addTab("Modificar Cliente", app);
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
									ClienteBajaP app = new ClienteBajaP(jTabbedPane1);
									jTabbedPane1.addTab("Eliminar Cliente", app);
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
									EmpleadoAltaP app = new EmpleadoAltaP(jTabbedPane1);
									jTabbedPane1.addTab("Agregar Empleado", app);

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
									//EmpleadoModificarP app = new EmpleadoModificarP(jTabbedPane1);
									//jTabbedPane1.addTab("Modificar Empleado", app);
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
									//EmpleadoBajaP app = new EmpladoBajaP(jTabbedPane1);
									//jTabbedPane1.addTab("Eliminar Empleado", app);
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
									JOptionPane.showMessageDialog(null, "Integrantes:\n -Alen Freire, Manuel\n -Godoy, Juan Manuel\n -Sara, Eduardo");
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
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
