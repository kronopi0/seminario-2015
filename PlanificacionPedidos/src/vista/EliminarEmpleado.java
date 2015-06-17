package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import dao.ClienteDAO;
import dao.EmpleadoDAO;
import entities.Cliente;
import entities.Empleado;


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
public class EliminarEmpleado extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLabelIdEmpleado;
	private JButton jButtonBuscar;
	private JSeparator jSeparator1;
	private JButton jButtonSalir;
	private JButton jButtonEliminar;
	private JTextField jTextFieldApellido;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldId;
	private JLabel jLabelApellido;
	private JLabel jLabelNombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EliminarEmpleado inst = new EliminarEmpleado();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EliminarEmpleado() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Eliminar Empleado");
			{
				jLabelIdEmpleado = new JLabel();
				getContentPane().add(jLabelIdEmpleado);
				jLabelIdEmpleado.setText("Id :");
				jLabelIdEmpleado.setBounds(26, 27, 16, 16);
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre :");
				jLabelNombre.setBounds(26, 67, 70, 16);
			}
			{
				jLabelApellido = new JLabel();
				getContentPane().add(jLabelApellido);
				jLabelApellido.setText("Apellido :");
				jLabelApellido.setBounds(27, 109, 63, 16);
			}
			{
				jTextFieldId = new JTextField();
				getContentPane().add(jTextFieldId);
				jTextFieldId.setBounds(102, 21, 99, 28);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(102, 61, 246, 28);
			}
			{
				jTextFieldApellido = new JTextField();
				getContentPane().add(jTextFieldApellido);
				jTextFieldApellido.setBounds(102, 102, 246, 30);
			}
			{
				jButtonEliminar = new JButton();
				getContentPane().add(jButtonEliminar);
				jButtonEliminar.setText("Eliminar");
				jButtonEliminar.setBounds(42, 172, 86, 28);
				jButtonEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						Empleado empleado = new Empleado();
						empleado.setId(Integer.parseInt(jTextFieldId.getText()));
						empleado.setNombre(jTextFieldNombre.getText());
						empleado.setApellido(jTextFieldApellido.getText());
						EmpleadoDAO.getInstancia().BajaEmpleado(empleado);
						jTextFieldId.setText("");
						jTextFieldNombre.setText("");
						jTextFieldApellido.setText("");
					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(261, 172, 79, 28);
				jButtonSalir.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose();
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(-5, 150, 389, 10);
			}
			{
				jButtonBuscar = new JButton();
				getContentPane().add(jButtonBuscar);
				jButtonBuscar.setText("Buscar");
				jButtonBuscar.setBounds(238, 21, 81, 28);
				jButtonBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						Empleado empleadoAct = new Empleado();
						empleadoAct = EmpleadoDAO.getInstancia().buscarEmpleado(Integer.parseInt(jTextFieldId.getText()));
						jTextFieldNombre.setText(empleadoAct.getNombre());		
						jTextFieldApellido.setText(empleadoAct.getApellido());
					}
				});
			}
			pack();
			this.setSize(400, 256);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
