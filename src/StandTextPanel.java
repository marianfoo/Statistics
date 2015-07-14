import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
public class StandTextPanel extends JPanel {
	public StandField StandField;
	public StandLabel StandLabel;


	public StandTextPanel(int textLength, String textField, ActionListener listField, String commandField, String textLabel, Dimension label  ) 
	{
		StandField = new StandField(textLength, textField, listField, commandField);
		StandLabel = new StandLabel(textLabel, label);
		add(StandLabel);
		add(StandField);
		

	}
	
}
