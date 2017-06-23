import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * 
 * @author Alexander Lakay
 * Klasse zur Ausgabe der ausgefuehrten Befehle
 *
 */
public class GUI_ausgabe extends JPanel{
	private static GUI_ausgabe ausgabe = null;
	private JTextArea tA = new JTextArea();
	//private JPanel panelAusgabe = new JPanel();
	
/**
 * 
 * @return Gibt die einzige Instanz der Klasse zurueck
 */
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

/**
 * Wird vom Controlmodell aufgerufen
 * @param c Ausgefuehrtes Command
 */
public void commandPerformed(ICommand c)
{
	tA.append(c.toString() + "\n");
}

/**
 * Leert das ausgabefeld
 */
public void clear()
{
	tA.setText("");
}

}
