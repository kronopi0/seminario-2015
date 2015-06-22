/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * @author IdlhDeveloper
 */
public class ReporteExportadorExcel {
	private File file;
	private List<JTable> tabla;
	private List<String> nom_files;

	private ReporteExportadorExcel(File file, List<JTable> tabla, List<String> nom_files) throws Exception {
		this.file = file;
		this.tabla = tabla;
		this.nom_files = nom_files;
		if (nom_files.size() != tabla.size()) {
			throw new Exception("Error");
		}
	}

	public ReporteExportadorExcel() {
	}

	public boolean export() {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
			WritableWorkbook w = Workbook.createWorkbook(out);
			for (int index = 0; index < tabla.size(); index++) {
				JTable table = tabla.get(index);
				WritableSheet s = w.createSheet(nom_files.get(index), 0);
				for (int i = 0; i < table.getColumnCount(); i++) {
					for (int j = 0; j < table.getRowCount(); j++) {
						Object object = table.getValueAt(j, i);
						s.addCell(new Label(i, j, String.valueOf(object)));
					}
				}
			}
			w.write();
			w.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void Dialogo(JTable tabla) {
		if (tabla.getRowCount() > 0) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
			chooser.setFileFilter(filter);
			chooser.setDialogTitle("Guardar archivo");
			chooser.setAcceptAllFileFilterUsed(false);
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				List<JTable> tb = new ArrayList<JTable>();
				List<String> nom = new ArrayList<String>();
				tb.add(tabla);
				nom.add("Compras por factura");
				String file = chooser.getSelectedFile().toString().concat(".xls");
				try {
					ReporteExportadorExcel e = new ReporteExportadorExcel(new File(file), tb, nom);
					if (e.export()) {
						JOptionPane.showMessageDialog(null, "Los datos fueron exportados correctamente", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos para exportar", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
		}

	}

}