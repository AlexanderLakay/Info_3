import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Alexander Lakay
 * Klasse zum Konfigurieren der Befehle
 *
 */
public class GUI_konfiguration extends JPanel implements ActionListener{
	
	private static GUI_konfiguration konfig = null;
	
	private int breite = 5; // Breite der Textfelder
	private String befehl = "Direction";
	private GridLayout gl = new GridLayout(0,2);
	
	
	private JPanel north = new JPanel(new CardLayout());
	private JPanel south = new JPanel(new BorderLayout());
	
	private JPanel direction = new JPanel(gl);
	private JPanel gear = new JPanel(gl);
	private JPanel repetition = new JPanel(gl);
	private JPanel pause = new JPanel(gl);
	
	private JTextField degree = new JTextField(breite);
	private JTextField speed = new JTextField(breite);
	private JTextField durationGear = new JTextField(breite);
	private JTextField steps = new JTextField(breite);
	private JTextField repetitions = new JTextField(breite);
	private JTextField durationPause = new JTextField(breite);
	
	private JButton save = new JButton("Save");
	
	/**
	 * 
	 * @return Gibt die einzige Instanz der Klasse zurueck
	 */
	public static GUI_konfiguration getInstance()
	{
		if(konfig == null)
			konfig =  new GUI_konfiguration();
		return konfig;
	}
	
	private GUI_konfiguration()
	{

		//direction
		direction.add(new JLabel("Degree:"));
		direction.add(degree);
		
		//gear
		gear.add(new JLabel("Speed: "));
		gear.add(speed);
		gear.add(new JLabel("Duration: "));
		gear.add(durationGear);
		
		//repetition
		repetition.add(new JLabel("Steps: "));
		repetition.add(steps);
		repetition.add(new JLabel("Repetitions: "));
		repetition.add(repetitions);
		
		//pause
		pause.add(new JLabel("Duration: "));
		pause.add(durationPause);
		
	
		north.add("Direction", direction);
		north.add("Gear", gear);
		north.add("Repetition", repetition);
		north.add("Pause", pause);
		
		
		save.addActionListener(this);
		south.add(save, BorderLayout.EAST);
		
		this.setLayout(new BorderLayout());
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Zeigt die zur Konfiguration benoetigten Elemente an
	 * @param s Name des zu konfigurierenden Befehls "Gear", "Repetition", "Direction" oder "Pause"
	 */
	public void select(String s)
	{
		befehl = s;
		CardLayout cl = (CardLayout)(north.getLayout());
		cl.show(north, s);
		 
	}
	
	/**
	 * Beim klick auf den Save Button wird das neue Element gespeichert
	 */
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Command c = null;
		if(befehl.equals("Direction"))
			try{
				c = new Direction("Direction", Integer.parseInt(degree.getText()));
			}catch(Exception e){}
			
		
		if(befehl.equals("Gear"))
			try{
				c = new Gear("Gear", Integer.parseInt(speed.getText()), Double.parseDouble(durationGear.getText()));
			}catch(Exception e){}
		
		if(befehl.equals("Repetition"))
			try{
				c = new Gear("Repetition", Integer.parseInt(steps.getText()), Integer.parseInt(repetitions.getText()));
			}catch(Exception e){}
		
		if(befehl.equals("Pause"))
			try{
				c = new Pause("Pause", Double.parseDouble(durationPause.getText()));
			}catch(Exception e){}
		
		//c an JTable uebergeben
		ControlModel.getInstance().add(c);
		MyTableModel.getInstance().add();
	}

}
