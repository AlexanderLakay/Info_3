import hsrt.mec.controldeveloper.core.com.command.IRepetition;

/**
 * Aufgabenblatt 1
 * Aufgabe 2
 * @author Kai Heckl
 *
 */
public class Repetition extends Command implements IRepetition {
	
	private int nrSteps = 0;
	private int nrRepetitions = 0;
	/**
	 * Konstruktor muss den Namen des Command-Befehls �bergeben bekommen.
	 * @param name Name des Command-Befehls
	 */
	Repetition(String name) {
		super(name);
	}
	/**
	 * Gibt die Anzahl der zu wiederholenden Schritte zur�ck.
	 * @return nrSteps
	 */
	public int getNrSteps() {
		return nrSteps;
	}
	/**
	 * Bekommt die Anzahl der zu wiederholenden Schritte �bergeben.
	 * @param nrSteps Anzahl an Schritten
	 */
	public void setNrSteps(int nrSteps) {
		this.nrSteps = nrSteps;
	}
	/**
	 * Bekommt die Anzahl der auszuf�hrenden Wiederholungen �bergeben.
	 * @param nrRepetitions Anzahl der Wiederholungen
	 */
	public void setNrRepetitions(int nrRepetitions) {
		this.nrRepetitions = nrRepetitions;
	}
	/**
	 * Gibt die Anzahl der auszuf�hrenden Wiederholungen zur�ck.
	 * @return nrRepetitions
	 */
	
	public int getNrRepetitions() {
		// TODO Auto-generated method stub
		return nrRepetitions;
	}

	
	public String toString() {
		return "Repetition [getNrSteps()=" + getNrSteps()
				+ ", getNrRepetitions()=" + getNrRepetitions() + "]";
	}
	
}
