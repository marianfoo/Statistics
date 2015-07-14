import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StandLabel extends JLabel {
public StandLabel (String text, Dimension label ){
	super(text);
	this.setPreferredSize(new Dimension(label));
	

}
}