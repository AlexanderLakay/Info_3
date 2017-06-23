import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GUI_Ablauf extends JPanel{
	
	private JTable ablaufTable = new JTable();
	private MyTableModel tM;
	

	public GUI_Ablauf ( MyTableModel tModel ) {
		this.tM = tModel;
		ablaufTable.setModel(tM);
	
		
		JScrollPane sP = new JScrollPane(ablaufTable);
		add(sP, BorderLayout.CENTER);
	}



	
	
	
	
		
		
		

}
