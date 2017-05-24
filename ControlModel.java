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
	
	public static ControlModel getInstance()
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
		Command c = null;
		Vector daten = new Vector();
		IOType eingabe = new TextFile(f, false);
		boolean antwort = eingabe.read(daten);
		eingabe.close();
		
		int i = 0;
		while(true){
			
			if(daten.get(i).toString().equals("Direction")){
				c = new Direction("Direction", Integer.parseInt((daten.get(i+1).toString())));
				i+=2;
				
			}else if(daten.get(i).toString().equals("Gear")){
				c = new Gear("Gear", Integer.parseInt(daten.get(i+1).toString()), Double.parseDouble(daten.get(i+2).toString()));
				i += 3;
				
			}else if(daten.get(i).toString().equals("Repetition")){
				c = new Repetition("Repetition", Integer.parseInt(daten.get(i+1).toString()), Integer.parseInt(daten.get(i+2).toString()));
				i += 3;
				
			}else if(daten.get(i).toString().equals("Pause")){
				c = new Pause("Pause", Double.parseDouble(daten.get(i+1).toString()));
				i += 2;
			}else if(daten.get(i).toString().equals("Ende")){
					break;
			}
			
			controlProcess.add(c);
		}
		
		return antwort;
	}
	
	
	//@SuppressWarnings("unchecked")
	public boolean save(File f)
	{
		IOType ausgabe = new TextFile(f, false);
		Vector daten = new Vector();
		
		boolean antwort = false;
		int i = 0;
		
		while(true){
			Command c = controlProcess.get(i++);
			if(c == null)
				break;
			//@SuppressWarnings("rawtypes")
			
			
			if(c.getName() == "Direction"){
				daten.add(c.getName());
				daten.add(Integer.toString(((Direction) c).getDegree()));
				
			}else if(c.getName() == "Gear"){
				daten.add(c.getName());
				daten.add(Integer.toString(((Gear)c).getSpeed()));
				daten.add(Double.toString(((Gear)c).getDuration()));
				
			}else if(c.getName() == "Repetition"){
				daten.add(c.getName());
				daten.add(Integer.toString(((Repetition)c).getNrSteps()));
				daten.add(Integer.toString(((Repetition)c).getNrRepetitions()));
				
			}else if(c.getName() == "Pause"){
				daten.add(c.getName());
				daten.add(Double.toString(((Pause)c).getDuration()));
				
			}else{
				return false;
			}
			
			
			
		}
		daten.add("Ende");
		antwort = ausgabe.write(daten);
		ausgabe.close();
		return antwort;
	}
	
	public void commandPerformed(Command c)
	{
		
		
	}
	
	public CommandList getControllProcess()
	{
		return controlProcess;
	}

}