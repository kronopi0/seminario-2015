package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class EliminarComplejidadPedido extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelId;
	private JLabel jLabelNombre;
	private JTextField jTextFieldFactor;
	private JButton jButtonSalir;
	private JButton jButtonConfirmar;
	private JSeparator jSeparator1;
	private JTextField jTextFieldNombre;
	private JTextField jTextFieldId;
	private JLabel jLabelFactor;
	private JLabel jLabelSeleccionar;
	private List<ComplejidadPedidoDTO> complejidades;
	private ComplejidadPedidoDTO complejidad;
	private JComboBox<String> comboComplejidad;

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
			this.setTitle("Baja Complejidad");
			{
				jLabelId = new JLabel();
				getContentPane().add(jLabelId);
				jLabelId.setText("Id:");
				jLabelId.setBounds(101, 84, 29, 16);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelSeleccionar = new JLabel();
				getContentPane().add(jLabelSeleccionar);
				jLabelSeleccionar.setText("Seleccionar una complejidad:");
				jLabelSeleccionar.setBounds(98, 12, 181, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelNombre = new JLabel();
				getContentPane().add(jLabelNombre);
				jLabelNombre.setText("Nombre:");
				jLabelNombre.setBounds(65, 117, 51, 16);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jLabelFactor = new JLabel();
				getContentPane().add(jLabelFactor);
				jLabelFactor.setText("Factor de tiempo:");
				jLabelFactor.setBounds(14, 149, 108, 16);
				jLabelFactor.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				comboComplejidad = new JComboBox<String>();
				getContentPane().add(comboComplejidad);
				comboComplejidad.setBounds(59, 34, 254, 26);

				complejidades = Sistema.getInstancia().listarComplejidades();
				for (int i = 0; i < complejidades.size(); i++)
					comboComplejidad.addItem(complejidades.get(i).getNombre());

				comboComplejidad.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < complejidades.size(); i++)
							if (comboComplejidad.getSelectedItem().toString().equals(complejidades.get(i).getNombre())) {
								complejidad = complejidades.get(i);
								jTextFieldFactor.setText(complejidad.getFactorTiempo() + "");
								jTextFieldId.setText(complejidad.getId() + "");
								jTextFieldNombre.setText(complejidad.getNombre() + "");
							}
					}
				});

			}

			{
				jTextFieldId = new JTextField();
				getContentPane().add(jTextFieldId);
				jTextFieldId.setBounds(127, 75, 114, 28);
				jTextFieldId.setEnabled(false);
				jTextFieldId.setEditable(false);
			}
			{
				jTextFieldNombre = new JTextField();
				getContentPane().add(jTextFieldNombre);
				jTextFieldNombre.setBounds(127, 109, 209, 28);
				jTextFieldNombre.setEnabled(false);
				jTextFieldNombre.setEditable(false);
			}
			{
				jTextFieldFactor = new JTextField();
				getContentPane().add(jTextFieldFactor);
				jTextFieldFactor.setBounds(127, 143, 209, 28);
				jTextFieldFactor.setEnabled(false);
				jTextFieldFactor.setEditable(false);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(0, 189, 391, 11);
			}
			{
				jButtonConfirmar = new JButton();
				getContentPane().add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(75, 200, 86, 33);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						Sistema.getInstancia().eliminarComplejidadPedido(complejidad);
						jTextFieldId.setText("");
						jTextFieldNombre.setText("");
						jTextFieldFactor.setText("");

						complejidades.clear();
						comboComplejidad.removeAllItems();
						complejidades = Sistema.getInstancia().listarComplejidades();
						for (int i = 0; i < complejidades.size(); i++)
							comboComplejidad.addItem(complejidades.get(i).getNombre());

					}
				});
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(218, 200, 85, 33);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

			}
			pack();
			this.setSize(400, 286);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
