import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class GUI_menubar extends JMenuBar implements ActionListener {
	
		JMenuBar mb = new JMenuBar();
		JMenu menu[] = new JMenu[2];
		JMenuItem menuItems [][] = new JMenuItem [2][4];
	
	
	public GUI_menubar() {
		
		this.add(mb);
		mb.setPreferredSize(new Dimension(800, 25));
		
		String menuNames[] = {"File", "Info"};
		
		for (int i = 0; i < menu.length; i++) {
			 menu[i] = new JMenu(menuNames[i]);
			 mb.add(menu[i]);
		}
		
		String itemsNames[][] = { {"New", "Open", "Save", "Close"}, {"Eclipse Help", "API", "JavaDoc", "Copyright"} };
		
		for (int j1 = 0; j1 < menuItems.length; j1++) {
			for (int j2 = 0; j2 < menuItems[j1].length; j2++) {
			 menuItems[j1][j2] = new JMenuItem(itemsNames[j1][j2]);
			 menuItems[j1][j2].addActionListener(this);
			 menu[j1].add(menuItems[j1][j2]);
			}
		}
	}
		
		public void actionPerformed (ActionEvent evt) {
			Object source = evt.getSource();
			
			//File >> New
			if(source.equals(menuItems[0][0])) {}
				
			
			//File >> Open
			if(source.equals(menuItems[0][1]))	{
				
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    
			          ControlModel.getInstance().load(new File(chooser.getSelectedFile().getName()));
			    }
			}
			
			
			//File >> Save
			if(source.equals(menuItems[0][2]))	{
				
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showSaveDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    
			          ControlModel.getInstance().save(new File(chooser.getSelectedFile().getName()));
			    }
			}
			
				
			//File >> Close
			if(source.equals(menuItems[0][3])) { System.exit(0); }
			
			
			//Info >> Help
			if(source.equals(menuItems[1][0])) {
				String Help = "https://help.eclipse.org/neon/index.jsp";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(Help));
				} catch (IOException e) { e.printStackTrace();	}
			}
				
				
			//Info >> API
			if(source.equals(menuItems[1][1])) {
				String API = "https://docs.oracle.com/javase/8/docs/api/";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(API));
				} catch (IOException e) { e.printStackTrace();	}
			}
			
			
			//Info >> JavaDoc
			if(source.equals(menuItems[1][2])) {
				String JavaDoc = "file:///Users/Marcel/Desktop/FH%20Reutlingen/3.%20Semester/Informatik%203/workspace/2017_ss_mec_praktikum_gruppe/doc/index.html";
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(JavaDoc));
				} catch (IOException e) { e.printStackTrace();	}
				
			}
			
				
			//Info >> Copyright
			if(source.equals(menuItems[1][3])) {
			
				JOptionPane.showMessageDialog(null, "Alexander Lakay, Kai Heckl, Marcel Gaßmann",
						"Copyright:", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}

		
}

