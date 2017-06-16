import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.ComPort;
import hsrt.mec.controldeveloper.core.com.ComPortHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.SerialUSB;
import hsrt.mec.controldeveloper.io.TextFile;
import java.io.File;
import java.util.Vector;


/**
 * Klasse zum Verwalten der Befehlsliste, Schnittstelle zur View
 * @author Alexander Lakay
 * 
 *
 */
public class ControlModel implements IComListener{

	private static ControlModel instance = null;
	private CommandType commandTypes[] = new CommandType[4];
	private CommandList controlProcess = new CommandList();
	private ComHandler comhandler = ComHandler.getInstance();
	
	private ControlModel()
	{
		comhandler.register(this);
	}
	
	public CommandType[] getCommandTypes()
	{
		return commandTypes;
	}
	
	/**
	 * Gibt das Objekt des ControlModels zurueck und erzeugt gegebenenfalls ein neues
	 * @return ControlModel
	 */
	public static ControlModel getInstance()
	{
		// Es gibt immer nur eine Instanz der Klasse
		if (instance == null)
			instance = new ControlModel();
		return instance;
	}
	
	/**
	 * Befuellt die Liste mit verfuegbaren Befehlen
	 */
	public void createCommandTyes()
	{
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
		
	}
	
	// Zugriff auf die verkettete Liste
	/**
	 * Fuegt ein neues Element zur Liste hinzu
	 * @param c Command Objekt, das zur Liste Hinzugefuegt werden soll
	 * @return Gibt true zurueck, wenn das Element hinzugefuegt wurde
	 */
	public boolean add(Command c) 
	{
		return controlProcess.add(c);
	}
	
	/**
	 * Entfernt das angegebene Element aus der Liste
	 * @param pos Index des zu entfernenden Elements
	 * @return Gibt true zurueck, wenn das Element entfernt wurde
	 */
	public boolean remove(int pos)
	{
		return controlProcess.remove(pos);
	}
	
	/**
	 * Gibt das Command Objekt an der stelle pos in der Liste zurueck
	 * @param pos Index des Listenelements
	 * @return Gibt das Command Objekt an der stelle pos in der Liste zurueck
	 */
	public Command get(int pos)
	{
		return controlProcess.get(pos);
	}
	
	/**
	 * Schiebt das ausgewaehlte Element um eine Position in der Liste nach oben
	 * @param pos Index des zu verschiebenden Elements
	 * @return Gibt true zurueck, wenn das Element verschoben wurde
	 */
	public boolean moveUp(int pos)
	{
		return controlProcess.moveUp(pos);
	}
	
	/**
	 * Schiebt das ausgewaehlte Element um eine Position in der Liste nach unten
	 * @param pos Index des zu verschiebenden Elements
	 * @return Gibt true zurueck, wenn das Element verschoben wurde
	 */
	public boolean moveDown(int pos)
	{
		return controlProcess.moveDown(pos);
	}
	
	
	
	/**
	 * Laedt die Befehlsliste aus der angegebenen Datei
	 * @param f Datei, die geladen werden soll
	 * @return Gibt true zutueck, wenn die Datei geladen wurde
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
			// Erzeugt anhand der Namen entsprechende Command Objekte und haengt sie an die Befehlsliste an
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
			// "Ende" Markiert das Listenende
			}else if(daten.get(i).toString().equals("Ende")){
					break;
			}else{
				// Faengt fehlerhafte Datei ab
				return false;
			}
			
			controlProcess.add(c);
		}
		
		return antwort;
	}
	
	
	/**
	 * Speichert die Befehlsliste in die angegebene Datei
	 * @param f Datei, in die die Befehlsliste gespeichert werden soll
	 * @return gibt true zurueck, wenn die Datei gespeichert wurde
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean save(File f)
	{
		IOType ausgabe = new TextFile(f, false);
		Vector daten = new Vector();
		
		boolean antwort = false;
		int i = 0;
		
		while(true){
			// Durchlaeuft die Befehlsliste und schreibt die Parameter in den Vector
			Command c = controlProcess.get(i++);
			
			// Ende der Befehlsliste
			if(c == null)
				break;
			
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
		// "Ende" Markiert das Listenende
		daten.add("Ende");
		antwort = ausgabe.write(daten);
		ausgabe.close();
		return antwort;
	}
	
	/**
	 * Gibt die CommandList Instanz der Befehlsliste zurueck
	 * @return Gibt die CommandList Instanz der Befehlsliste zurueck
	 */
	public CommandList getControllProcess()
	{
		return controlProcess;
	}

	/**
	 * 
	 * @return Gibt die Liste der verfuegbaren ComPorts zurueck
	 */
	public ComPort[] getPorts()
	{
		return ComPortHandler.getPorts();
	}
	
	/**
	 * Startet die ausfuehrung der Befehle
	 * @param portindex Index des zu oeffnenden Ports im Array getPorts()
	 * @return True, wenn kein Fehler auftrat, andernfalls False
	 */
	public boolean start(int portindex)
	{
		//Die CommandList muss erst in einen Vektor umgewandelt werden
		Vector <ICommand>commands = new Vector<ICommand>();
		int i = 0;
		while(true){
			ICommand c = controlProcess.get(i++);
			commands.add(c);
			if(c == null)
				break;
		}
			
		IOType port = new SerialUSB(getPorts()[portindex]);
		return comhandler.start(commands, port);
		
	}
	
	/**
	 * Stoppt die Ausfuehrung der Befehle
	 * @return True, wenn kein Fehler auftrat, andernfalls False
	 */
	public boolean stop()
	{
		return comhandler.stop();
	}
	
	public void commandPerformed(ICommand c)
	{
		//Command zur Ausgabe in der View hinzufuegen (c.toString())
		
	}

}
