import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	private String [] columnNames = { "No.", "Command", "Configuration" };
	
	private static MyTableModel tModel = null;
	
	
public static MyTableModel getInstance() {
		
		if (tModel == null) {
			
			tModel = new MyTableModel();
		}
		return tModel;
	}

	
	public int getRowCount() {
		
		int count = -1;
		while(ControlModel.getInstance().getControllProcess().get(++count) != null);
		//System.out.println("Count: "+count);
		return count;
	}

	
	public int getColumnCount() {
		
		return columnNames.length;
	}
	
	public String getColumnName(int column) {
		
		return columnNames[column];
	}
	
	
	public Object getValueAt(int row, int column) {
		
	
		Command c = ControlModel.getInstance().getControllProcess().get(row);
		if (column == 0) return (Object)(row+1);
		if (column == 1 && c !=null) return (Object)(c.getName());
		if (column == 3) {}
		return "Test";
	}
	
	
	public void add() {
		
		fireTableDataChanged();
	}
	
	
	

}
