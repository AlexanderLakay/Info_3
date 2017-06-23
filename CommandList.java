import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Klasse CommandList stellt eine verkettete Liste zum Einfuegen, Loeschen, Verschieben und 
 * Finden der Command-Befehle dar.
 * 
 * @author Kai Heckl
 *
 */
public class CommandList {

	private Element root;
	
	public CommandList () {
		root = null;
	}
	/**
	 * Zum Hinzufuegen von neuen Listenelementen muss ein Command-Objekt c uebergeben werden.
	 * @param c Name des Command-Objekts
	 * Wenn add ausgefuehrt wurde, wird true zurueck gegeben, im Fehlerfall false.
	 * @return true
	 */
	public boolean add(Command c) {			// NEUES ELEMENT HINZUF�GEN
					
		if(c == null)						// Default-Fall
			return false;
		
			if (root == null) {					// Wenn root das erste Element ist, bekommt root
				root = new Element(c);			// 		den Command c zugewiesen.
			}
			else {	
				Element tmp = root;
				while(tmp.getNext() != null) {	// laeuft Liste durch, bis letztes Element gefunden ist
					tmp = tmp.getNext();
				}								// Wenn Schleife beendet, ist tmp mein letztes Element.
												// 		Dann kann an dieser Stelle ein neues Element er-
			Element neu = new Element(c);		//		zeugt werden. Das neue Element steht dann hinter
			tmp.setNext(neu);					//		tmp, daher tmp.next = neu und neu.prev = tmp.
			neu.setPrev(tmp);
			}
		return true;
	}
	
	/**
	 * remove bekommt die Stelle des zu loeschenden Listenelementes uebergeben.
	 * @param pos Angabe der Position
	 * Bei erfolgreichem Loeschen wird true zurueck gegeben, andernfalls false.
	 * @return true
	 */
	public boolean remove(int pos) {		// ELEMENT AN STELLE POS ENTFERNEN
		
		if(pos == 0) {
			if(root.getNext() != null)						// Wenn erstes Element geloescht werden soll, wird root
				root = root.getNext();
			else
				root = null;

			return true;					//		gesetzt ("null").
		}
		if(pos < 0) {						// Fehlerfall: Ung�ltige pos-Angabe
			return false;
		}
		
		// F�r den Fall, dass keiner der oberen Faelle zutrifft, macht er hier weiter:
		
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// Faengt beim root-Element an die Liste mit tmp zu durchlaufen.			
			
			if (tmp.getNext() != null)	
				tmp = tmp.getNext();		// Wenn waehrend der for-Schleife das Listenende erreicht								
			else							//		ist, wird false als Fehlermeldung zurueckgegeben, da
				return false;				// 		die pos-Angabe dann fehlerhaft war.
		}									// Am Ende der for-Schleife ist tmp das Element, das
											// 		geloescht werden soll.		
		
		if(tmp.getNext() != null) {			// Wenn Element nicht am Ende der Liste steht.
			tmp.getPrev().setNext(tmp.getNext());		// Element vor tmp bekommt als next das Element nach tmp.
			tmp.getNext().setPrev(tmp.getPrev());		// Element nach tmp bekommt als prev das Element vor tmp.
		}
		else {								// Wenn tmp das letzte Element ist, bekommt das Element vor tmp
			tmp.getPrev().setNext(null);	//		null als next.
			tmp = null;
		}
			
		return true;		
	}
	
	/**
	 * get gibt das Command-Objekt desjenigen Listenelements zurueck, dessen Position uebergeben wurde.
	 * Im Fehlerfall wird null zurueckgegeben.
	 * @param pos Angabe der Position
	 *       
	 * @return tmp.getElement()
	 */
	public Command get(int pos) {			// COMMAND-OBJEKT DES ELEMENTS AN POSITION POS ZURUECKGEBEN
		
		if(pos < 0) {						// Default-Fall: ungueltige pos-Angabe.
			return null;
		}
		Element tmp = root;					// Laeuft wie oben die Liste bis zur angegebenen Position
		for (int i = 0; i < pos; i++) {		//		pos durch. Listenende vor pos gibt ein return
											// 		null. Am Ende der for-Schleife ist tmp mein 
											//		Element an der Stelle pos.
			if (tmp.getNext() != null)				
				tmp = tmp.getNext();
			else							// Fehler-Fall: ungueltige pos-Angabe (zu gross)
				return null;		
		}		
		if(tmp == null)
			return null;
		return tmp.getElement();			// Gibt das Command-Objekt, das an tmp haengt zurueck.
	}									
	
	/**
	 * moveUp rueckt das Listenelement mit der uebergebenen Position um einen Platz weiter hoch.
	 * @param pos Angabe der Position
	 * Zurueckgegeben wird true wenn das Verschieben erfolgreich war, andernfalls false.
	 * @return true
	 */
	public boolean moveUp(int pos) {		// ELEMENT AN POSITION POS EINS HOCH VERSCHIEBEN
		
		return moveDown(pos-1);				// IDEE: moveUp ist ein moveDown des vorherigen Elements
	
		
		
	/*	// IDEE: Nicht die Liste selber wird veraendert, sondern nur die Commands, die an der Liste 
		//		 haengen werden vertauscht.
		
		if (pos < 0)						// Fehlerfall: ungueltige pos-Angabe
			return false;
		
		Element tmp = root;	
		
		if(tmp.getPrev() == null)			// Wenn tmp das erste Listenelement ist, wird nichts
			return true;					//		gemacht.
		
		for (int i = 0; i < pos; i++ ) {	// Faengt wie oben beim root-Element an die Liste 
			tmp = tmp.getNext();			//		zu durchlaufen				
			if (tmp == null)				// Wenn waehrend der for-Schleife das Listenende erreicht				
				return false;				//		ist, wird false als Fehlermeldung zurueckgegeben.
		}
		
		Element davor = tmp.getPrev();		// Hilfs-"Zeiger" auf das Listenelement vor tmp	
		Command commandFesthalten;			// Hilfs-"Zeiger" auf das Command-Objekt
		
		commandFesthalten = davor.getElement();
		davor.setElement(tmp.getCommand()); 	// Command von tmp wird an davor gehaengt
		tmp.setElement(commandFesthalten); 		// Command von davor wird an tmp gehaengt
		
		return true; */
	}
	/**
	 * moveDown funtkioniert analog zu moveUp.
	 * @see moveUp
	 * @param pos Angabe der Position
	 *     
	 * @return true
	 */
	public boolean moveDown(int pos) {
		
		// IDEE: Nicht die Liste selber wird veraendert, sondern nur die Commands, die an der Liste 
		//		 haengen werden vertauscht.
		
		if (pos < 0)
			return false;					// Fehlerfall: ungueltige pos-Angabe.
		
		Element tmp = root;	
		for (int i = 0; i < pos; i++ ) {	// Faengt wie obenbeim root-Element an die Liste 
			tmp = tmp.getNext();			//		zu durchlaufen				
			if (tmp == null)				// Wenn waehrend der for-Schleife das Listenende erreicht				
				return false;				//		ist, wird false als Fehlermeldung zurueckgegeben.
		}
		
		if(tmp.getNext() == null)			// Wenn tmp das letzte Listenelement ist, wird nichts
			return true;					//		gemacht.
		
		Element danach = tmp.getNext();		// Hilfs-"Zeiger" auf die Listenelemente hinter tmp	
		Command commandFesthalten;
		
		commandFesthalten = danach.getElement();
		
		danach.setElement(tmp.getCommand()); 	// Command von tmp wird an danach gehaengt
		tmp.setElement(commandFesthalten); 		// Command von danach wird an tmp gehaengt
		
		return true;
	}
	
	/**
	 * Aendert das ueberschreibt das Listenelement an der Stelle index mit c
	 * @param index Position des zu aendernden Elements
	 * @param c Neues Command
	 * @return True bei Erfolg, sonst False
	 */
	public boolean setCommand(int index, Command c)
	{
		if(index < 0 || c == null) {						// Default-Fall: ungueltige pos-Angabe.
			return false;
		}
		Element tmp = root;					// Laeuft wie oben die Liste bis zur angegebenen Position
		for (int i = 0; i < index; i++) {		//		pos durch. Listenende vor pos gibt ein return
											// 		null. Am Ende der for-Schleife ist tmp mein 
											//		Element an der Stelle pos.
			if (tmp.getNext() != null)				
				tmp = tmp.getNext();
			else							// Fehler-Fall: ungueltige pos-Angabe (zu gross)
				return false;		
		}		
		if(tmp == null)
			return false;
		tmp.setElement(c);
		return true;
		
		
	}
}
