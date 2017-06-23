import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;


/**
 * main-Programm zum Ausfuehren und Testen der Klassen.
 * main-GUI
 * 
 * @author Alex, Kai, Marcel
 *									
 */

public class ControlDeveloper extends JFrame {

	private static String name = "Control-Developer";
	private static Command commands[] = new Command[4];
	private static ControlModel cm = ControlModel.getInstance();

	
	public static void testCommands () {			
		commands[0] = new Direction("Direction", 90);			// erzeuge hier Objekte vom Typ der jeweiligen Klassen, speichere diese
		commands[1] = new Gear("Gear", 100, 10);				// 		nacheinander in das Array.
		commands[2] = new Repetition("Repetition",3, 10);
		commands[3] = new Pause("Pause", 30);				
	}
	
	
	public static void main(String[] args) {
	
	//GUI-Programmierung
		
		JFrame hauptfenster = new JFrame ("Steuerung Fahrzeug");
		JPanel hauptpanel = new JPanel();
		hauptfenster.setLayout(new BorderLayout());
		hauptfenster.setSize(800, 650);
		hauptfenster.setLocationRelativeTo(null);
		hauptfenster.setResizable(true);
		
	
		
	//Menu_Bar
		
		GUI_menubar mb = new GUI_menubar();
		JPanel panelMenuBar = new JPanel();
		panelMenuBar.add(mb);
		panelMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		hauptfenster.add(panelMenuBar, BorderLayout.NORTH);
		
		
	//CommandTypes_Liste
		
		GUI_CommandTypesList CTL = new GUI_CommandTypesList();
		JPanel panelList = new JPanel(new BorderLayout());
		panelList.add(CTL, BorderLayout.NORTH);
		//panelList.setSize(40, 60);
		//panelList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));	
		
		panelList.add(PortList.getInstance(), BorderLayout.SOUTH);
		
		hauptpanel.add(panelList, BorderLayout.WEST);

	//Ausgabefenster
		
		JPanel panelAusgabe = GUI_ausgabe.getInstance();
		panelAusgabe.setPreferredSize(new Dimension (hauptfenster.getWidth(), 
											((hauptfenster.getHeight()/100)*18)));
		hauptfenster.add(panelAusgabe, BorderLayout.SOUTH);
		
		
	//Übersicht des Programmablaufs
		
		JPanel panelAblauf = GUI_Ablauf.getInstance();
		//panelAblauf.setPreferredSize(new Dimension (((hauptfenster.getWidth()/100)*50), 
										//((hauptfenster.getHeight()/100)*70)));
		hauptpanel.add(panelAblauf, BorderLayout.CENTER);
		
		
	//Übersicht der Konfiguration
		
		JPanel konfig = GUI_konfiguration.getInstance();
		hauptpanel.add(konfig, BorderLayout.EAST);
		
		
		
	//Fenster sichtbar und schließen 
		
		hauptfenster.add(hauptpanel, BorderLayout.CENTER);
		hauptfenster.setMinimumSize(new Dimension(820,620));
		hauptfenster.setMaximumSize(new Dimension(820,620));
		hauptfenster.setVisible(true);
		hauptfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	
		
		
		
		
		
	}
	
	// get-Methode: Gibt den Namen zurueck
	public static String getname () {				
		return name;
	}
	
	public static void setname (String neuerName) {				// set-Methode: Bekommt neuen Namen uebergeben und 
		name = neuerName;						 				//		ueberschreibt alten Namen damit.
	}
	

	
	
}

// Wozu dient der Modifizierer static?
//
// "static" kennzeichnet eine Klassenvariable. Diese wird einmalig pro Klasse (nicht Objekt!) angelegt.
