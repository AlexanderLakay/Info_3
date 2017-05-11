/**
 * Aufgabenblatt 1
 * Aufgabe 4
 * 
 * Elemente der verketteten Liste.
 * 
 * @author Kai Heckl
 *
 */
public class Element {

	private Element next = null;		// Standardm��ig mit NULL initialisiert
	private Element prev = null;		// ebenso zu Beginn NULL
	private Command element;			// Command-Objekt, dass an der Liste h�ngt
	/**
	 * Jedes Listenelement ben�tigt einen Command-Befehl um erzeugt zu werden.
	 * @param c Name des Command-Befehls
	 */
	public Element(Command c) {
		element = c;
	}
	/**
	 * Gibt das jeweilige Element zur�ck.
	 * @return element
	 */
	public Command getElement() {
		return element;
	}
	/**
	 * Gibt die Instanzvariable next der Klasse zur�ck.
	 * @return next
	 */
	// Getter und Setter, damit CommandList auf next und prev zugreifen kann
	public Element getNext() {
		return next;
	}
	/**
	 * Setzt die Instanzvariable next der Klasse auf das �bergebene Element.
	 * @param e �bergebenes Element
	 */
	public void setNext(Element e) {
		next = e;
	}
	/**
	 * Gibt die Instanzvariable prev der Klasse zur�ck.
	 * @return prev
	 */
	public Element getPrev() {
		return prev;
	}
	/**
	 * Setzt die Instanzvariable prev der Klasse auf das �bergebene Element.
	 * @param e �bergebenes Element
	 */
	public void setPrev(Element e) {
		prev = e;
	}
	/**
	 * Gibt den an das Listenelement angeh�ngten Command-Befehl zur�ck.
	 * @return element
	 */
	public Command getCommand() {
		return element;
	}
	/**
	 * Setzt die Instanzvariable element (also den Command-Befehl der Klasse) auf das �bergebene Command-Element.
	 * @param c Name des Command-Befehls
	 */
	public void setElement(Command c) {
		element = c;
	}
}
