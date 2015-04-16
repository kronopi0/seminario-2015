package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.Sistema;
import entities.Cliente;
import entities.Pedido;


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
public class AltaPedido extends javax.swing.JFrame {
	
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
	
	private JLabel jLabelCuit;
	private JButton jButtonBuscarCliente;
	private JLabel jLabelNombreCliente;
	private JLabel jLabelFechaDeEntrega;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator2;
	private JTextField jTextFieldDescripcion;
	private JTextField jTextFieldPeriodicidad;
	private JTextField jTextFieldFechaDeEntrega;
	private JLabel jLabelDescripcion;
	private JLabel jLabelPeriodicidad;
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
								jTextFieldFechaDeEntrega.setEnabled(true);
								jTextFieldPeriodicidad.setEnabled(true);
								jTextFieldDescripcion.setEnabled(true);
							} else {
								JOptionPane.showMessageDialog(null, "El Cliente no existe.");
								jTextFieldCuit.setText("");
								jTextFieldNombreCliente.setText("");
								jTextFieldFechaDeEntrega.setEnabled(false);
								jTextFieldPeriodicidad.setEnabled(false);
								jTextFieldDescripcion.setEnabled(false);
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
				jTextFieldNombreCliente.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-10, 89, 418, 10);
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
				jButtonConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (jTextFieldNombreCliente.getText().isEmpty() ||  jTextFieldFechaDeEntrega.getText().isEmpty() || 
								jTextFieldPeriodicidad.getText().isEmpty() || jTextFieldDescripcion.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Faltan completar campos.");
						}
						else {
							SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
							Pedido p = new Pedido();
							p.setCliente(cliente);
							p.setDescripcion(jTextFieldDescripcion.getText());
							p.setEstado("Pendiente");
							try {
								p.setFechaEntrega(formatter.parse(jTextFieldFechaDeEntrega.getText()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							p.setFechaSolicitud(new Date());
							p.setPeriodicidad(Integer.valueOf(jTextFieldPeriodicidad.getText()));
							
							sistema.altaPedido(p);
							JOptionPane.showMessageDialog(null, "Pedido cargado.");
							jTextFieldCuit.setText("");
							jTextFieldNombreCliente.setText("");
							jTextFieldFechaDeEntrega.setText("");
							jTextFieldPeriodicidad.setText("");
							jTextFieldDescripcion.setText("");
							jTextFieldFechaDeEntrega.setEnabled(false);
							jTextFieldPeriodicidad.setEnabled(false);
							jTextFieldDescripcion.setEnabled(false);
						}
								
					}
				});
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
