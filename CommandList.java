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
	 * Zum Hinzuf�gen von neuen Listenelementen muss ein Command-Objekt c �bergeben werden.
	 * @param c Name des Command-Objekts
	 * Wenn add ausgef�hrt wurde, wird true zur�ck gegeben.
	 * @return true
	 */
	public boolean add(Command c) {		// NEUES ELEMENT HINZUF�GEN
				
		if(c == null)
			return false;
		
		if (root == null) {				// Wenn root das erste Element ist, bekommt root
			root = new Element(c);		// 		den Command c zugewiesen.
		}
		else {	
			Element tmp = root;
			while(tmp.getNext() != null) {	// l�uft Liste durch, bis letztes Element gefunden ist
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
	 * remove bekommt die Stelle des zu l�schenden Listenelementes �bergeben.
	 * @param pos Angabe der Position
	 * Bei erfolgreichem L�schen wird true zur�ck gegeben, andernfalls false.
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
		for (int i = 0; i < pos; i++ ) {	// F�ngt beim root-Element an die Liste zu durchlaufen				
			
			if (tmp.getNext() != null)	
				tmp = tmp.getNext();
				// Wenn w�hrend der for-Schleife das Listenende erreicht	
			else
				return false;				//		ist, wird false als Fehlermeldung zur�ckgegeben.
		}									// Am Ende der for-Schleife ist tmp das Element, das
											// 		gel�scht werden soll.
				//		Elements anpassen, sodass tmp raus fliegt
		
		if(tmp.getNext() != null){
			tmp.getPrev().setNext(tmp.getNext());		// Next und prev des vorherigen und des n�chsten
			tmp.getNext().setPrev(tmp.getPrev());
		}else{
			tmp.getPrev().setNext(null);
			tmp = null;
		}
			
		return true;
		
		// �NDERUNG: L�SCHEN VOM LETZTEN ELEMENT!!
	}
	/**
	 * get gibt dasjenige Listenelement zur�ck, dessen Position �bergeben wurde.
	 * @param pos Angabe der Position
	 *       
	 * @return tmp.getElement()
	 */
	public Command get(int pos) {			// COMMAND-OBJEKT DES ELEMENTS AN POSITION POS ZUR�CKGEBEN
		
		if(pos < 0) {
			return null;
		}
		Element tmp = root;					// L�uft wie oben die Liste bis zur angegebenen Position
		for (int i = 0; i < pos; i++) {		//		pos durch. Listenende vor pos gibt ein return
						// 		null. Am Ende der for-Schleife ist tmp mein 
			if (tmp.getNext() != null)	
				tmp = tmp.getNext();
										//		Element an der Stelle pos.
			else
				return null;
		}
		
		return tmp.getElement();			// Gibt das Command-Element, das an diesem Listenelement
	}										//		h�ngt zur�ck.
	
	// �NDERUNG: WAS IST WENN POS > L�NGE LISTE!!
	
	/**
	 * moveUp r�ckt das Listenelement mit der �bergebenen Position um einen Platz weiter hoch.
	 * @param pos Angabe der Position
	 * Zur�ckgegeben wird true wenn das Verschieben erfolgreich war, andernfalls false.
	 * @return true
	 */
	public boolean moveUp(int pos) {		// ELEMENT AN POSITION POS EINS HOCH VERSCHIEBEN
		
		// IDEE: Nicht die Liste selber wird ver�ndert, sondern nur die Commands, die an der Liste 
		//		 h�ngen werden vertauscht.
		
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// F�ngt wie obenbeim root-Element an die Liste 
			tmp = tmp.getNext();			//		zu durchlaufen				
			if (tmp == null)				// Wenn w�hrend der for-Schleife das Listenende erreicht				
				return false;				//		ist, wird false als Fehlermeldung zur�ckgegeben.
		}
		
		if(tmp.getPrev() == null)			// Wenn tmp das erste Listenelement ist, wird nichts
			return true;					//		gemacht.
		
		Element davor = tmp.getPrev();		// Hilfs-"Zeiger" auf die Listenelemente vor tmp	
		Command commandFesthalten;
		
		commandFesthalten = davor.getElement();
		davor.setElement(tmp.getCommand()); 	// Command von tmp wird an davor geh�ngt
		tmp.setElement(commandFesthalten); 		// Command von davor wird an tmp geh�ngt
		
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
		
		// IDEE: Nicht die Liste selber wird ver�ndert, sondern nur die Commands, die an der Liste 
		//		 h�ngen werden vertauscht.
				
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// F�ngt wie obenbeim root-Element an die Liste 
			tmp = tmp.getNext();			//		zu durchlaufen				
			if (tmp == null)				// Wenn w�hrend der for-Schleife das Listenende erreicht				
				return false;				//		ist, wird false als Fehlermeldung zur�ckgegeben.
		}
		
		if(tmp.getNext() == null)			// Wenn tmp das letzte Listenelement ist, wird nichts
			return true;					//		gemacht.
		
		Element danach = tmp.getNext();		// Hilfs-"Zeiger" auf die Listenelemente hinter tmp	
		Command commandFesthalten;
		
		commandFesthalten = danach.getElement();
		
		danach.setElement(tmp.getCommand()); 	// Command von tmp wird an danach geh�ngt
		tmp.setElement(commandFesthalten); 		// Command von danach wird an tmp geh�ngt
		
		return true;
	}
}
