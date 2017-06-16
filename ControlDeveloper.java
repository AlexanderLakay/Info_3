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
		//panelMenuBar.setBounds(0, 0, 800, 20);;
		//panelMenuBar.setVisible(true);
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
		
		JPanel panelAblauf = new JPanel();
		JButton pA = new JButton("Hier nachher Programmablauf!");
		pA.setPreferredSize(new Dimension(450, 400));
		panelAblauf.add(pA);
		hauptfenster.add(panelAblauf, BorderLayout.CENTER);
		
		
	//Übersicht des Programmablaufs
		
		JPanel panelKonfig = new JPanel();
		JButton pK = new JButton("Hier nachher Konfiguration!");
		pK.setPreferredSize(new Dimension(150, 400));
		panelAblauf.add(pK);
		hauptfenster.add(panelKonfig, BorderLayout.EAST);
		
		
	//Fenster sichtbar und schließen 
		
		hauptfenster.setVisible(true);
		hauptfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//////////////////////////
		
		// Array befuellen
		testCommands();
		//printCommands();
		

		
		for (int i = 0; i < 4; i++) {
			cm.add(commands[i]);		// Befehlsliste aus Array befuellen
			
		}
	
	
		// Testen von speichern und Laden
		File daten = new File("daten.txt");
		cm.save(daten);
		//cm.load(daten);
		
		
		// Befehlsliste ausgeben
		for (int i = 0; i < 5; i++) {
			if(cm.get(i) instanceof Command)
				System.out.println(cm.get(i).toString());
		}
		
	}
	
	// get-Methode: Gibt den Namen zurueck
	public static String getname () {				
		return name;
	}
	
	public static void setname (String neuerName) {	// set-Methode: Bekommt neuen Namen uebergeben und 
		name = neuerName;						 	//		ueberschreibt alten Namen damit.
	}
	
	public static void testCommands () {			
		commands[0] = new Direction("Direction", 90);	// erzeuge hier Objekte vom Typ der jeweiligen Klassen, speichere diese
		commands[1] = new Gear("Gear", 100, 10);				// 		nacheinander in das Array.
		commands[2] = new Repetition("Repetition",3, 10);
		commands[3] = new Pause("Pause", 30);				
	}
	
	public static void printCommands() {
		for(int i = 0; i < 4; i++) {
			System.out.println(commands[i].toString());
		}
	}
}

// Wozu dient der Modifizierer static?
//
// "static" kennzeichnet eine Klassenvariable. Diese wird einmalig pro Klasse (nicht Objekt!) angelegt.
