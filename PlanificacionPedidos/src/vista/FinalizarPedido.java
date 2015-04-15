package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;



public class FinalizarPedido extends javax.swing.JFrame {
	private JComboBox jComboBoxPedidosSinFinalizar;
	private JButton jButtonFinalizarPedido;
	private JButton jButtonSalir;
	private JLabel jLabelPedidosPendientes;
	private Sistema sistema;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FinalizarPedido inst = new FinalizarPedido();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FinalizarPedido(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}
	
	public FinalizarPedido() {
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Finalizar Pedido");
			{
				ComboBoxModel jComboBoxPedidosSinFinalizarModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				jComboBoxPedidosSinFinalizar = new JComboBox();
				getContentPane().add(jComboBoxPedidosSinFinalizar);
				jComboBoxPedidosSinFinalizar.setModel(jComboBoxPedidosSinFinalizarModel);
				jComboBoxPedidosSinFinalizar.setBounds(12, 43, 355, 27);
			}
			{
				jLabelPedidosPendientes = new JLabel();
				getContentPane().add(jLabelPedidosPendientes);
				jLabelPedidosPendientes.setText("Pedidos Pendientes de Finalización");
				jLabelPedidosPendientes.setBounds(12, 12, 355, 19);
			}
			{
				jButtonFinalizarPedido = new JButton();
				getContentPane().add(jButtonFinalizarPedido);
				jButtonFinalizarPedido.setText("Finalizar Pedido");
				jButtonFinalizarPedido.setBounds(61, 120, 126, 23);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(227, 120, 97, 23);
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						dispose();
					}
				});
			}
			pack();
			this.setSize(400, 198);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
