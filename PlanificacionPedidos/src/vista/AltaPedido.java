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
import entities.Cliente;

public class AltaPedido extends javax.swing.JFrame {
	private JLabel jLabelCuit;
	private JButton jButtonBuscarCliente;
	private JLabel jLabelNombreCliente;
	private JTextField jTextFieldCodigoPedido;
	private JLabel jLabelFechaDeEntrega;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator2;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldPeriodicidad;
	private JTextField jTextFieldFechaDeEntrega;
	private JLabel jLabelDescripcion;
	private JLabel jLabelPeriodicidad;
	private JLabel jLabelCodigoPedido;
	private JSeparator jSeparator1;
	private JTextField jTextFieldNombreCliente;
	private JTextField jTextFieldCuit;
	private Sistema sistema;
	private Cliente cliente;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaPedido inst = new AltaPedido();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaPedido(Sistema s) {
		super();
		sistema = s;
		initGUI();
	}
	
	public AltaPedido() {
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Alta Pedido");
			{
				jLabelCuit = new JLabel();
				getContentPane().add(jLabelCuit);
				jLabelCuit.setText("Cuit Cliente :");
				jLabelCuit.setBounds(12, 19, 70, 16);
			}
			{
				jTextFieldCuit = new JTextField();
				getContentPane().add(jTextFieldCuit);
				jTextFieldCuit.setBounds(94, 16, 102, 23);
			}
			{
				jButtonBuscarCliente = new JButton();
				getContentPane().add(jButtonBuscarCliente);
				jButtonBuscarCliente.setText("Buscar Cliente");
				jButtonBuscarCliente.setBounds(228, 16, 130, 23);
				jButtonBuscarCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							cliente = sistema.buscarCliente(Integer.valueOf(jTextFieldCuit.getText()));
							if (cliente != null)
							{
								jTextFieldNombreCliente.setText(cliente.getNombre());
								jTextFieldCodigoPedido.setEnabled(true);
								jTextFieldFechaDeEntrega.setEnabled(true);
								jTextFieldPeriodicidad.setEnabled(true);
								jTextFieldDescripcion.setEnabled(true);
							} else {
								JOptionPane.showMessageDialog(null, "El Cliente no existe.");
							}
								
					}
				});
			}
			
			{
				jLabelNombreCliente = new JLabel();
				getContentPane().add(jLabelNombreCliente);
				jLabelNombreCliente.setText("Nombre :");
				jLabelNombreCliente.setBounds(12, 53, 62, 16);
			}
			{
				jTextFieldNombreCliente = new JTextField();
				getContentPane().add(jTextFieldNombreCliente);
				jTextFieldNombreCliente.setEnabled(false);
				jTextFieldNombreCliente.setBounds(74, 51, 284, 23);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-10, 89, 418, 10);
			}
			{
				jLabelCodigoPedido = new JLabel();
				getContentPane().add(jLabelCodigoPedido);
				jLabelCodigoPedido.setText("Código de Pedido :");
				jLabelCodigoPedido.setBounds(14, 105, 110, 16);
			}
			{
				jTextFieldCodigoPedido = new JTextField();
				getContentPane().add(jTextFieldCodigoPedido);
				jTextFieldCodigoPedido.setEnabled(false);
				jTextFieldCodigoPedido.setBounds(136, 102, 128, 23);
			}
			{
				jLabelFechaDeEntrega = new JLabel();
				getContentPane().add(jLabelFechaDeEntrega);
				jLabelFechaDeEntrega.setText("Fecha de Entrega :");
				jLabelFechaDeEntrega.setBounds(14, 140, 110, 16);
			}
			{
				jLabelPeriodicidad = new JLabel();
				getContentPane().add(jLabelPeriodicidad);
				jLabelPeriodicidad.setText("Periodicidad :");
				jLabelPeriodicidad.setBounds(14, 176, 110, 16);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción :");
				jLabelDescripcion.setBounds(14, 212, 110, 16);
			}
			{
				jTextFieldFechaDeEntrega = new JTextField();
				getContentPane().add(jTextFieldFechaDeEntrega);
				jTextFieldFechaDeEntrega.setText("dd/mm/aaaa");
				jTextFieldFechaDeEntrega.setEnabled(false);
				jTextFieldFechaDeEntrega.setBounds(136, 137, 128, 23);
			}
			{
				jTextFieldPeriodicidad = new JTextField();
				getContentPane().add(jTextFieldPeriodicidad);
				jTextFieldPeriodicidad.setEnabled(false);
				jTextFieldPeriodicidad.setBounds(136, 173, 128, 23);
			}
			{
				jTextFieldDescripcion = new JTextField();
				getContentPane().add(jTextFieldDescripcion);
				jTextFieldDescripcion.setEnabled(false);
				jTextFieldDescripcion.setBounds(136, 209, 222, 74);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(-10, 295, 400, 10);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(136, 311, 98, 23);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(290, 311, 68, 23);
				jButtonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						dispose();
					}
				});
			}
			pack();
			this.setSize(400, 386);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
