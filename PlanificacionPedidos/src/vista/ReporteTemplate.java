package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class ReporteTemplate extends javax.swing.JPanel {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable JTable1;
	private JScrollPane jScrollPane1;
	private JButton jButtonGuardar;
	private JTabbedPane panel;
	private String[][] datos;
	private String[] columnas;
	private JButton jButtonSalir;
	private ReporteTemplate instancia;

	public ReporteTemplate(JTabbedPane p, String[][] d, String[] c) {
		super();
		panel = p;
		datos = d;
		columnas = c;
		instancia = this;
		initGUI();

	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(676, 360));
			this.setLayout(null);

			{
				jButtonGuardar = new JButton();
				jButtonGuardar.setLayout(null);
				this.add(jButtonGuardar);
				jButtonGuardar.setText("Guardar");
				jButtonGuardar.setBounds(183, 319, 86, 41);
				jButtonGuardar.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonGuardar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						ReporteExportadorExcel e = new ReporteExportadorExcel();
						e.Dialogo(JTable1);

					}
				});
			}
			{
				jButtonSalir = new JButton();
				this.add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(396, 319, 93, 41);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panel.remove(instancia);
					}
				});

			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(5, 3, 686, 304);
				{

					TableModel JTable1Model = new DefaultTableModel(datos, columnas);

					JTable1 = new JTable();
					jScrollPane1.setViewportView(JTable1);
					JTable1.setModel(JTable1Model);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
