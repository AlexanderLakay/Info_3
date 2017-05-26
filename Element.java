//Aufgabenblatt 1
//Aufgabe 4

/**
 * Klasse Element stellt die Elemente der verketteten Liste da
 * 
 * @author Alex, Kai, Marcel
 * 
 */

public class Element {

	private Element next = null;		// Standardmaessig mit NULL initialisiert
	private Element prev = null;		// ebenso zu Beginn NULL
	private Command element;			// Command-Objekt, dass an der Liste haengt
	
	/**
	 * Jedes Listenelement benoetigt einen Command-Befehl um erzeugt zu werden.
	 * @param c Name des Command-Befehls
	 */
	
	public Element(Command c) {
		element = c;
	}
	
	/**
	 * Setzt die Instanzvariable element (also den Command-Befehl der Klasse) auf das uebergebene Command-Element.
	 * @param c Name des Command-Befehls
	 */
	
	public void setElement(Command c) {
		element = c;
	}
	
	/**
	 * Gibt das jeweilige Element zurueck.
	 * @return element
	 */
	
	public Command getElement() {
		return element;
	}
	
	/**
	 * Gibt die Instanzvariable next der Klasse zurueck.
	 * @return next
	 */
	
	public Element getNext() {
		return next;
	}
	
	/**
	 * Setzt die Instanzvariable next der Klasse auf das uebergebene Element.
	 * @param e uebergebenes Element
	 */
	
	public void setNext(Element e) {
		next = e;
	}
	
	/**
	 * Gibt die Instanzvariable prev der Klasse zurueck.
	 * @return prev
	 */
	
	public Element getPrev() {
		return prev;
	}
	
	/**
	 * Setzt die Instanzvariable prev der Klasse auf das uebergebene Element.
	 * @param e uebergebenes Element
	 */
	
	public void setPrev(Element e) {
		prev = e;
	}
	
	/**
	 * Gibt den an das Listenelement angehaengten Command-Befehl zurueck.
	 * @return element
	 */
	
	public Command getCommand() {
		return element;
	}
	
}
