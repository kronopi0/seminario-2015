package vista;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Sistema;
import entities.ComplejidadPedido;
import entities.Pedido;
import entities.TipoPedido;

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
public class ProgramarPedidos extends javax.swing.JPanel {

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

	private JButton botonCancelar;
	private JButton botonOK;
	private JTextField campoFecha;
	private JLabel tituloFecha;
	private JComboBox<String> comboComplejidad;
	private JComboBox<String> comboTipo;
	private JLabel tituloTipo;
	private JLabel tituloComplejidad;
	private JComboBox<String> comboPendientes;
	private JLabel tituloPendientes;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
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
				comboPendientes = new JComboBox<String>();
				this.add(comboPendientes);
				comboPendientes.setBounds(175, 34, 186, 23);

				Sistema s = new Sistema();

				List<Pedido> pedidosPend = s.getPedidos("Pendiente");

				for (int i = 0; i < pedidosPend.size(); i++) {
					comboPendientes.addItem((pedidosPend.get(i).getDescripcion()));
				}

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
				comboTipo = new JComboBox<String>();
				this.add(comboTipo);
				comboTipo.setBounds(175, 98, 156, 24);
				
				Sistema s = new Sistema();

				List<TipoPedido> tipos = s.getTipos();

				for (int i = 0; i < tipos.size(); i++) {
					comboTipo.addItem((tipos.get(i).getDescripcion()));
				}
				
				
			}
			
			{
				comboComplejidad = new JComboBox<String>();
				this.add(comboComplejidad);
				comboComplejidad.setBounds(175, 138, 156, 23);
				
				Sistema s = new Sistema();

				List<ComplejidadPedido> complejidades = s.getComplejidades();

				for (int i = 0; i < complejidades.size(); i++) {
					comboComplejidad.addItem((complejidades.get(i).getNombre()));
				}
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
