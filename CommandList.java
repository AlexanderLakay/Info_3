/**
 * Aufgabenblatt 1
 * Aufgabe 4
 * @author Kai Heckl
 *
 */
public class CommandList {

	private Element root;
	
	public CommandList () {
		root = null;
	}
	/**
	 * Zum Hinzufügen von neuen Listenelementen muss ein Command-Objekt c übergeben werden.
	 * @param c Name des Command-Objekts
	 * Wenn add ausgeführt wurde, wird true zurück gegeben.
	 * @return true
	 */
	public boolean add(Command c) {		// NEUES ELEMENT HINZUFÜGEN
				
		if (root == null) {				// Wenn root das erste Element ist, bekommt root
			root = new Element(c);		// 		den Command c zugewiesen.
		}
		else {	
			Element tmp = root;
			while(tmp.getNext() != null) {	// läuft Liste durch, bis letztes Element gefunden ist
				tmp = tmp.getNext();
			}								// Wenn Schleife beendet, ist tmp mein letztes Element.
											// 		Dann kann an dieser Stelle ein neues Element er-
			Element neu = new Element(c);	//		zeugt werden. Das neue Element steht dann hinter
			tmp.setNext(neu);				//		tmp, daher tmp.next = neu und neu.prev = tmp.
			neu.setPrev(tmp);
		}
		
		return true;
	}
	/**
	 * remove bekommt die Stelle des zu löschenden Listenelementes übergeben.
	 * @param pos Angabe der Position
	 * Bei erfolgreichem Löschen wird true zurück gegeben, andernfalls false.
	 * @return true
	 */
	public boolean remove(int pos) {		// ELEMENT AN STELLE POS ENTFERNEN
		
		if(pos == 0) {
			root = root.getNext();
			return true;
		}
		if(pos < 0) {
			return false;
		}
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// Fängt beim root-Element an die Liste zu durchlaufen				
			
			if (tmp.getNext() != null)	
				tmp = tmp.getNext();
				// Wenn während der for-Schleife das Listenende erreicht	
			else
				return false;				//		ist, wird false als Fehlermeldung zurückgegeben.
		}									// Am Ende der for-Schleife ist tmp das Element, das
											// 		gelöscht werden soll.
				//		Elements anpassen, sodass tmp raus fliegt
		
		if(tmp.getNext() != null){
			tmp.getPrev().setNext(tmp.getNext());		// Next und prev des vorherigen und des nächsten
			tmp.getNext().setPrev(tmp.getPrev());
		}else{
			tmp.getPrev().setNext(null);
			tmp = null;
		}
			
		return true;
		
		// ÄNDERUNG: LÖSCHEN VOM LETZTEN ELEMENT!!
	}
	/**
	 * get gibt dasjenige Listenelement zurück, dessen Position übergeben wurde.
	 * @param pos Angabe der Position
	 *       
	 * @return tmp.getElement()
	 */
	public Command get(int pos) {			// COMMAND-OBJEKT DES ELEMENTS AN POSITION POS ZURÜCKGEBEN
		
		if(pos < 0) {
			return null;
		}
		Element tmp = root;					// Läuft wie oben die Liste bis zur angegebenen Position
		for (int i = 0; i < pos; i++) {		//		pos durch. Listenende vor pos gibt ein return
						// 		null. Am Ende der for-Schleife ist tmp mein 
			if (tmp.getNext() != null)	
				tmp = tmp.getNext();
										//		Element an der Stelle pos.
			else
				return null;
		}
		
		return tmp.getElement();			// Gibt das Command-Element, das an diesem Listenelement
	}										//		hängt zurück.
	
	// ÄNDERUNG: WAS IST WENN POS > LÄNGE LISTE!!
	
	/**
	 * moveUp rückt das Listenelement mit der übergebenen Position um einen Platz weiter hoch.
	 * @param pos Angabe der Position
	 * Zurückgegeben wird true wenn das Verschieben erfolgreich war, andernfalls false.
	 * @return true
	 */
	public boolean moveUp(int pos) {		// ELEMENT AN POSITION POS EINS HOCH VERSCHIEBEN
		
		// IDEE: Nicht die Liste selber wird verändert, sondern nur die Commands, die an der Liste 
		//		 hängen werden vertauscht.
		
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// Fängt wie obenbeim root-Element an die Liste 
			tmp = tmp.getNext();			//		zu durchlaufen				
			if (tmp == null)				// Wenn während der for-Schleife das Listenende erreicht				
				return false;				//		ist, wird false als Fehlermeldung zurückgegeben.
		}
		
		if(tmp.getPrev() == null)			// Wenn tmp das erste Listenelement ist, wird nichts
			return true;					//		gemacht.
		
		Element davor = tmp.getPrev();		// Hilfs-"Zeiger" auf die Listenelemente vor tmp	
		Command commandFesthalten;
		
		commandFesthalten = davor.getElement();
		davor.setElement(tmp.getCommand()); 	// Command von tmp wird an davor gehängt
		tmp.setElement(commandFesthalten); 		// Command von davor wird an tmp gehängt
		
		return true;
	}
	/**
	 * moveDown funtkioniert analog zu moveUp.
	 * @see moveUp
	 * @param pos Angabe der Position
	 *     
	 * @return true
	 */
	public boolean moveDown(int pos) {
		
		// IDEE: Nicht die Liste selber wird verändert, sondern nur die Commands, die an der Liste 
		//		 hängen werden vertauscht.
				
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// Fängt wie obenbeim root-Element an die Liste 
			tmp = tmp.getNext();			//		zu durchlaufen				
			if (tmp == null)				// Wenn während der for-Schleife das Listenende erreicht				
				return false;				//		ist, wird false als Fehlermeldung zurückgegeben.
		}
		
		if(tmp.getNext() == null)			// Wenn tmp das letzte Listenelement ist, wird nichts
			return true;					//		gemacht.
		
		Element danach = tmp.getNext();		// Hilfs-"Zeiger" auf die Listenelemente hinter tmp	
		Command commandFesthalten;
		
		commandFesthalten = danach.getElement();
		
		danach.setElement(tmp.getCommand()); 	// Command von tmp wird an danach gehängt
		tmp.setElement(commandFesthalten); 		// Command von danach wird an tmp gehängt
		
		return true;
	}
}
