/**
 * Aufgabenblatt 1
 * Aufgabe 1
 * @author Kai Heckl
 *
 */
public class Direction extends Command implements IDirection {		// erbt von Command, implementiert Interface IDirection
	private int degree = 0;					// zur Fehlervermeidung mit 0 initialisiert
	/**
	 * Konstruktor muss den Namen des Command-Befehls �bergeben bekommen.
	 * @param name Name des Command-Befehls
	 */
	Direction (String name) {				// Konstruktor
		super(name);						// nimmt den super-Namen, weil die Klasse selber keine Variable name hat.	
	}
	/**
	 * Winkel-Angabe wird als Integer-Wert �bergeben.
	 * @param i Winkel-Angabe
	 */
	public void setDegree (int i) {
		degree = i;
	}
	/**
	 * Gibt den Winkel-Wert zur�ck.
	 * @return degree
	 */
	public int getDegree() {
		return degree;
	}

	
	public String toString() {														// gibt aktuellen Zustand des Objects zur�ck
		return "Direction [degree=" + degree + ", getDegree()=" + getDegree()
				+ ", getName()=" + getName() + "]";
	}
	
}
