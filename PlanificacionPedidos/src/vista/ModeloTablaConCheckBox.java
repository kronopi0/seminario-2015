package vista;

import javax.swing.table.AbstractTableModel;

class ModeloTablaConCheckBox extends AbstractTableModel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	Object rowData[][];

	String columnNames[] = { " ", " "};

	public ModeloTablaConCheckBox(Object[][] rowData) {
		super();
		this.rowData = rowData;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getRowCount() {
		return rowData.length;
	}

	public Object getValueAt(int row, int column) {
		return rowData[row][column];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int column) {
		return (getValueAt(0, column).getClass());
	}

	public void setValueAt(Object value, int row, int column) {
		rowData[row][column] = value;
	}

	public boolean isCellEditable(int row, int column) {
		return (column != 0);
	}
}