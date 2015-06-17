package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;
import dao.ComplejidadPedidoDAO;
import entities.ComplejidadPedido;



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
public class AltaComplejidadPedido extends javax.swing.JFrame {
	private JLabel jLabelNombre;
	private JButton jButtonSalir;
	private JButton jButtonAgregar;
	private JSeparator jSeparator1;
	private JTextField jTextFieldFactorTiempo;
	private JLabel jLabelFactorTiempo;
	private JTextField jTextFieldNombre;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
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
				jLabelNombre.setBounds(24, 35, 51, 16);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(115, 29, 208, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-7, 125, 391, 11);
			}
			{
				jButtonAgregar = new JButton();
				getContentPane().add(jButtonAgregar);
				jButtonAgregar.setText("Agregar");
				jButtonAgregar.setBounds(62, 148, 71, 28);
				jButtonAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ComplejidadPedido complejidadPedido = new ComplejidadPedido();
						complejidadPedido.setNombre(jTextFieldNombre.getText());
						complejidadPedido.setFactorTiempo(Float.parseFloat(jTextFieldFactorTiempo.getText()));
						ComplejidadPedidoDAO.getInstancia().grabarComplejidadPedido(complejidadPedido);
						jTextFieldNombre.setText("");
						jTextFieldFactorTiempo.setText("");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(223, 148, 80, 28);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
				
				
			}
			{
				jLabelFactorTiempo = new JLabel();
				getContentPane().add(jLabelFactorTiempo);
				jLabelFactorTiempo.setText("Factor Tiempo :");
				jLabelFactorTiempo.setBounds(26, 77, 98, 16);
			}
			{
				jTextFieldFactorTiempo = new JTextField();
				getContentPane().add(jTextFieldFactorTiempo);
				jTextFieldFactorTiempo.setBounds(115, 71, 207, 28);
			}
			pack();
			this.setSize(400, 231);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
