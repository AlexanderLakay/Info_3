/**
 * Aufgabenblatt 1
 * Aufgabe 2
 * @author Kai Heckl
 *
 */


public abstract class Command implements ICommand {				// erbt vom Interface (entspricht Header-Datei) ICommand
	private String name;
	/**
	 * Konstruktor muss einen String name übergeben bekommen.
	 * @param name Name des Befehls
	 */
	Command(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	/**
	 * Get-Methode gibt den namen des Commands zurück.
	 * @return name 
	 */
}
