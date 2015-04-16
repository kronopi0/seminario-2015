package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import controlador.Sistema;
import entities.Pedido;
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
	private JMenu jMenu5;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JSeparator jSeparator2;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private Sistema sistema;

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
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Pedidos");
					jMenu3.setFont(new java.awt.Font("SansSerif", 1, 12));
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("Alta");
						newFileMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AltaPedido app = new AltaPedido(sistema);
								app.setVisible(true);
							}
						});
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Programar");
						openFileMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								ProgramarPedidos app = new ProgramarPedidos(sistema);
								app.setVisible(true);
							}
						});
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Finalizar");
						saveMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								FinalizarPedido app = new FinalizarPedido(sistema);
								app.setVisible(true);
							}
						});
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Listar");
						saveAsMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								ListarPedidos app = new ListarPedidos(sistema);
								app.setVisible(true);
							}
						});
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Reportes");
					jMenu4.setFont(new java.awt.Font("SansSerif", 1, 12));
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Pedidos por empleado");
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
										TablaPedidosPorEmpleado t = new TablaPedidosPorEmpleado();
										t.main(data);
									}
								});
							}
						});
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Reporte B");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Otros");
					jMenu5.setFont(new java.awt.Font("SansSerif", 1, 12));
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Integrantes");
						helpMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								JOptionPane.showMessageDialog(null, "Integrantes:\n-Alen Freire, Manuel\n-Godoy, Juan Manuel\n-Sara, Eduardo");
							}
						});
					}
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Salir");
						helpMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.exit(0);
							}
						});
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
