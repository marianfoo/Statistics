import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class EntryFields extends JPanel implements ActionListener  {
	
	
	//Anzahl der Felder die angezeigt werden koennen
	int anzahlFelder = 21;
	int anzahlSpalten = 11;
	//Anzahl der Felder die am Anfang angezeigt werden
	//int anzahlZeilenAnzeigen = 20;
	//int anzahlSpaltenAnzeigen = 10;
	//laenge der Eingabefelder
	int textLength = 8;
	//groeese der Felder in Pixel
	Dimension labelSmall = new Dimension(60,20);
	Dimension labelMedium = new Dimension(100,20);
	Dimension labelBig = new Dimension(140,20);
	Dimension labelVeryBig = new Dimension(180,20);
	
	StandButton eineZeilePlus, eineZeileMinus, eineSpaltePlus, eineSpalteMinus;
	StandTextPanel sizeZeileField, sizeSpalteField;

	JPanel sizeTablePanel = new JPanel();
	JPanel buttonPanel1 = new JPanel();
	JPanel felderPanel = new JPanel();
	JScrollPane scroll;
	
	ArrayList<ArrayList<StandTextPanel>> felderSpalten = new ArrayList<ArrayList<StandTextPanel>>();
	
	ArrayList<JPanel> spaltenPanel = new ArrayList<JPanel>();

	public  EntryFields(int anzahlSpaltenAnzeigen, int anzahlZeilenAnzeigen){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.green);
		felderPanel.setLayout(new FlowLayout());
		
		for (int i = 0;i<anzahlSpalten;i++){
			felderSpalten.add(new ArrayList<StandTextPanel>());
			

			}

		//Erste Reihe Eingabe Felder erzeugen - Felder werden in Panel felderRechts gespeichert
		for (int i = 0;i<anzahlSpalten;i++){
			for (int j = 0;j<anzahlFelder;j++){
				felderSpalten.get(i).add(new StandTextPanel(textLength, null, this, "outPanel" + String.valueOf(j), (j+1) + ". Zahl", labelSmall));
				}
			}
		//Erzeugen von Panels fuer jede Spalte
		for (int i = 0;i<anzahlSpalten;i++){
			spaltenPanel.add(new JPanel());
			spaltenPanel.get(i).setLayout(new BoxLayout(spaltenPanel.get(i), BoxLayout.Y_AXIS));
			}

		//alle bis auf anzahlFelderAnzeigen Feld(er) ausblenden
		for (int i = 0;i<anzahlSpalten;i++){
			for (int j = anzahlFelder-1; j>anzahlZeilenAnzeigen-1;j--){
				felderSpalten.get(i).get(j).setVisible(false);
			}
			}

		
		//StandButton(TextimButton, ActionCommand, ActionListener)
		eineZeilePlus = new StandButton("Plus eine Zeile", "plusZeile", this);
		eineZeileMinus = new StandButton("Minus eine Zeile", "minusZeile", this);
		eineSpaltePlus = new StandButton("Plus eine Spalte", "plusSpalte", this);
		eineSpalteMinus = new StandButton("Minus eine Spalte", "minusSpalte", this);
		
		//Hier kann die groesse der Felder eingegeben werden
		sizeZeileField = new StandTextPanel(textLength, "", this, "zeile", "Anzahl Zeilen - max 20", labelVeryBig);
		sizeSpalteField = new StandTextPanel(textLength, "", this, "spalte", "Anzahl Spalten - max 10 ", labelVeryBig);
		
		
		//Die Arraylisten den Panels felderLinks und felderRechts hinzufuegen
		for (int i = 0;i<anzahlSpalten;i++){
			for (int j = 0;j<anzahlFelder;j++){
				
				spaltenPanel.get(i).add(felderSpalten.get(i).get(j));
				felderSpalten.get(i).get(j).setAlignmentX( Component.LEFT_ALIGNMENT );
				felderSpalten.get(i).get(j).setBackground(Color.blue);
			}
			}

		/*for (int i = 0;i<anzahlFelder;i++){
			felder2.add(textPanels2.get(i));
			textPanels2.get(i).setAlignmentX( Component.RIGHT_ALIGNMENT );
			textPanels2.get(i).setBackground(Color.red);
*/
		
		
		
		for(int i = 0;i<anzahlSpalten;i++){
			felderPanel.add(spaltenPanel.get(i));
			//spaltenPanel.get(i).add(felder);
		}

		for (int i = spaltenPanel.size()-1;i>anzahlSpaltenAnzeigen-1;i--){
				
				spaltenPanel.get(i).setVisible(false);
			
			}

		sizeTablePanel.add(sizeZeileField);
		sizeTablePanel.add(sizeSpalteField);
		buttonPanel1.add(eineZeileMinus);
		buttonPanel1.add(eineZeilePlus);
		buttonPanel1.add(eineSpaltePlus);
		buttonPanel1.add(eineSpalteMinus);
		//felderLinks und felderRechts dem Panel felder hinzufügen

		scroll = new JScrollPane(felderPanel);
		scroll.setPreferredSize(new Dimension(800, 200));
		this.add(sizeTablePanel);
		this.add(buttonPanel1);
		this.add(scroll);
		
		
	}
    public int felderInhaltAnzahl(ArrayList<StandTextPanel> textPanels){
    	int arrayLength = 0;

    	for (int i = 0;i<textPanels.size();i++){
    		if(!textPanels.get(i).StandField.getText().equals("")){
    			arrayLength++;
    		}
    	}
    	return arrayLength;
    }
    //Eine Reihe von den Eingabefelder Rechts UND Links wird hinzugefügt
    public void plusEingabefeld(ActionEvent evt){
    	if(evt.getActionCommand().equals("plusZeile")) {
    		System.out.println("Fehler");
    		for(int i = felderSpalten.size()-1;!felderSpalten.get(0).get(i).isVisible();i--){
    			if(felderSpalten.get(0).get(i-1).isVisible()){
    				for(int j = 0;j<felderSpalten.size();j++){
    					felderSpalten.get(j).get(i).setVisible(true);
    				}
    				//textPanels1.get(i).setVisible(true);

    			}
    		}
    	}
    	
    }
    //Eine Reihe von den Eingabefelder Rechts UND Links wird entfernt
    public void minusEingabefeld(ActionEvent evt){
    	if(evt.getActionCommand().equals("minusZeile")){
    		try {for(int i = 1;i<anzahlFelder;i++){
    				//ist i+1 auch visible?
    				if(!felderSpalten.get(0).get(i+1).isVisible()){
        				for(int j = 0;i<felderSpalten.size();j++){
        					felderSpalten.get(j).get(i).setVisible(false);
        				}
    				//textPanels1.get(i).setVisible(false);

    				}
    			}	
    		}
    		catch (IndexOutOfBoundsException e){
				int i = anzahlFelder-1;
				for(int j = 0;j<felderSpalten.size();j++){
					felderSpalten.get(j).get(i).setVisible(false);
				}
					//textPanels1.get(i).setVisible(false);

    		}
    	}
    	
    }
    public void plusSpalte(ActionEvent evt){
    	if(evt.getActionCommand().equals("plusSpalte")){
    		for(int i = spaltenPanel.size()-1;!spaltenPanel.get(i).isVisible();i--){
    			if(spaltenPanel.get(i-1).isVisible()){
    				spaltenPanel.get(i).setVisible(true);
    			}
    		}
    	}
    	
    }
    public void minusSpalte(ActionEvent evt){
    	if(evt.getActionCommand().equals("minusSpalte")){
    		try {for(int i = 1;i<anzahlSpalten;i++){
    				//ist i+1 auch visible?
    				if(!spaltenPanel.get(i+1).isVisible()){
    					spaltenPanel.get(i).setVisible(false);

    				}
    			}	
    		}
    		catch (IndexOutOfBoundsException e){
				int i = anzahlSpalten-1;
				spaltenPanel.get(i).setVisible(false);
    		}
    	}
    	
    }
    public void changeTable(ActionEvent evt){
    	if(evt.getActionCommand().equals("zeile")){
    		System.out.println("Zeile");
    		int anzahlZeilenAnzeigen = Integer.parseInt(sizeZeileField.StandField.getText());
    		
    		for (int i = 0;i<anzahlSpalten;i++){
    			for (int j = 0; j<anzahlFelder-1;j++){
    				felderSpalten.get(i).get(j).setVisible(true);
    			}
    		}
    		for (int i = 0;i<anzahlSpalten;i++){
    			for (int j = anzahlFelder-1; j>anzahlZeilenAnzeigen-1;j--){
    				felderSpalten.get(i).get(j).setVisible(false);
    			}
    		}
    	}
    	if(evt.getActionCommand().equals("spalte")){
    		int anzahlSpaltenAnzeigen = Integer.parseInt(sizeSpalteField.StandField.getText());
    		
    		for (int i = 0;i<spaltenPanel.size()-1;i++)
    			spaltenPanel.get(i).setVisible(true);
    		for (int i = spaltenPanel.size()-1;i>anzahlSpaltenAnzeigen-1;i--){
				spaltenPanel.get(i).setVisible(false);
			}
    	}
    }
    public void actionPerformed (ActionEvent evt){
		plusEingabefeld(evt);
		minusEingabefeld(evt);	
		plusSpalte(evt);
		minusSpalte(evt);
		changeTable(evt);
}
}
