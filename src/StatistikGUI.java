import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class StatistikGUI extends JFrame implements ActionListener {
	
		
		StandTextPanel welcome;
		StandTextPanel eingabeFelder, testFeld;
		StandTextPanel ergebnisVarianz1, ergebnisSumme1, ergebnisMittelwert1, ergebnisStaAbw1, ergebnisMedian1, ergebnisSpannweite1;
		StandTextPanel ergebnisVarianz2, ergebnisSumme2, ergebnisMittelwert2, ergebnisStaAbw2, ergebnisMedian2, ergebnisSpannweite2;
		StandTextPanel ergebnisKovarianz,ergebnisRegress;
		StandButton rechne, einFeldPlus, einFeldMinus, wechsel;
		JPanel panel;
		
	    
		//frame groeese
		int width = 600;
		int height = 800;
		//Anzahl der Felder die angezeigt werden koennen
		int anzahlFelder = 50;
		//Anzahl der Felder die am Anfang angezeigt werden
		int anzahlFelderAnzeigen = 5;
		//laenge der Eingabefelder
		int textLength = 10;
		//groeese der Felder in Pixel
		Dimension label = new Dimension(80,20);
		
		//Erzeugen von Panels
		JPanel welcomePanel = new JPanel();
		JPanel ergebnisPanel1 = new JPanel();
		JPanel buttonPanel1 = new JPanel();
		JPanel felder = new JPanel();
		JPanel felderLinks = new JPanel();
		JPanel felderRechts = new JPanel();
		JPanel ergebnisse = new JPanel();
		JPanel ergebnisseLinks = new JPanel();
		JPanel ergebnisseRechts = new JPanel();
		JPanel ergebnisseZwei = new JPanel();
		
		//Erzeugen von Arraylists zum dynamischen erzeugen von Felder und Labels
		ArrayList<StandField> fields = new ArrayList<StandField>();
		ArrayList<StandLabel> labels = new ArrayList<StandLabel>();
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		ArrayList<StandTextPanel> textPanels1 = new ArrayList<StandTextPanel>();
		ArrayList<StandTextPanel> textPanels2 = new ArrayList<StandTextPanel>();

		StatistikGUI(String title){
			super(title);
			
			setSize(width,height);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout( new FlowLayout());
			
			//Layout der Eingabefelder
			//setze Boxlayout fuer die Eingabefelder links und rechts
			felder.setLayout(new FlowLayout());
			felderLinks.setLayout(new BoxLayout(felderLinks, BoxLayout.Y_AXIS));
			felderRechts.setLayout(new BoxLayout(felderRechts, BoxLayout.Y_AXIS));
			felder.setBackground(Color.green);
			
			ergebnisse.setLayout(new FlowLayout());
			ergebnisseLinks.setLayout(new BoxLayout(ergebnisseLinks, BoxLayout.Y_AXIS));
			ergebnisseRechts.setLayout(new BoxLayout(ergebnisseRechts, BoxLayout.Y_AXIS));
			ergebnisse.setBackground(Color.green);
			
			ergebnisseZwei.setLayout(new BoxLayout(ergebnisseZwei, BoxLayout.Y_AXIS));
			ergebnisseZwei.setBackground(Color.green);
			ergebnisseZwei.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//erzeuge neues Panel mit Textausgabe und setze es auf nicht editierbar
			//StandTextPanel(längeField, TextimField, ActionListener, ActionCommand, TextvonLabel, Grösse Label)
			welcome = new StandTextPanel(25, "", this, "outText3", "Hier kommen evtl. Fehlermeldungen", new Dimension(250,20));
			welcome.StandField.setEditable(false);
			
			//erzeuge die Ausgabefelder der einzelnen Ergebnisse - gespeichert in ergebnisseLinks
			//StandTextPanel(längeField, TextimField, ActionListener, ActionCommand, TextvonLabel, Grösse Label)
			ergebnisVarianz1 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Varianz", label);
			ergebnisSumme1 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Summe", label);
			ergebnisMittelwert1 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Mittelwert", label);
			ergebnisStaAbw1 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Standardabweichung", label);
			ergebnisMedian1 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Median", label);
			ergebnisSpannweite1 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Spannweite", label);
			
			//erzeuge die Ausgabefelder der einzelnen Ergebnisse - gespeichert in ergebnisseRechts
			//StandTextPanel(längeField, TextimField, ActionListener, ActionCommand, TextvonLabel, Grösse Label)
			ergebnisVarianz2 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Varianz", label);
			ergebnisSumme2 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Summe", label);
			ergebnisMittelwert2 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Mittelwert", label);
			ergebnisStaAbw2 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Standardabweichung", label);
			ergebnisMedian2 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Median", label);
			ergebnisSpannweite2 = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Spannweite", label);
			
			ergebnisKovarianz = new StandTextPanel(textLength, "Ergebnis", this, "outText3", "Kovarianz", label);
			ergebnisRegress = new StandTextPanel(30, "Ergebnis", this, "outText3", "Regressionsgerade", label);
			
			//Erste Reihe Eingabe Felder erzeugen - Felder werden in Panel felderLinks gespeichert
			for (int i = 0;i<anzahlFelder;i++){
				textPanels1.add(new StandTextPanel(textLength, null, this, "outPanel" + String.valueOf(i), (i+1) + ". Zahl", label));
				}
			//Zweite Reihe Eingabe Felder erzeugen - Felder werden in Panel felderRechts gespeichert
			for (int i = 0;i<anzahlFelder;i++){
				textPanels2.add(new StandTextPanel(textLength, null, this, "outPanel" + String.valueOf(i), (i+1) + ". Zahl", label));
				}
			//alle bis auf anzahlFelderAnzeigen Feld(er) ausblenden
			for (int i = textPanels1.size()-1; i>anzahlFelderAnzeigen-1;i--){
				textPanels1.get(i).setVisible(false);
			}
			for (int i = textPanels2.size()-1; i>anzahlFelderAnzeigen-1;i--){
				textPanels2.get(i).setVisible(false);
			}
			

			//StandButton(TextimButton, ActionCommand, ActionListener)
			rechne = new StandButton("rechne", "rechne", this);
			einFeldPlus = new StandButton("Plus ein Feld", "plusZahl", this);
			einFeldMinus = new StandButton("Minus ein Feld", "minusZahl", this);
			wechsel = new StandButton("wechsel die Buttons", "wechsel", this);
			
			//Die Fields,Buttons und Panels den Panels hinzufügen
			welcomePanel.add(welcome);
			buttonPanel1.add(einFeldMinus);
			buttonPanel1.add(einFeldPlus);
			//Die Arraylisten den Panels felderLinks und felderRechts hinzufuegen
			for (int i = 0;i<anzahlFelder;i++){
				felderLinks.add(textPanels1.get(i));
				textPanels1.get(i).setAlignmentX( Component.LEFT_ALIGNMENT );
				textPanels1.get(i).setBackground(Color.blue);
			}
			for (int i = 0;i<anzahlFelder;i++){
				felderRechts.add(textPanels2.get(i));
				textPanels2.get(i).setAlignmentX( Component.RIGHT_ALIGNMENT );
				textPanels2.get(i).setBackground(Color.red);
			}
			//felderLinks und felderRechts dem Panel felder hinzufügen
			felder.add(felderLinks);
			felder.add(felderRechts);
			ergebnisseLinks.add(ergebnisSumme1);
			ergebnisseLinks.add(ergebnisMittelwert1);
			ergebnisseLinks.add(ergebnisVarianz1);
			ergebnisseLinks.add(ergebnisStaAbw1);
			ergebnisseLinks.add(ergebnisMedian1);
			ergebnisseLinks.add(ergebnisSpannweite1);
			
			ergebnisseRechts.add(ergebnisSumme2);
			ergebnisseRechts.add(ergebnisMittelwert2);
			ergebnisseRechts.add(ergebnisVarianz2);
			ergebnisseRechts.add(ergebnisStaAbw2);
			ergebnisseRechts.add(ergebnisMedian2);
			ergebnisseRechts.add(ergebnisSpannweite2);
			
			ergebnisse.add(ergebnisseLinks);
			ergebnisse.add(ergebnisseRechts);
			
			ergebnisseZwei.add(ergebnisKovarianz);
			ergebnisseZwei.add(ergebnisRegress);
			
			//Die Panels den Frame hinzufügen
			add(welcomePanel);
			add(felder);
			add(rechne);
			add(buttonPanel1);
			add(ergebnisse);
			add(ergebnisseZwei);

			
		}
//eine Arraylist wird zu einem double Array verändert, nur wenn TextField einen Inhalt hat
public double[] listTodoubleArray (ArrayList<StandTextPanel> textPanels){
	ArrayList<String> temp = new ArrayList<String>();
	for (int i = 0;i<textPanels.size();i++){
		if(!textPanels.get(i).StandField.getText().equals("")){
			temp.add(textPanels.get(i).StandField.getText());
		}
	}
	double[] summen = new double[temp.size()];
	for (int i = 0; i<temp.size();i++){
		double x = Double.parseDouble(temp.get(i));
		summen[i] = x;
	}
	return summen;
}
//Die Anzahl der Inhalte der ArrayList wird gezählt
public int felderInhaltAnzahl(ArrayList<StandTextPanel> textPanels){
	int arrayLength = 0;

	for (int i = 0;i<textPanels.size();i++){
		if(!textPanels.get(i).StandField.getText().equals("")){
			arrayLength++;
		}
	}
	return arrayLength;
}
//Die Statistik Methoden werden auf die double Array angwendet
//in Strings umgewandelt und dann in das entsprechende
//Ergebnisfeld gespeichert
public void varianz (ActionEvent evt){
	DecimalFormat df = new DecimalFormat("#.###");
		if(evt.getActionCommand().equals("rechne")){
			try{
			double varianz = Statistik.varianz(listTodoubleArray(textPanels1), felderInhaltAnzahl(textPanels1));
			String ergebnis = String.valueOf(df.format(varianz));
			ergebnisVarianz1.StandField.setText(ergebnis);
			varianz = Statistik.summe(listTodoubleArray(textPanels1), felderInhaltAnzahl(textPanels1));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisSumme1.StandField.setText(ergebnis);
			varianz = Statistik.mittelwert(listTodoubleArray(textPanels1), felderInhaltAnzahl(textPanels1));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisMittelwert1.StandField.setText(ergebnis);
			varianz = Statistik.stabw(listTodoubleArray(textPanels1), felderInhaltAnzahl(textPanels1));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisStaAbw1.StandField.setText(ergebnis);
			varianz = Statistik.median(listTodoubleArray(textPanels1), felderInhaltAnzahl(textPanels1));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisMedian1.StandField.setText(ergebnis);
			varianz = Statistik.spannweite(listTodoubleArray(textPanels1), felderInhaltAnzahl(textPanels1));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisSpannweite1.StandField.setText(ergebnis);
			
			varianz = Statistik.varianz(listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels2));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisVarianz2.StandField.setText(ergebnis);
			varianz = Statistik.summe(listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels2));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisSumme2.StandField.setText(ergebnis);
			varianz = Statistik.mittelwert(listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels2));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisMittelwert2.StandField.setText(ergebnis);
			varianz = Statistik.stabw(listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels2));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisStaAbw2.StandField.setText(ergebnis);
			varianz = Statistik.median(listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels2));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisMedian2.StandField.setText(ergebnis);
			varianz = Statistik.spannweite(listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels2));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisSpannweite2.StandField.setText(ergebnis);
			
			varianz = Statistik.kovarianz(listTodoubleArray(textPanels1),listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels1));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisKovarianz.StandField.setText(ergebnis);
			ergebnis = Statistik.regress(listTodoubleArray(textPanels1),listTodoubleArray(textPanels2), felderInhaltAnzahl(textPanels1));
			ergebnisRegress.StandField.setText(ergebnis);
			}
			catch(ArrayIndexOutOfBoundsException e){
				welcome.StandField.setText("Die Zahlen muessen gleicher Anzahl sein!");
			}
			
		}
		
}
//Eine Reihe von den Eingabefelder Rechts UND Links wird hinzugefügt
public void plusEingabefeld(ActionEvent evt){
	if(evt.getActionCommand().equals("plusZahl")){
		for(int i = textPanels1.size()-1;!textPanels1.get(i).isVisible();i--){
			if(textPanels1.get(i-1).isVisible()){
				textPanels1.get(i).setVisible(true);
				textPanels2.get(i).setVisible(true);
			}
		}
	}
	
}
//Eine Reihe von den Eingabefelder Rechts UND Links wird entfernt
public void minusEingabefeld(ActionEvent evt){
	if(evt.getActionCommand().equals("minusZahl")){
		for(int i = 0;textPanels1.get(i).isVisible();i++){
			if(!textPanels1.get(i+1).isVisible()){
				textPanels1.get(i).setVisible(false);
				textPanels2.get(i).setVisible(false);
			}
		}
	}
	
}

		
public void actionPerformed (ActionEvent evt){
			varianz(evt);
			plusEingabefeld(evt);
			minusEingabefeld(evt);	  
	}



public static void main(String[]args){
	
	
	//StatistikGUI frame = new StatistikGUI("Alle Daten hier eingeben");
	//frame.setVisible(true);
	  
	  SwingUtilities.invokeLater(new Runnable(){
	    public void run(){
	      
	      StatistikGUI app = new StatistikGUI("Alle Daten hier eingeben");
	       app.setVisible(true);
	    }
	  }
	);
	
	



	
}

}
