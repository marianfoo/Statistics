import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class StandButton extends JButton {
public StandButton (String text, String command, ActionListener action){
	super(text);
	this.setActionCommand(command);
	this.addActionListener(action);
	this.setPreferredSize(new Dimension(200,20));


}
}
