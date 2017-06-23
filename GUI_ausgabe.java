import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

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
	add(tA);
	setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
	tA.setPreferredSize( new Dimension(800, 100));
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
