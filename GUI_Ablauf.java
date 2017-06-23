import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GUI_Ablauf extends JPanel implements ListSelectionListener{
	
	private JTable ablaufTable = new JTable();
	private static MyTableModel tM;
	private JPanel bPanel = new JPanel(new BorderLayout());
	private JPanel bRPanel = new JPanel(new GridLayout(0,4));
	private JButton removeB = new JButton("Remove");
	private JButton upB = new JButton("Up");
	private JButton downB = new JButton("Down");
	private JButton stopB = new JButton("Stop");
	private JButton startB = new JButton("Start");
	
	private static GUI_Ablauf ablauf = null;

	private GUI_Ablauf ( ) {
		
		
		this.tM = MyTableModel.getInstance();
		ablaufTable.setModel(tM);
	
		bRPanel.add(upB);
		bRPanel.add(downB);
		bRPanel.add(startB);
		bRPanel.add(stopB);
		
		bPanel.add(bRPanel, BorderLayout.EAST);
		bPanel.add(removeB, BorderLayout.WEST);
		
		JScrollPane sP = new JScrollPane(ablaufTable);
		this.add(sP, BorderLayout.CENTER);
		this.add(bPanel, BorderLayout.SOUTH);
		
		
		removeB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ControlModel.getInstance().remove(ablaufTable.getSelectedRow());
			}
		});
		
		
		upB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ControlModel.getInstance().moveUp(ablaufTable.getSelectedRow());	
			}	
		});
		
		
		downB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ControlModel.getInstance().moveDown(ablaufTable.getSelectedRow());
			}
		});
		
		
		startB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ControlModel.getInstance().start(0);
			}	
		});
		
		
		stopB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ControlModel.getInstance().stop();
			}
		});
		
		
		ablaufTable.getSelectionModel().addListSelectionListener(this);
		
	}

	public static GUI_Ablauf getInstance() {
		
		if (ablauf == null) {
			
			ablauf = new GUI_Ablauf();
		}
		return ablauf;
	}

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		Command c = ControlModel.getInstance().getControllProcess().get(ablaufTable.getSelectedRow());
		GUI_konfiguration.getInstance().load(c);
		GUI_konfiguration.getInstance().select(c.getName());
	}
	
	
	
	
	
	
	
	

	
	
	
	
		
		
		

}
