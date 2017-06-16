
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class GUI_CommandTypesList extends JPanel {
	
	
	private String[] CommandBefehle = {"Direction", "Gear", "Repetition", "Pause"};
	//private String[] CommandBefehle = {};
	
	
	
	/*for (int i = 0; i < 4; i++) {
		CommandBefehle[i] = ControlModel.getInstance().get(i).toString();
	}*/
	
	
	
	
	private JList<String> CT = new JList<String>(CommandBefehle);
	
	public GUI_CommandTypesList() {
		
		JScrollPane listscroll = new JScrollPane(CT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listscroll.setPreferredSize(new Dimension(100, 400));
		
		//CT.setSelectionBackground(Color.GREEN);
		this.add(listscroll);
		
		
		CT.setVisible(true);
		
	}
	
}

	

