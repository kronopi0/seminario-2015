package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controlador.Sistema;
import entities.ReportePedidosPorEmpleado;

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
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenuPedidos;
	private JMenuBar jMenuBar1;
	private Sistema sistema;
	private JMenu jMenuClientes;
	private JMenu jMenuEmpleados;
	private JMenu jMenuComplejidades;
	private JMenuItem altaMenuItem;
	private AbstractButton modificarMenuItem;
	private AbstractButton bajaMenuItem;

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
		sistema = new Sistema();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Kantar World Panel");
				getContentPane().setBackground(new java.awt.Color(149, 156, 172));
			}
			this.setSize(497, 360);
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
							public void actionPerformed(ActionEvent evt) {
								double porcentaje = sistema.reportePorcentajeDeCumplimientoFechaDeEntrega();
								PorcentajeEntregaEnFecha app = new PorcentajeEntregaEnFecha(sistema, porcentaje);
								app.setVisible(true);
								app.setLocationRelativeTo(null);
							}
						});
					}

					{
						jMenuComplejidades = new JMenu();
						jMenuBar1.add(jMenuComplejidades);
						jMenuComplejidades.setText("Complejidades");
						jMenuComplejidades.setFont(new java.awt.Font("SansSerif", 1, 12));
						{
							helpMenuItem = new JMenuItem();
							jMenuComplejidades.add(helpMenuItem);
							helpMenuItem.setText("Alta");
						}
						{
							helpMenuItem = new JMenuItem();
							jMenuComplejidades.add(helpMenuItem);
							helpMenuItem.setText("Modificar");
						}
						{
							helpMenuItem = new JMenuItem();
							jMenuComplejidades.add(helpMenuItem);
							helpMenuItem.setText("Baja");
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
									AltaCliente app = new AltaCliente();
									app.setVisible(true);
								}
							});
						}
						{
							modificarMenuItem = new JMenuItem();
							jMenuClientes.add(modificarMenuItem);
							modificarMenuItem.setText("Modificar");
							modificarMenuItem.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ModificarCliente app = new ModificarCliente();
									app.setVisible(true);
								}
							});
						}
						{
							bajaMenuItem = new JMenuItem();
							jMenuClientes.add(bajaMenuItem);
							bajaMenuItem.setText("Baja");
							bajaMenuItem.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									EliminarCliente app = new EliminarCliente();
									app.setVisible(true);
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
							helpMenuItem = new JMenuItem();
							jMenuEmpleados.add(helpMenuItem);
							helpMenuItem.setText("Alta");
						}
						{
							helpMenuItem = new JMenuItem();
							jMenuEmpleados.add(helpMenuItem);
							helpMenuItem.setText("Modificar");
						}
						{
							helpMenuItem = new JMenuItem();
							jMenuEmpleados.add(helpMenuItem);
							helpMenuItem.setText("Baja");
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
									JOptionPane.showMessageDialog(null, "Integrantes:\n -Alen Freire, Manuel\n -Godoy, Juan Manuel\n -Sara, Eduardo");
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
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
