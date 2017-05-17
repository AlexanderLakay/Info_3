
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
