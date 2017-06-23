import javax.swing.table.AbstractTableModel;

/**
 * Klasse, welche die Tabelle konfiguriert und die Daten festlegt
 * 
 * @author Marcel
 */

public class MyTableModel extends AbstractTableModel {
	
	private String [] columnNames = { "No.", "Command", "Configuration" };
	
	private static MyTableModel tModel = null;
	
	
	/**
	 * Erzeugt die Instanz der Klasse
	 * 
	 * @return Gibt die einzige Instanz der Klasse zurueck
	 */
	
	public static MyTableModel getInstance() {
		
		if (tModel == null) {
			
			tModel = new MyTableModel();
		}
		return tModel;
	}
	

	/**
	 * Gibt die Anzahl der Zeilen zurück
	 * @return Anzahl Zeilen
	 */

	public int getRowCount() {
		
		int count = -1;
		while(ControlModel.getInstance().getControllProcess().get(++count) != null);
		//System.out.println("Count: "+count);
		return count;
	}

	
	/**
	 * Gibt die Anzahl der Spalten zurück
	 * @return Anzahl Spalten 
	 */
	
	public int getColumnCount() {
		
		return columnNames.length;
	}
	
	
	/**
	 * Gibt die Anzahl der Spalten-Namen zurück
	 * @return Namen der Spalten
	 */
	
	public String getColumnName(int column) {
		
		return columnNames[column];
	}
	
	/**
	 * Daten werden in die Tabelle eingetragen; Zeilenweise
	 */
	
	
	public Object getValueAt(int row, int column) {
		
	
		Command c = ControlModel.getInstance().getControllProcess().get(row);
		if (column == 0) return (Object)(row+1);
		if (column == 1 && c !=null) return (Object)(c.getName());
		if (column == 2) {
			
			if (c instanceof Direction) {
				String dAusgabe = (((Direction) c).getDegree()) +" Degree";
				return dAusgabe;
			}
			
			if (c instanceof Gear) {
				String gAusgabe = (((Gear) c).getSpeed()) +" cm/sec; " + 
									(((Gear) c).getDuration()) +" sec";
				return gAusgabe;
			}
			
			if (c instanceof Repetition) {
				String rAusgabe = (((Repetition) c).getNrSteps()) +" Steps; " + 
									(((Repetition) c).getNrRepetitions()) +" Repetitions"; 
				return rAusgabe;
			}
			
			if (c instanceof Pause) {
				String pAusgabe = (((Pause) c).getDuration()) +" sec";
				return pAusgabe;
			}	
		}
			
		return "Fehler";
	}
	
	
	public void add() {
		
		fireTableDataChanged();
	}
	
	
	

}
