import hsrt.mec.controldeveloper.core.com.command.ICommand;

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
 * Klasse zum Konfigurieren der Befehle
 * 
 * @author Alexander Lakay
 */

public class GUI_konfiguration extends JPanel{
	
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
	private JButton add = new JButton("Add");
	
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
		
		
		add.addActionListener(new ActionListener(){

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
						c = new Repetition("Repetition", Integer.parseInt(steps.getText()), Integer.parseInt(repetitions.getText()));
					}catch(Exception e){}
				
				if(befehl.equals("Pause"))
					try{
						c = new Pause("Pause", Double.parseDouble(durationPause.getText()));
					}catch(Exception e){}
				
				//c an JTable uebergeben
				ControlModel.getInstance().add(c);
			}
			
		});
		
		save.addActionListener(new ActionListener(){

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
						c = new Repetition("Repetition", Integer.parseInt(steps.getText()), Integer.parseInt(repetitions.getText()));
					}catch(Exception e){}
				
				if(befehl.equals("Pause"))
					try{
						c = new Pause("Pause", Double.parseDouble(durationPause.getText()));
					}catch(Exception e){}
				
				//c an JTable uebergeben
				ControlModel.getInstance().setCommand(GUI_Ablauf.getInstance().getSelectedIndex(), c);
			}
			
		});
		south.add(save, BorderLayout.EAST);
		south.add(add, BorderLayout.WEST);
		
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
	 * Laed die Informationen des ausgewaehlten Befehls neu
	 * @param c Parameter des ausgewaehlten Befehls
	 */
	
	
	public void load(ICommand c)
	{
		if(c instanceof Direction){
			degree.setText(Integer.toString(((Direction) c).getDegree()));
		}
		if(c instanceof Gear){
			speed.setText(Integer.toString(((Gear) c).getSpeed()));
			durationGear.setText(Double.toString(((Gear) c).getDuration()));
		}
		if(c instanceof Repetition){
			repetitions.setText(Integer.toString(((Repetition) c).getNrRepetitions()));
			steps.setText(Integer.toString(((Repetition) c).getNrSteps()));
	
		}
		if(c instanceof Pause){
			durationPause.setText(Double.toString(((Pause) c).getDuration()));
		}
			
	}

}
