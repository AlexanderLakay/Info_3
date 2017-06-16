import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_konfiguration extends JPanel implements ActionListener{
	
	
	
	
	
	
	
	
	
	
	
	
	//CardLayout verwenden!!!
	
	
	
	
	
	
	
	
	static GUI_konfiguration konfig = null;
	
	int breite = 5; // Breite der Textfelder
	int befehl = 0; // 0 = direction, 1 = gear, 2 = repetition, 3 = pause
	GridLayout gl = new GridLayout(0,2);
	
	
	JPanel south = new JPanel(new BorderLayout());
	
	JPanel direction = new JPanel(gl);
	JPanel gear = new JPanel(gl);
	JPanel repetition = new JPanel(gl);
	JPanel pause = new JPanel(gl);
	
	JTextField degree = new JTextField(breite);
	JTextField speed = new JTextField(breite);
	JTextField durationGear = new JTextField(breite);
	JTextField steps = new JTextField(breite);
	JTextField repetitions = new JTextField(breite);
	JTextField durationPause = new JTextField(breite);
	
	public static GUI_konfiguration getInstance()
	{
		if(konfig == null)
			return new GUI_konfiguration();
		else
			return konfig;
	}
	
	public GUI_konfiguration()
	{

		
		
		this.setLayout(new BorderLayout());
		
		this.add(south, BorderLayout.SOUTH);
		
		
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
		
		
		
		
		
		
		
		
		JButton save = new JButton("Save");
		save.addActionListener(this);
		south.add(save, BorderLayout.EAST);
		
	}
	
	public void select(String s)
	{
		if(s.equals("Direction"))
			select(0);
		if(s.equals("Gear"))
			select(1);
		if(s.equals("Repetition"))
			select(2);
		if(s.equals("Pause"))
			select(3);
	}
	
	public void select(int i)
	{
		befehl = i;
		
		
		
		JPanel north = new JPanel(new BorderLayout());
		
		switch (befehl){
		case 0: 
			north.add(direction);
			
			break;
		case 1:
			north.add(gear);
			
			break;
		case 2: 
			north.add(repetition);
			
			break;
		case 3: 

			north.add(pause);
			
			break;
		}
		
		
		this.add(north, BorderLayout.NORTH);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Command c = null;
		switch (befehl){
		case 0: //direction
				c = new Direction("Direction", Integer.parseInt(degree.getText()));
				break;
		case 1: //gear
				c = new Gear("Gear", Integer.parseInt(speed.getText()), Double.parseDouble(durationGear.getText()));
		
				break;
		case 2: //repetition.setVisible(true);
				c = new Gear("Repetition", Integer.parseInt(steps.getText()), Integer.parseInt(repetitions.getText()));
				break;
		case 3: //pause.setVisible(true);
				c = new Pause("Pause", Double.parseDouble(durationPause.getText()));
				break;
					
		}
		
		ControlModel.getInstance().add(c);
	}

}
