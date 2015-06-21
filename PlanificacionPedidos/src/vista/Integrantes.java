package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

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
public class Integrantes extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCuit;
	private JLabel jLabelNombre;
	private JLabel jLabelPais;
	private JSeparator jSeparator1;
	private JTabbedPane panel;
	private JButton jButtonSalir;
	private Integrantes instancia;
	private JLabel jLabelCui2;
	private JLabel jLabelCui3;
	private JLabel jLabelCui4;
	private JLabel jLabelKantar;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public Integrantes(JTabbedPane p) {
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
				jLabelCuit = new JLabel();
				this.add(jLabelCuit);
				jLabelCuit.setText("Alen Freire, Manuel");
				jLabelCuit.setBounds(73, 72, 137, 38);
				jLabelCuit.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jLabelKantar = new JLabel();
				this.add(jLabelKantar);
				jLabelKantar.setText("Kantar World Panel");
				jLabelKantar.setBounds(238, 10, 190, 50);
				jLabelKantar.setFont(new java.awt.Font("SansSerif",2,20));
			}

			{
				jLabelCui2 = new JLabel();
				this.add(jLabelCui2);
				jLabelCui2.setText("LU 126031");
				jLabelCui2.setBounds(73, 97, 86, 30);
				jLabelCui2.setFont(new java.awt.Font("Courier New", 1, 13));
			}
			{
				jLabelCui3 = new JLabel();
				this.add(jLabelCui3);
				jLabelCui3.setText("LU 136378");
				jLabelCui3.setBounds(73, 157, 86, 30);
				jLabelCui3.setFont(new java.awt.Font("Courier New", 1, 13));
			}
			{
				jLabelCui4 = new JLabel();
				this.add(jLabelCui4);
				jLabelCui4.setText("LU 135854");
				jLabelCui4.setBounds(74, 215, 86, 30);
				jLabelCui4.setFont(new java.awt.Font("Courier New", 1, 13));
			}

			{
				jLabelNombre = new JLabel();
				this.add(jLabelNombre);
				jLabelNombre.setText("Godoy, Juan Manuel");
				jLabelNombre.setBounds(73, 131, 137, 38);
				jLabelNombre.setFont(new java.awt.Font("SansSerif", 1, 13));
			}

			{
				jLabelPais = new JLabel();
				this.add(jLabelPais);
				jLabelPais.setText("Sara, Eduardo");
				jLabelPais.setBounds(73, 189, 102, 38);
				jLabelPais.setFont(new java.awt.Font("SansSerif", 1, 13));
			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(0, 288, 700, 11);
			}
			{
				jButtonSalir = new JButton();
				this.add(jButtonSalir);
				jButtonSalir.setText("Salir");
				jButtonSalir.setBounds(285, 300, 91, 40);
				jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 13));
				jButtonSalir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panel.remove(instancia);
					}
				});

			}

			BufferedImage myPicture = ImageIO.read(new File("img/uade.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
			picLabel.setBounds(285, 72, 355, 169);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
