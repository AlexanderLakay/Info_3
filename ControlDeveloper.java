import java.io.File;

/**
 * Aufgabenblatt 1
 * Aufgabe 1, 3
 * 
 * main-Programm zum Ausfuehren und Testen der Klassen.
 * 
 * @author Kai Heckl
 *									
 */

public class ControlDeveloper {

	private static String name = "Control-Developer";
	private static Command commands[] = new Command[4];
	private static  ControlModel cm = ControlModel.getInstance();
	public static void main(String[] args) {
		
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
