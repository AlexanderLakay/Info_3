import hsrt.mec.controldeveloper.core.com.command.IPause;

/**
 * Aufgabenblatt 1
 * Aufgabe 2
 * @author Kai Heckl
 *
 */
public class Pause extends Command implements IPause {
	private double duration = 0;
	/**
	 * Konstruktor muss den Namen des Command-Befehls �bergeben bekommen.
	 * @param name Name des Command-Befehls
	 */
	Pause(String name) {
		super(name);
	}
	/**
	 * Gibt den Dauer-Wert zur�ck.
	 * @return duration
	 */
	
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration;
	}
	/**
	 * Bekommt den Dauer-Wert als Double �bergeben.
	 * @param duration Dauer-Angabe
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	
	public String toString() {
		return "Pause [getDuration()="
				+ getDuration() + ", getName()=" + getName() + "]";
	}

}	
