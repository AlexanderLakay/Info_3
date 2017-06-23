
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GUI_CommandTypesList extends JPanel implements ListSelectionListener{	// implementiert Interface ListSelectionListener,
											//		damit er auf Auswahl reagiert.
	private String[] CommandBefehle = new String[4];		// In das Array werden die Commands geschrieben, um sie in die Liste einzufuegen.
	private JList<String> CT = null;				// Liste mit dem Namen CT erstellen.
	private CommandType commandTypes[] = new CommandType[4];	// "Zwischenspeicher" fuer die CommandTypes
	private ControlModel cm = ControlModel.getInstance();		// So wird ein ControlModel erzeugt, da der Konstruktor private ist.

	/**
	 * Konstruktor fuellt die JList CommandListe ueber die Methode createList() mit den Namen der Command-Befehle.
	 */
	public GUI_CommandTypesList() {
		
		CT = new JList<String>(this.createList());				// eine Liste erstellen ueber private Methode createList()
		CT.addListSelectionListener(this);					// uebergibt sich selbst als Listener, weil diese Klasse ein
											// 		ListSelectionListener ist (wurde implementiert).
		JScrollPane listscroll = new JScrollPane(CT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 	// Fuer die Scrollbar
							 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listscroll.setPreferredSize(new Dimension(100, 400));
		
		this.add(listscroll);
				
		CT.setVisible(true);		
	}

	/**
	 * Methode, um die Command-Befehle in ein String-Array einzufuegen, welches dann angezeigt wird.
	 * @return befehle Liste der Command-Befehle
	 */
	private String[] createList() {
		commandTypes = cm.getCommandTypes();
		for (int i = 0; i < 4; i++) {					// Mithilfe von toString() sollen die CommandTypes als Strings in
			CommandBefehle[i] = commandTypes[i].toString();		//		CommandBefehle rein geschrieben werden.
		};
		return Commandbefehle;
	}
	
	/**
	 * Methode aus dem Interface ListSelectionListener, die immer aufgerufen wird, wenn sich die Auswahl in JList aendert.
	 * Uebergibt der Klasse GUI_konfiguration den gerade ausgewaehlten Befehl.
	 */
	public void valueChanged(ListSelectionEvent arg0) {		
		GUI_konfiguration.getInstance().select(CT.getSelectedValue());				
	}	
}

	

