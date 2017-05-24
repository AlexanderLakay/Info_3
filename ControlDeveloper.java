import java.io.File;

/**
 * Aufgabenblatt 1
 * Aufgabe 1, 3
 * 
 * main-Programm zum Ausf�hren und Testen der Klassen.
 * 
 * @author Kai Heckl
 *									
 */

public class ControlDeveloper {

	private static String name = "Control-Developer";
	private static Command commands[] = new Command[4];			// Array, das "commands[]" hei�t und den Datentyp Command[4] hat
	private static  ControlModel cm = ControlModel.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(name);				// direkte Ausgabe
		//System.out.println(getname());		// Ausgabe �ber get-Methode
		testCommands();
		//printCommands();
		
		
		
		for (int i = 0; i < 4; i++) {			// CommandList mit Befehlen aus dem command[]-
			//cm.add(commands[i]);		//		 Array bef�llen.
			
		}
		//commandList.get(3);
		
		File daten = new File("daten.txt");
		//cm.save(daten);
		cm.load(daten);
		
		
		
		for (int i = 0; i < 5; i++) {
			if(cm.get(i) instanceof Command)
				System.out.println(cm.get(i).toString());
		}
		
	}
	
	public static String getname () {				// get-Methode: Gibt den Namen zur�ck
		return name;
	}
	
	public static void setname (String neuerName) {	// set-Methode: Bekommt neuen Namen �bergeben und 
		name = neuerName;						 	//		�berschreibt alten Namen damit.
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