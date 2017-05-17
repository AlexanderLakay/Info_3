import java.io.File;


public class ControlModel {

	private static ControlModel instance = null;
	private CommandType commandTypes[] = new CommandType[4];
	private CommandList controlProcess = new CommandList();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private ControlModel()
	{
		
	}
	
	public ControlModel getInstance()
	{
		
		if (instance==null)
			instance= new ControlModel();
		return instance;
	}
	
	public void createCommandTyes()
	{
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
		
	}
	
	// Zugriff auf die verkettete Liste
	public boolean add(Command c) 
	{
		return controlProcess.add(c);
	}
	
	public boolean remove(int pos)
	{
		return controlProcess.remove(pos);
	}
	
	public Command get(int pos)
	{
		return controlProcess.get(pos);
	}
	
	public boolean moveUp(int pos)
	{
		return controlProcess.moveUp(pos);
	}
	
	public boolean moveDown(int pos)
	{
		return controlProcess.moveDown(pos);
	}
	
	
	public boolean load(File f)
	{
		return false;
	}
	
	public boolean save(File f)
	{
		
		return false;
	}
	
	public void commandPerformed(Command c)
	{
		
		
	}
	
	public CommandList getControllProcess()
	{
		return null;
	}

}
