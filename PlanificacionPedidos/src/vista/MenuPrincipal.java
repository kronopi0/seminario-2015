package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;
import entities.Pedido;

public class MenuPrincipal extends javax.swing.JFrame {
	private JButton jButtonAlta;
	private JButton jButtonFinalizar;
	private JButton jButtonSalir;
	private JSeparator jSeparator2;
	private JButton jButtonReporte;
	private JLabel jLabel1;
	private JSeparator jSeparator1;
	private JLabel jLabelPedidos;
	private JButton jButtonProgramar;
	private Sistema sistema;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal inst = new MenuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MenuPrincipal() {
		super();
		sistema = new Sistema();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Menu Principal");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) 
				  {
				     System.exit(0);
				  }
			});
			{
				jButtonAlta = new JButton();
				getContentPane().add(jButtonAlta);
				jButtonAlta.setText("Alta");
				jButtonAlta.setBounds(90, 24, 84, 29);
				jButtonAlta.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						AltaPedido app = new AltaPedido(sistema);
						app.setVisible(true);
					}
				});
			}
			{
				jButtonProgramar = new JButton();
				getContentPane().add(jButtonProgramar);
				jButtonProgramar.setText("Programar");
				jButtonProgramar.setBounds(179, 24, 96, 29);
				jButtonProgramar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						ProgramarPedidos app = new ProgramarPedidos(sistema);
						app.setVisible(true);
					}
				});
			}
			{
				jButtonFinalizar = new JButton();
				getContentPane().add(jButtonFinalizar);
				jButtonFinalizar.setText("Finalizar");
				jButtonFinalizar.setBounds(280, 24, 84, 29);
				jButtonFinalizar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						FinalizarPedido app = new FinalizarPedido(sistema);
						app.setVisible(true);
					}
				});
			}
			{
				jLabelPedidos = new JLabel();
				getContentPane().add(jLabelPedidos);
				jLabelPedidos.setText("Pedidos");
				jLabelPedidos.setBounds(15, 24, 68, 29);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 78, 384, 10);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Reportes");
				jLabel1.setBounds(12, 104, 68, 29);
			}
			{
				jButtonReporte = new JButton();
				getContentPane().add(jButtonReporte);
				jButtonReporte.setText("Reporte");
				jButtonReporte.setBounds(92, 104, 84, 29);
				jButtonReporte.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						ReportePedidos app = new ReportePedidos(sistema);
						app.setVisible(true);
					}
				});
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(0, 160, 384, 40);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(279, 166, 84, 29);
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
							System.exit(0);
					}
				});
			}
			pack();
			this.setSize(400, 238);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
