import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * Aufgabenblatt 1
 * Aufgabe 2
 * @author Kai Heckl
 *
 */
public class Gear extends Command implements IGear {
	
	private int speed = 0;
	private double duration = 0;
/**
 * Konstruktor bekommt den Namen des Gear-Befehls �bergeben.
 * @param name Name des Command-Befehls
 */
	Gear(String name) {
		super(name);
	}
	/**
	 * Geschwindigkeits-Angabe wird als Integer-Wert �bergeben.
	 * @param speed Geschwindigkeits-Angabe
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * Dauer-Angabe wird als Double-Wert �bergeben.
	 * @param duration Dauer-Angabe
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	/**
	 * Gibt den Geschwindigkeits-Wert zur�ck.
	 * @return speed 
	 */
	
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	/**
	 * Gibt den Dauer-Wert zur�ck.
	 * @return duration
	 */
	
	public double getDuration() {
		// TODO Auto-generated method stub
		return duration;
	}

	
	public String toString() {
		return "Gear [getSpeed()=" + getSpeed() + ", getDuration()="
				+ getDuration() + "]";
	}
	
}
