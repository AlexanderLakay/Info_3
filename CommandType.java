
public class CommandType {

	private String name;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public CommandType()
	{
		name = "";
	}
	
	public CommandType(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	/* Keine Ahnung, was er da haben will.
	 * Fragt am besten mal nach.
	 * 
	 * Wenn ich das so richtig verstanden habe, müssen wir noch
	 * Standardkonstruktoren für jede Klasse anlegen.
	 */
	public Command createInstance()
	{
//		if(name == "Direction")
//			return new Direction();
//		if(name == "Gear")
//			return new Gear();
//		if(name == "Repetition")
//			return new Repetition();
//		if(name == "Pause")
//			return new Pause();
		return null;	
		
	}

}
