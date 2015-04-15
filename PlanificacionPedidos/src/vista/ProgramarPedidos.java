package vista;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import controlador.Sistema;
import entities.ComplejidadPedido;
import entities.Pedido;
import entities.TipoPedido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JComboBox<String> comboComplejidad;
	private JComboBox<String> comboTipo;
	private JButton botonDetalles;
	private JSeparator jSeparator2;
	private JSeparator jSeparator1;
	private JLabel tituloTipo;
	private JLabel tituloComplejidad;
	private JComboBox<String> comboPendientes;
	private JLabel tituloPendientes;
	private Sistema s;
	private Pedido pedido;
	private List<Pedido> pedidosPend;
	private TipoPedido tipo;
	private List<TipoPedido> tipos;
	private ComplejidadPedido complejidad;
	private List<ComplejidadPedido> complejidades;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ProgramarPedidos());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public ProgramarPedidos() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(474, 282));
			this.setLayout(null);
			{
				tituloPendientes = new JLabel();
				this.add(tituloPendientes);
				tituloPendientes.setText("Seleccione un pedido:");
				tituloPendientes.setBounds(156, 12, 166, 16);
				tituloPendientes.setFont(new java.awt.Font("SansSerif", 1, 14));
			}
			{
				comboPendientes = new JComboBox<String>();
				this.add(comboPendientes);
				comboPendientes.setBounds(128, 38, 219, 26);
				comboPendientes.setFont(new java.awt.Font("SansSerif", 0, 14));

				Sistema s = new Sistema();

				pedidosPend = s.getPedidos("Pendiente");

				for (int i = 0; i < pedidosPend.size(); i++) {
					comboPendientes.addItem((pedidosPend.get(i).getDescripcion()));
				}
				pedido = pedidosPend.get(0);

				comboPendientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboPendientes.actionPerformed, event=" + evt);
						for (int i = 0; i < pedidosPend.size(); i++)
							if (comboPendientes.getSelectedItem().toString().equals(pedidosPend.get(i).getDescripcion()))
								pedido = pedidosPend.get(i);
					}
				});

			}
			{
				tituloComplejidad = new JLabel();
				this.add(tituloComplejidad);
				tituloComplejidad.setText("Complejidad");
				tituloComplejidad.setBounds(102, 186, 88, 16);
				tituloComplejidad.setFont(new java.awt.Font("SansSerif", 1, 14));

			}
			{
				tituloTipo = new JLabel();
				this.add(tituloTipo);
				tituloTipo.setText("Tipo");
				tituloTipo.setBounds(158, 152, 34, 16);
				tituloTipo.setFont(new java.awt.Font("SansSerif", 1, 14));
			}
			{
				comboTipo = new JComboBox<String>();
				this.add(comboTipo);
				comboTipo.setBounds(238, 147, 172, 26);
				comboTipo.setEnabled(false);

				s = new Sistema();

				tipos = s.getTipos();

				for (int i = 0; i < tipos.size(); i++) {
					comboTipo.addItem((tipos.get(i).getDescripcion()));
				}

				tipo = tipos.get(0);

				comboTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboTipo.actionPerformed, event=" + evt);

						for (int i = 0; i < tipos.size(); i++)
							if (comboTipo.getSelectedItem().toString().equals(tipos.get(i).getDescripcion()))
								tipo = tipos.get(i);
					}
				});

			}

			{
				comboComplejidad = new JComboBox<String>();
				this.add(comboComplejidad);
				comboComplejidad.setBounds(238, 182, 172, 26);
				comboComplejidad.setEnabled(false);

				s = new Sistema();

				complejidades = s.getComplejidades();

				for (int i = 0; i < complejidades.size(); i++) {
					comboComplejidad.addItem((complejidades.get(i).getNombre()));
				}
				complejidad = complejidades.get(0);

				comboComplejidad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("comboComplejidad.actionPerformed, event=" + evt);
						for (int i = 0; i < tipos.size(); i++)
							if (comboComplejidad.getSelectedItem().toString().equals(complejidades.get(i).getNombre()))
								complejidad = complejidades.get(i);
					}
				});

			}
			{
				botonOK = new JButton();
				this.add(botonOK);
				botonOK.setText("Confirmar");
				botonOK.setBounds(88, 236, 114, 33);
				botonOK.setFont(new java.awt.Font("SansSerif", 1, 12));
				botonOK.setEnabled(false);
				botonOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonOK.actionPerformed, event="+evt);
						s.programarPedido(pedido, tipo, complejidad);
					}
				});
			}
			{
				botonCancelar = new JButton();
				this.add(botonCancelar);
				botonCancelar.setText("Salir");
				botonCancelar.setBounds(270, 238, 110, 32);
				botonCancelar.setFont(new java.awt.Font("SansSerif", 1, 12));
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonCancelar.actionPerformed, event=" + evt);
						System.exit(0);
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 128, 474, 10);
			}
			{
				jSeparator2 = new JSeparator();
				this.add(jSeparator2);
				jSeparator2.setBounds(0, 221, 474, 10);
			}
			{
				botonDetalles = new JButton();
				this.add(botonDetalles);
				botonDetalles.setText("Ver detalles");
				botonDetalles.setBounds(175, 77, 123, 32);
				botonDetalles.setFont(new java.awt.Font("SansSerif", 1, 14));
				botonDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("botonDetalles.actionPerformed, event=" + evt);
						String a = "Id pedido:  " + pedido.getId() + "\n";
						String b = "Descripción:  " + pedido.getDescripcion() + "\n";
						String c;
						if (pedido.getPeriodicidad() == 0)
							c = "Periodicidad:  No aplica\n";
						else
							c = "Periodicidad:  " + pedido.getPeriodicidad() + " días\n";
						String d = "Fecha de solicitud:  " + pedido.getFechaSolicitud();

						JOptionPane.showMessageDialog(null, a + b + c + d);

						comboComplejidad.setEnabled(true);
						comboTipo.setEnabled(true);
						botonOK.setEnabled(true);
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
