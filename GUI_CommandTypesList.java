
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GUI_CommandTypesList extends JPanel implements ListSelectionListener{
	
	
	private String[] CommandBefehle = {"Direction", "Gear", "Repetition", "Pause"};
	private JList<String> CT = new JList<String>(CommandBefehle);
	//private String[] CommandBefehle = {};
	
	
	
	/*for (int i = 0; i < 4; i++) {
		CommandBefehle[i] = ControlModel.getInstance().get(i).toString();
	}*/
	
	
	
	
	
	
	
	public GUI_CommandTypesList() {
		
		CT.addListSelectionListener(this);
		JScrollPane listscroll = new JScrollPane(CT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listscroll.setPreferredSize(new Dimension(100, 400));
		
		//CT.setSelectionBackground(Color.GREEN);
		this.add(listscroll);
		
		
		CT.setVisible(true);
		
	}

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		GUI_konfiguration.getInstance().select(CT.getSelectedValue());
		
		
	}
	
}

	

