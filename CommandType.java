/**
 * 
 * @author Kai Heckl
 *
 */
public class CommandType {

	private String name;
	
	/**
	 * Standardkonstruktor: Macht einen leeren Namen, wenn kein Name uebergeben wird.
	 */
	public CommandType()
	{
		name = "";
	}
	
	/**
	 * Konstruktor, der einen Namen übergeben bekommt und diesen der privaten Variable String name zuordnet.
	 * @param name Name des Commands
	 */
	public CommandType(String name)
	{
		this.name = name;
	}
	
	/**
	 * get-Methode zum uebergeben des Namens.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set-Methode zum aendern des Namens.
	 * @param name Name des Command-Befehls
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Methode createInstance() erzeugt je nach Name das zugehörige Objekt
	 * @return new Direction("Direction") bzw. Gear, Repetition, Pause.
	 */
	public Command createInstance()
	{
		if(name == "Direction")
			return new Direction("Direction");
		if(name == "Gear")
			return new Gear("Gear");
		if(name == "Repetition")
			return new Repetition("Repetition");
		if(name == "Pause")
			return new Pause("Pause");
		return null;	
		
	}

}
