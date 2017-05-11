/**
 * Aufgabenblatt 1
 * Aufgabe 1, 3
 * 
 * main-Programm zum Ausführen und Testen der Klassen.
 * 
 * @author Kai Heckl
 *									
 */

public class ControlDeveloper {

	private static String name = "Control-Developer";
	private static Command commands[] = new Command[4];			// Array, das "commands[]" heißt und den Datentyp Command[4] hat
	private static CommandList commandList;						
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(name);				// direkte Ausgabe
		//System.out.println(getname());		// Ausgabe über get-Methode
		testCommands();
		printCommands();
		
		commandList = new CommandList();
		
		for (int i = 0; i < 4; i++) {			// CommandList mit Befehlen aus dem command[]-
			commandList.add(commands[i]);		//		 Array befüllen.
			
		}
		//commandList.get(3);
		
		commandList.add(commands[1]);
		commandList.remove(3);
		commandList.get(3);
		
		for (int i = 0; i < 5; i++) {
			if(commandList.get(i) instanceof Command)
				System.out.println(commandList.get(i).toString());
		}
		
	}
	
	public static String getname () {				// get-Methode: Gibt den Namen zurück
		return name;
	}
	
	public static void setname (String neuerName) {	// set-Methode: Bekommt neuen Namen übergeben und 
		name = neuerName;						 	//		überschreibt alten Namen damit.
	}
	
	public static void testCommands () {			
		commands[0] = new Direction("direction");	// erzeuge hier Objekte vom Typ der jeweiligen Klassen, speichere diese
		commands[1] = new Gear("gear");				// 		nacheinander in das Array.
		commands[2] = new Repetition("repetition");
		commands[3] = new Pause("pause");				
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