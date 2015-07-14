import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class menu extends JMenuBar implements ActionListener {

    JMenu menu;         // each menu in the menu-bar
    JMenuItem menuItem, menuItem2; // an item in a menu
    
    public menu(ActionListener action){
    	
    	// First Menu
    	menu = new JMenu("Datei");
    	this.add(menu);
    	
    	menuItem = new JMenuItem("Analysierende Stat.");
    	menu.add(menuItem)
;    	menuItem.setActionCommand("analyStat");
		menuItem.addActionListener(action);

		menuItem2 = new JMenuItem("Stat. Unabhängigkeit");
		menu.add(menuItem2);
		menuItem2.addActionListener(action);
		
    }
    public void actionPerformed (ActionEvent evt){
    	
}
}
