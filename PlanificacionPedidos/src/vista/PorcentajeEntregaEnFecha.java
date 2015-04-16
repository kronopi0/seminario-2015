package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.joda.time.DateTime;

import controlador.Sistema;
import entities.Pedido;

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
public class PorcentajeEntregaEnFecha extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JButton jButtonSalir;
	private JLabel jLabelPedidosPendientes;
	private Sistema sistema;
	private JLabel porcentaje;
	private JSeparator jSeparator1;
	private Pedido pedido;
	private List<Pedido> pedidos;
	private double por;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PorcentajeEntregaEnFecha inst = new PorcentajeEntregaEnFecha();
				inst.setVisible(true);
			}
		});
	}

	public PorcentajeEntregaEnFecha(Sistema s, double porcentaje) {
		super();
		sistema = s;
		por = porcentaje;
		initGUI();
	}

	public PorcentajeEntregaEnFecha() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelPedidosPendientes = new JLabel();
				getContentPane().add(jLabelPedidosPendientes);
				jLabelPedidosPendientes
						.setText("Porcentaje de pedidos resueltos:");
				jLabelPedidosPendientes.setBounds(59, 15, 243, 19);
				jLabelPedidosPendientes.setFont(new java.awt.Font("Segoe UI",
						1, 14));
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(123, 142, 90, 28);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				porcentaje = new JLabel();
				getContentPane().add(porcentaje);
				porcentaje.setBounds(149, 58, 55, 42);
				porcentaje.setText("45%");
				porcentaje.setFont(new java.awt.Font("SansSerif",1,24));
				
				por = 123/56;
				
				porcentaje.setText(por+"%");
				
				
			}
			pack();
			this.setSize(350, 219);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}