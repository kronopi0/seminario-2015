package vista;

import java.awt.Dimension;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
public class ProgramarPedidos extends javax.swing.JPanel {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton botonCancelar;
	private JButton botonOK;
	private JTextField campoFecha;
	private JLabel tituloFecha;
	private JComboBox comboComplejidad;
	private JComboBox comboTipo;
	private JLabel tituloTipo;
	private JLabel tituloComplejidad;
	private JComboBox comboPendientes;
	private JLabel tituloPendientes;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ProgramarPedidos());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ProgramarPedidos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
			this.setLayout(null);
			{
				tituloPendientes = new JLabel();
				this.add(tituloPendientes);
				tituloPendientes.setText("Pedidos Pendientes");
				tituloPendientes.setBounds(26, 37, 123, 16);
			}
			{
				ComboBoxModel comboPendientesModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				comboPendientes = new JComboBox();
				this.add(comboPendientes);
				comboPendientes.setModel(comboPendientesModel);
				comboPendientes.setBounds(175, 34, 186, 23);
			}
			{
				tituloComplejidad = new JLabel();
				this.add(tituloComplejidad);
				tituloComplejidad.setText("Complejidad");
				tituloComplejidad.setBounds(45, 141, 88, 16);
			}
			{
				tituloTipo = new JLabel();
				this.add(tituloTipo);
				tituloTipo.setText("Tipo");
				tituloTipo.setBounds(67, 102, 24, 16);
			}
			{
				ComboBoxModel comboTipoModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				comboTipo = new JComboBox();
				this.add(comboTipo);
				comboTipo.setModel(comboTipoModel);
				comboTipo.setBounds(175, 98, 156, 24);
			}
			{
				ComboBoxModel comboComplejidadModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				comboComplejidad = new JComboBox();
				this.add(comboComplejidad);
				comboComplejidad.setModel(comboComplejidadModel);
				comboComplejidad.setBounds(175, 138, 156, 23);
			}
			{
				tituloFecha = new JLabel();
				this.add(tituloFecha);
				tituloFecha.setText("Fecha Inicio");
				tituloFecha.setBounds(37, 176, 88, 16);
			}
			{
				campoFecha = new JTextField();
				this.add(campoFecha);
				campoFecha.setText("dd-mm-aaaa");
				campoFecha.setBounds(175, 172, 156, 23);
			}
			{
				botonOK = new JButton();
				this.add(botonOK);
				botonOK.setText("Confirmar");
				botonOK.setBounds(208, 235, 84, 36);
			}
			{
				botonCancelar = new JButton();
				this.add(botonCancelar);
				botonCancelar.setText("Cancelar");
				botonCancelar.setBounds(74, 236, 83, 35);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
