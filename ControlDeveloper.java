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
		hauptfenster.setLayout(new BorderLayout());
		hauptfenster.setSize(800, 500);
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
		JPanel panelList = new JPanel();
		panelList.add(CTL);
		//panelList.setSize(40, 60);
		panelList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));	
		hauptfenster.add(panelList, BorderLayout.WEST);
		

	//Ausgabefenster
		
		JTextArea tA = new JTextArea();
		tA.setPreferredSize( new Dimension(800, 100));
		JPanel panelAusgabe = new JPanel();
		panelAusgabe.add(tA);
		panelAusgabe.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		hauptfenster.add(panelAusgabe, BorderLayout.SOUTH);
		
		
	//Übersicht des Programmablaufs
		
		
		JPanel panelAblauf = GUI_Ablauf.getInstance();
		hauptfenster.add(panelAblauf, BorderLayout.CENTER);
		
		
	//Übersicht der Konfiguration
		
		JPanel konfig = GUI_konfiguration.getInstance();
		hauptfenster.add(konfig, BorderLayout.EAST);
		
		
	//Fenster sichtbar und schließen 
		
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
