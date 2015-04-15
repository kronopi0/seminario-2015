package vista;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ReportePedidos extends javax.swing.JFrame {
	private JScrollPane jScrollPaneScroll;
	private JLabel jLabelReporte;
	private JTextPane jTextPaneReporte;
	private JTextArea texto;
	private Sistema sistema;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReportePedidos inst = new ReportePedidos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ReportePedidos(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}
	
	public ReportePedidos() {
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("Reporte de Pedidos");
			{
				{
					Container panel=this.getContentPane();
					panel.setLayout(new GridLayout(1,1));
					this.texto=new JTextArea();
					panel.add(texto);
					
				}
			}
			
			pack();
			this.setSize(900, 700);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
