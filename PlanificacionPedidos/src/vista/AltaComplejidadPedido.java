package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;
import dto.ComplejidadPedidoDTO;

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
public class AltaComplejidadPedido extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelNombre;
	private JTextField jTextFieldFactor;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator1;
	private JTextField jTextFieldNombre;
	private JLabel jLabelFactor;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AltaComplejidadPedido inst = new AltaComplejidadPedido();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public AltaComplejidadPedido() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta Complejidad Pedido");
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(24, 31, 51, 16);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelFactor = new JLabel();
				getContentPane().add(jLabelFactor);
				jLabelFactor.setText("Factor tiempo:");
				jLabelFactor.setBounds(24, 75, 87, 16);
				jLabelFactor.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(117, 25, 230, 28);
			}
			{
				jTextFieldFactor = new JTextField();
				getContentPane().add(jTextFieldFactor);
				jTextFieldFactor.setBounds(117, 69, 230, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-7, 113, 391, 11);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(75, 130, 86, 33);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						ComplejidadPedidoDTO c = new ComplejidadPedidoDTO();
						c.setNombre(jTextFieldNombre.getText());
						c.setFactorTiempo(Float.parseFloat(jTextFieldFactor.getText()));
						Sistema.getInstancia().altaComplejidadPedidoo(c);
						jTextFieldNombre.setText("");
						jTextFieldFactor.setText("");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(217, 131, 85, 33);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

			}
			pack();
			this.setSize(400, 218);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
