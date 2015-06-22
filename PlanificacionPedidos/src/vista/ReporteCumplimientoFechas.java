package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import controlador.Sistema;
import dto.ClienteDTO;

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
public class ReporteCumplimientoFechas extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelLabel1;
	private JLabel jLabelValor;
	private JSeparator jSeparator1;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private ReporteCumplimientoFechas instancia;
	private Double valor;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public ReporteCumplimientoFechas(JTabbedPane p, Double v) {
		super();
		panel = p;
		valor = v;
		instancia = this;
		initGUI();

	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(676, 360));
			this.setLayout(null);
			{
				jLabelLabel1 = new JLabel();
				this.add(jLabelLabel1);
				jLabelLabel1.setText("Pedidos finalizados en fecha:");
				jLabelLabel1.setBounds(199, 23, 260, 47);
				jLabelLabel1.setFont(new java.awt.Font("SansSerif", 1, 18));
			}
			{
				jLabelValor = new JLabel();
				this.add(jLabelValor);
				jLabelValor.setText("15%");
				jLabelValor.setBounds(298, 87, 60, 46);
				jLabelValor.setFont(new java.awt.Font("Tahoma", 1, 24));
			}

			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}
			{
				jButtonSalir = new JButton();
				this.add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(283, 305, 91, 40);
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
