import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Klasse zum Ausgeben und Bearbeiten der Tabelle
 * 
 * @author Marcel
 */


public class GUI_ausgabe extends JPanel{
	private static GUI_ausgabe ausgabe = null;
	private JTextArea tA = new JTextArea();
	//private JPanel panelAusgabe = new JPanel();
	

public static GUI_ausgabe getInstance()
{
	if(ausgabe == null)
		ausgabe = new GUI_ausgabe();
	return ausgabe;
}

private GUI_ausgabe()
{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	JScrollPane ausgabeSP = new JScrollPane(tA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			 									JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	add(ausgabeSP);
	setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
	tA.setPreferredSize( new Dimension(dim.getSize()));
	tA.setEditable(false);

	
}

public void commandPerformed(ICommand c)
{
	tA.append(c.toString() + "\n");
}

public void clear()
{
	tA.setText("");
}

}
