import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;


public class StandField extends JTextField {
public StandField (int columns, String text, ActionListener action, String command){
	super(text, columns);
	this.setActionCommand(command);
	this.addActionListener(action);
	

}
}