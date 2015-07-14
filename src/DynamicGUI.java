import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;

/** @see http://stackoverflow.com/questions/5750068 */
public class DynamicGUI extends JFrame implements ActionListener {
    
	int width = 1200;
	int height = 800;
	
	menu menuBar;
	AnalyStat analyStat;
	StatUnab statUnab;
    
    public DynamicGUI(String title) {
    	super(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new FlowLayout());
    	menuBar = new menu(this);
    	menuBar.menuItem2.setActionCommand("statUnab");
    	setJMenuBar(menuBar);
    	
    	analyStat = new AnalyStat();
    	statUnab = new StatUnab();
    	
    	statUnab.setVisible(false);
    	
    	analyStat.setVisible(true);

  
    	add(analyStat);
    	add(statUnab);

        
       
    }
    public void switchPanel(ActionEvent evt){
    	if(evt.getSource() == menuBar.menuItem2){

    		statUnab.setVisible(true);
    		analyStat.setVisible(false);
    	}
    	if(evt.getActionCommand().equals("analyStat")){
    		statUnab.setVisible(false);
    		analyStat.setVisible(true);
    	}
    	
    }
    

    public void actionPerformed (ActionEvent evt){
    	switchPanel(evt);
}

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            DynamicGUI app = new DynamicGUI("Alle Daten hier eingeben");
     	      app.setVisible(true);
            }
        });
    }
}