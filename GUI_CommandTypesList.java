
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GUI_CommandTypesList extends JPanel implements ListSelectionListener{	// implementiert Interface ListSelectionListener, damit er auf
											//	Auswahl reagiert.
	
	private JList<String> CommandListe = null;			// Liste mit dem Namen CommandListe erstellen
	private ControlModel cm = ControlModel.getInstance();		// so wird ein ControlModel erzeugt, da Konstruktor private ist.
	private String[] CommandBefehle = new String[4];		// In das String-Array befehle werden die Commands geschrieben, um sie in die Liste einzufuegen.
	private CommandType commandTypes[] = new CommandType[4];	// "Zwischenspeicher" fuer die CommandType-Objekte
	
	/**
	 * Konstruktor fuellt die JList CommandListe ueber die Methode createList mit den Namen der Command-Befehle.
	 */
	public GUI_CommandTypesList() {
		CommandListe = new JList<String>(this.createList());		// eine Liste erstellen ueber private Methode createList()		
		CommandListe.addListSelectionListener(this); 			// uebergibt sich selbst als Listener, weil diese Klasse ein ListSelectionListener ist
										//		(wurde implementiert)
			
		JScrollPane listscroll = new JScrollPane(CommandListe, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,	// Scrollbar einrichten, die die Liste horizontal
							 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		//	und vertikal scrollbar macht.
		listscroll.setPreferredSize(new Dimension(100, 400));
		this.add(listscroll);
		CommandListe.setVisible(true);	
	}
	
	/**
	 * Methode, um die Command-Befehle in ein String-Array einzufuegen, welches dann angezeigt wird.
	 * @return CommandBefehle Liste der Command-Befehle
	 */
	private String[] createList() {
		commandTypes = cm.getCommandTypes();				// Nimmt sich die CommandType-Objekte aus dem ControlModel cm
		for (int i = 0; i < 4; i++) {					// Mithilfe von toString() werden die CommandTypes als Strings in
			CommandBefehle[i] = commandTypes[i].toString();		//	CommandBefehle rein geschrieben.
		};
		return CommandBefehle;
	}
	
	/**
	 * Methode aus dem Interface ListSelectionListener, die immer aufgerufen wird, wenn die Auswahl in der JList sich geaendert hat.
	 * Sie uebergibt hier den Namen des ausgewaehlten Commands der Klasse GUI_konfiguration
	 */
	public void valueChanged(ListSelectionEvent arg0) {
		GUI_konfiguration.getInstance().select(CommandListe.getSelectedValue());		
	}	
}

	

