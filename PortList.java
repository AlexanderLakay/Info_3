import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import hsrt.mec.controldeveloper.core.com.ComPort;

/**
 * 
 * @author Alexander Lakay, Marcel Gassmann, Kai Heckl
 *
 */
public class PortList extends JPanel implements ListSelectionListener{
	
	private JList jl;
	private static PortList list = null;
	private int index = 0;
	private ComPort[] ports;
	
	/**
	 * Konstruktor, erstellt eine Liste, in die die Ports geschrieben werden.
	 * @return list Liste, die die Ports beinhaltet
	 */
	public static PortList getInstance()  {
		if(list == null)
			list = new PortList();
		return list;
	}
	
	/**
	 * Private Methode PortList(), die die empfangenen Ports aus ControlModel getPorts() in eine 
	 * Liste schreibt.
	 */
	private PortList() {
		//super(ControlModel.getInstance().getPorts());
		ports = ControlModel.getInstance().getPorts();
		Vector v = new Vector<String>();
		for(int i = 0; i < ControlModel.getInstance().getPorts().length; i++){
			v.add(ports[i].getName());
		}
			
		jl = new JList(v);
		add(jl);	
		jl.addListSelectionListener(this);
	}

	/**
	 * Methode, die erkennt, wenn aus der Liste der verfuegbaren Ports einer ausgewaehlt wird.
	 * Index der Auswahl wird gespeichert.
	 */
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		index = jl.getSelectedIndex();
	}
	
	/**
	 * Gibt den Index des ausgewaehlten Ports zurueck.
	 * @return index Index des ausgewaehlten Ports.
	 */
	public int getIndex()
	{
		return index;
	}	
}
