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

public class EliminarComplejidadPedido extends javax.swing.JFrame {

	private JLabel jLabelNombre;
	private JLabel jLabelId;
	private JTextField jTextFieldId;
	private JButton jButtonBuscar;
	private JButton jButtonSalir;
	private JButton jButtonEliminar;
	private JSeparator jSeparator1;
	private JLabel jLabelFactorTiempo;
	private JTextField jTextFieldFactorTiempo;
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
				EliminarComplejidadPedido inst = new EliminarComplejidadPedido();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EliminarComplejidadPedido() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Complejidad Pedido");
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(24, 65, 51, 16);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(121, 59, 202, 28);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-7, 150, 391, 11);
			}
			{
				jButtonEliminar = new JButton();
				getContentPane().add(jButtonEliminar);
				jButtonEliminar.setText("Eliminar");
				jButtonEliminar.setBounds(59, 173, 90, 28);
				jButtonEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ComplejidadPedido complejidadPedido = new ComplejidadPedido();
						complejidadPedido.setId(Integer.parseInt(jTextFieldId.getText()));
						complejidadPedido.setNombre(jTextFieldNombre.getText());
						complejidadPedido.setFactorTiempo(Float.parseFloat(jTextFieldFactorTiempo.getText()));
						ComplejidadPedidoDAO.getInstancia().BajaComplejidadPedido(complejidadPedido);
						jTextFieldNombre.setText("");
						jTextFieldFactorTiempo.setText("");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(224, 173, 88, 28);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
				
				
			}
			{
				jButtonBuscar = new JButton();
				getContentPane().add(jButtonBuscar);
				jButtonBuscar.setText("Buscar");
				jButtonBuscar.setBounds(236, 19, 81, 28);
				jButtonBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						ComplejidadPedido complejidadPedidoAct = new ComplejidadPedido();
						complejidadPedidoAct = ComplejidadPedidoDAO.getInstancia().buscarComplejidadPedido(Integer.parseInt(jTextFieldId.getText()));
						jTextFieldNombre.setText(complejidadPedidoAct.getNombre());
						jTextFieldFactorTiempo.setText(Float.toString(complejidadPedidoAct.getFactorTiempo()));
					}
				});
				
				
				
			}
			{
				jTextFieldId = new JTextField();
				getContentPane().add(jTextFieldId);
				jTextFieldId.setBounds(121, 19, 103, 28);
			}
			{
				jLabelId = new JLabel();
				getContentPane().add(jLabelId);
				jLabelId.setText("Id :");
				jLabelId.setBounds(24, 25, 16, 16);
			}
			{
				jTextFieldFactorTiempo = new JTextField();
				getContentPane().add(jTextFieldFactorTiempo);
				jTextFieldFactorTiempo.setBounds(121, 99, 202, 28);
			}
			{
				jLabelFactorTiempo = new JLabel();
				getContentPane().add(jLabelFactorTiempo);
				jLabelFactorTiempo.setText("Factor Tiempo :");
				jLabelFactorTiempo.setBounds(24, 105, 85, 16);
			}
			pack();
			this.setSize(400, 257);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
