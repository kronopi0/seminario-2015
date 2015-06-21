package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class ReportePorcentajeEntregaEnFecha extends javax.swing.JFrame {

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

	private JButton jButtonSalir;
	private JLabel jLabelPedidosPendientes;
	private JLabel porcentaje;
	private double por;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ReportePorcentajeEntregaEnFecha inst = new ReportePorcentajeEntregaEnFecha();
				inst.setVisible(true);
			}
		});
	}

	public ReportePorcentajeEntregaEnFecha(Sistema s, double porcentaje) {
		super();
		por = porcentaje;
		initGUI();
	}

	public ReportePorcentajeEntregaEnFecha() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelPedidosPendientes = new JLabel();
				getContentPane().add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("Porcentaje de pedidos resueltos:");
				jLabelPedidosPendientes.setBounds(59, 15, 243, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 14));
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(123, 142, 90, 28);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				porcentaje = new JLabel();
				getContentPane().add(porcentaje);
				porcentaje.setBounds(140, 53, 89, 59);
				porcentaje.setText("45%");
				porcentaje.setFont(new java.awt.Font("SansSerif", 1, 24));
				System.out.println(por);
				porcentaje.setText(por + "%");

			}
			pack();
			this.setSize(350, 219);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
