import hsrt.mec.controldeveloper.core.com.command.IPause;

//Aufgabenblatt 1
//Aufgabe 2

/**
* Klasse Pause enthaelt Inforationen zur Dauer der Pause
* 
* @author Alex, Kai, Marcel
*
*/

public class Pause extends Command implements IPause {
	
	private double duration = 0;
	
	/**
	 * Konstruktor muss den Namen des Command-Befehls uebergeben bekommen.
	 * @param name Name des Command-Befehls
	 */
	
	Pause(String name) {
		super(name);
	}
	
	/**
	 * Konstruktor muss Namen und Dauer uebergeben bekommen
	 * @param name Name des Command-Befehls
	 * @param duration Dauer-Angabe
	 */
	
	Pause(String name, double duration) {
		super(name);
		setDuration(duration);
	}
	
	/**
	 * Bekommt den Dauer-Wert als Double uebergeben.
	 * @param duration Dauer-Angabe
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	/**
	 * Gibt den Dauer-Wert zurueck.
	 * @return duration
	 */
	
	public double getDuration() {
		return duration;
	}
	

	
	public String toString() {
		return "Pause [getDuration()=" + getDuration() + ", getName()=" + getName() + "]";
	}

}	
