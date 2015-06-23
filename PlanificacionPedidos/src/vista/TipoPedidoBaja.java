package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import controlador.Sistema;
import dto.TipoPedidoDTO;

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
public class TipoPedidoBaja extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelFactor;
	private JTextField jTextFieldFactor;
	private JSeparator jSeparator1;
	private JButton jButtonConfirmar;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private TipoPedidoBaja instancia;
	private List<TipoPedidoDTO> Tipos;
	private TipoPedidoDTO Tipo;
	private JComboBox<String> comboTipo;
	private JLabel jLabelId;
	private JTextField jTextFieldId;
	private JLabel jLabelSeleccionar;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public TipoPedidoBaja(JTabbedPane p) {
		super();
		panel = p;
		instancia = this;
		initGUI();

	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(676, 360));
			this.setLayout(null);
			{
				jLabelId = new JLabel();
				this.add(jLabelId);
				jLabelId.setText("Id :");
				jLabelId.setBounds(184, 104, 75, 38);
				jLabelId.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelFactor = new JLabel();
				this.add(jLabelFactor);
				jLabelFactor.setText("Factor de tiempo:");
				jLabelFactor.setBounds(184, 147, 129, 38);
				jLabelFactor.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jTextFieldId = new JTextField();
				this.add(jTextFieldId);
				jTextFieldId.setBounds(313, 108, 230, 28);
				jTextFieldId.setEditable(false);
				jTextFieldId.setEnabled(false);
			}
			{
				jTextFieldFactor = new JTextField();
				this.add(jTextFieldFactor);
				jTextFieldFactor.setBounds(313, 151, 230, 28);
				jTextFieldFactor.setEditable(false);
				jTextFieldFactor.setEnabled(false);
			}
			{
				comboTipo = new JComboBox<String>();
				this.add(comboTipo);
				comboTipo.setBounds(220, 49, 254, 26);

				Tipos = Sistema.getInstancia().listarTiposPedido();
				for (int i = 0; i < Tipos.size(); i++)
					comboTipo.addItem(Tipos.get(i).getDescripcion());

				comboTipo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {
						for (int i = 0; i < Tipos.size(); i++)
							if (comboTipo.getSelectedItem().toString().equals(Tipos.get(i).getDescripcion())) {
								Tipo = Tipos.get(i);
								jTextFieldFactor.setText(Tipo.getTiempo() + "");
								jTextFieldId.setText(Tipo.getIdTipoPedido() + "");
							}
					}
				});

			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}
			{
				jLabelSeleccionar = new JLabel();
				this.add(jLabelSeleccionar);
				jLabelSeleccionar.setText("Seleccionar una Tipo:");
				jLabelSeleccionar.setBounds(255, 24, 193, 16);
				jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 1, 12));
			}
			{
				jButtonConfirmar = new JButton();
				jButtonConfirmar.setLayout(null);
				this.add(jButtonConfirmar);
				jButtonConfirmar.setText("Confirmar");
				jButtonConfirmar.setBounds(183, 304, 91, 40);
				jButtonConfirmar.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonConfirmar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent evt) {
						Sistema.getInstancia().eliminarTipoPedido(Tipo);
						jTextFieldId.setText("");
						jTextFieldFactor.setText("");

						Tipos.clear();
						comboTipo.removeAllItems();
						Tipos.addAll(Sistema.getInstancia().listarTiposPedido());
						for (int i = 0; i < Tipos.size(); i++)
							comboTipo.addItem(Tipos.get(i).getDescripcion());

					}
				});
			}
			{
				jButtonSalir = new JButton();
				this.add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(396, 304, 91, 40);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonSalir.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						panel.remove(instancia);
					}
				});

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
