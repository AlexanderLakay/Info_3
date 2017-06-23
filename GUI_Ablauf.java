import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GUI_Ablauf extends JPanel{
	
	private JTable ablaufTable = new JTable();
	private static MyTableModel tM;
	private JButton removeB = new JButton("Remove");
	private JButton upB = new JButton("Up");
	private JButton downB = new JButton("Down");
	private JButton stopB = new JButton("Stop");
	private JButton startB = new JButton("Start");
	
	private static GUI_Ablauf ablauf = null;

	private GUI_Ablauf ( ) {
		
		
		this.tM = MyTableModel.getInstance();
		ablaufTable.setModel(tM);
	
		JScrollPane sP = new JScrollPane(ablaufTable);
		add(sP, BorderLayout.CENTER);
	}

	public static GUI_Ablauf getInstance() {
		
		if (ablauf == null) {
			
			ablauf = new GUI_Ablauf();
		}
		return ablauf;
	}
	
	

	
	
	
	
		
		
		

}
