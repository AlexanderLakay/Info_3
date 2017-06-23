import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	private String [] columnNames = { "No.", "Command", "Configuration" };
	private int nrRow = 5;
	

	
	public int getRowCount() {
		
		return nrRow;
	}

	
	public int getColumnCount() {
		
		return columnNames.length;
	}
	
	public String getColumnName(int column) {
		
		return columnNames[column];
	}
	
	
	public Object getValueAt(int row, int column) {
		
		return "Test";
	}
	
	

}
