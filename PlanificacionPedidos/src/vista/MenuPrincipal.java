package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class MenuPrincipal extends javax.swing.JFrame {
	private JMenuBar Menu;
	private JMenuItem ModifCliente;
	private JMenuItem NuevoCliente;
	private JMenuItem SalirItem;
	private JMenuItem ConsultarDeudas;
	private JMenu Info;
	private JMenu Cliente;
	private JMenu File;
	private JTabbedPane tabbedPane;
	private AbstractAction Alta;
	private JMenuItem Integrantes;
	private static Sistema sist;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal inst = new MenuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				sist = Sistema.getInstancia();

			}
		});
	}

	public MenuPrincipal() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				tabbedPane = new JTabbedPane();
				getContentPane().add(tabbedPane, BorderLayout.CENTER);
			}
			setDefaultLookAndFeelDecorated(true);
			{
				Menu = new JMenuBar();
				setJMenuBar(Menu);
				{
					File = new JMenu();
					Menu.add(File);
					File.setText("Archivo");
					{
						SalirItem = new JMenuItem();
						File.add(SalirItem);
						SalirItem.setText("Salir");
						SalirItem.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});
					}
				}
				{
					Cliente = new JMenu();
					Menu.add(Cliente);
					Cliente.setText("Gestionar Pedidos");
					{
						NuevoCliente = new JMenuItem();
						Cliente.add(NuevoCliente);
						NuevoCliente.setText("Programar Pedidos");
						NuevoCliente.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int p = -1;
								for (int i = 0; i < tabbedPane.getTabCount(); i++) {
									String s = tabbedPane.getComponentAt(i).getClass().toString();
									System.out.print(s);
									if (s.endsWith("Programar Pedidos")) {
										p = i;
									}
								}
								if (p > -1) {
									tabbedPane.setSelectedIndex(p);
								} else {
									Component c;
									c = new ProgramarPedidos();
									tabbedPane.add("Programar Pedidos", c);
									int ip = tabbedPane.indexOfComponent(c);
									tabbedPane.setSelectedIndex(ip);
								}
							}
						});
					}
					{
						ModifCliente = new JMenuItem();
						Cliente.add(ModifCliente);
						ModifCliente.setText("Listar Pedidos Programados");
						ModifCliente.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								int p = -1;
								for (int i = 0; i < tabbedPane.getTabCount(); i++) {
									String s = tabbedPane.getComponentAt(i).getClass().toString();
									if (s.endsWith("ModificarCliente")) {
										p = i;
									}
								}
								if (p > -1) {
									tabbedPane.setSelectedIndex(p);
								} else {
									Component c;
									c = new ListarPedidosProgramados(tabbedPane, sist);
									tabbedPane.add("Modificar Cliente", c);
									int ip = tabbedPane.indexOfComponent(c);
									tabbedPane.setSelectedIndex(ip);
								}
							}
						});
					}

				}

				{
					Info = new JMenu();
					Menu.add(Info);
					Info.setText("Info");
					{
						Integrantes = new JMenuItem();
						Info.add(Integrantes);
						Integrantes.setText("Integrantes");
						Integrantes.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, "Integrantes:\n    Manuel Alen Freire\n    Juan Manuel Martinez Godoy\n    Eduardo Sara");
							}
						});
					}
				}
			}

			pack();
			this.setSize(650, 450);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sistema getSist() {
		return sist;
	}

	public void setSist(Sistema sist) {
		MenuPrincipal.sist = sist;
	}

}