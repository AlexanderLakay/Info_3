import hsrt.mec.controldeveloper.core.com.command.IGear;

//Aufgabenblatt 1
//Aufgabe 2

/**
* Klasse Gear enthaelt Inforamtionen zur Geschwidigkeit und Dauer der Bewegung
* 
* @author Alex, Kai, Marcel
*
*/

public class Gear extends Command implements IGear {
	
	private int speed = 0;
	private double duration = 0;
	
	/**
	 * Konstruktor bekommt den Namen des Gear-Befehls uebergeben.
	 * @param name Name des Command-Befehls
	 */
	
	Gear(String name) {
		super(name);
	}
	
	/**
	 * Konstruktor muss den Name, Geschwindigkeit und Dauer uebergeben bekommen
	 * @param name Name des Command-Befehls
	 * @param speed Geschwindigkeits-Angabe
	 * @param duration Dauer-Angabe
	 */
	
	Gear(String name, int speed, double duration) {
		super(name);
		setSpeed(speed);
		setDuration(duration);
	}
	
	/**
	 * Geschwindigkeits-Angabe wird als Integer-Wert uebergeben.
	 * @param speed Geschwindigkeits-Angabe
	 */
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Dauer-Angabe wird als Double-Wert uebergeben.
	 * @param duration Dauer-Angabe
	 */
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	/**
	 * Gibt den Geschwindigkeits-Wert zurueck.
	 * @return speed 
	 */
	
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Gibt den Dauer-Wert zurueck.
	 * @return duration
	 */
	
	public double getDuration() {
		return duration;
	}

	
	public String toString() {
		return "[Gear] speed: " + getSpeed() + ", duration: " + getDuration();
	}
	
}
