import hsrt.mec.controldeveloper.core.com.command.IDirection;

//Aufgabenblatt 1
//Aufgabe 2

/**
* Klasse Direction enthaelt die Winkel-Informationen der Bewegung
* 
* @author Alex, Kai, Marcel
*
*/


public class Direction extends Command implements IDirection {		// erbt von Command, implementiert Interface IDirection
	
	private int degree = 0;					// zur Fehlervermeidung mit 0 initialisiert
	
	/**
	 * Konstruktor muss den Namen des Command-Befehls uebergeben bekommen.
	 * @param name Name des Command-Befehls
	 */
	
	Direction (String name) {				// Konstruktor
		super(name);						// nimmt den super-Namen, weil die Klasse selber keine Variable name hat.	
	}
	
	/**
	 * Konstruktor muss den Namen und eine Winkel-Angabe uebergeben
	 * @param name Name des Command-Befehls
	 * @param i Winkel-Angabe
	 */
	
	Direction (String name, int i) {				// Konstruktor
		super(name);	
		setDegree(i);
	}
	
	/**
	 * Set-Methode, um Winkel-Angabe zu uebergeben
	 * @param degree int-Variable mit Winkel
	 */
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	/**
	 * Gibt den Winkel-Wert zurueck.
	 * @return degree
	 */
	
	public int getDegree() {
		return degree;
	}

	
	public String toString() {														// gibt aktuellen Zustand des Objects zur�ck
		return "Direction [getDegree()=" + getDegree() + ", getName()=" + getName() + "]";
	}
	
}
