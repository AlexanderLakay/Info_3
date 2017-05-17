import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

import java.io.File;
import java.util.Vector;


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
		controlProcess = new CommandList();
		
		return false;
	}
	
	// Noch nicht fertig
	public boolean save(File f)
	{
		IOType ausgabe = new TextFile(f, false);
		
		int i = 0;
		boolean ende = false;
		while(!ende){
			Command c = controlProcess.get(i);
			Vector daten = new Vector();
			
			if(c.getName() == "Direction"){
				daten.add(c.getName());
				daten.add(Double.toString(((Direction) c).getDegree()));
			}
			
			if(c.getName() == "Gear"){
				
			}
			
			if(c.getName() == "Repetition"){
				
			}
			
			if(c.getName() == "Pause"){
				
			}
			
			ausgabe.write(daten);
			
		}
		
		ausgabe.close();
		return false;
	}
	
	public void commandPerformed(Command c)
	{
		
		
	}
	
	public CommandList getControllProcess()
	{
		return controlProcess;
	}

}
