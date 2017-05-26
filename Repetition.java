import hsrt.mec.controldeveloper.core.com.command.IRepetition;

//Aufgabenblatt 1
//Aufgabe 2

/**
* Klasse Repetition enthaelt Informationen zur Anzahl der Schritte und deren Wiederholung
* 
* @author ALex, Kai, Marcel
*
*/

public class Repetition extends Command implements IRepetition {
	
	private int nrSteps = 0;
	private int nrRepetitions = 0;
	
	/**
	 * Konstruktor muss den Namen des Command-Befehls uebergeben bekommen.
	 * @param name Name des Command-Befehls
	 */
	
	Repetition(String name) {
		super(name);
	}
	
	/**
	 * Konstruktor muss Namen, Anzahl der Schritte und Anzahl der Wiederholung uebergeben bekommen
	 * @param name Name des Command-Befehls
	 * @param steps Anzahl der Schritte
	 * @param repetitions Anzahl der Wiederholungen
	 */
	
	Repetition(String name, int steps, int repetitions) {
		super(name);
		setNrSteps(steps);
		setNrRepetitions(repetitions);
	}
	
	/**
	 * Bekommt die Anzahl der zu wiederholenden Schritte uebergeben.
	 * @param nrSteps Anzahl an Schritten
	 */
	public void setNrSteps(int nrSteps) {
		this.nrSteps = nrSteps;
	}
	
	/**
	 * Gibt die Anzahl der zu wiederholenden Schritte zurueck.
	 * @return nrSteps
	 */
	
	public int getNrSteps() {
		return nrSteps;
	}
	
	/**
	 * Bekommt die Anzahl der auszufuehrenden Wiederholungen uebergeben.
	 * @param nrRepetitions Anzahl der Wiederholungen
	 */
	
	public void setNrRepetitions(int nrRepetitions) {
		this.nrRepetitions = nrRepetitions;
	}
	
	/**
	 * Gibt die Anzahl der auszufuehrenden Wiederholungen zurueck.
	 * @return nrRepetitions
	 */
	
	public int getNrRepetitions() {
		return nrRepetitions;
	}

	
	public String toString() {
		return "Repetition [getNrSteps()=" + getNrSteps()
				+ ", getNrRepetitions()=" + getNrRepetitions() + "]";
	}
	
}
