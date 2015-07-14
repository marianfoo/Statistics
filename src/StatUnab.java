import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class StatUnab extends JPanel implements ActionListener {
	
	DecimalFormat df = new DecimalFormat("#.###");

	StandTextPanel welcome;
	StandTextPanel eingabeFelder, testFeld;
	StandTextPanel ergebnisVarianz1, ergebnisSumme1, ergebnisMittelwert1, ergebnisStaAbw1, ergebnisMedian1, ergebnisSpannweite1;
	StandTextPanel ergebnisVarianz2, ergebnisSumme2, ergebnisMittelwert2, ergebnisStaAbw2, ergebnisMedian2, ergebnisSpannweite2;
	StandTextPanel ergebnisKovarianz,ergebnisRegress;
	StandButton wechsel, plusFeld, minusFeld, rechne;
	JRadioButton textFeld1, textFeld2, beideRadio;
	ButtonGroup zahlenReihenAuswahlGroup;
	JPanel panel, plusMinusPanel;
	
	EntryFields eingabePanel;
	

	
    
	//frame groeese
	int width = 600;
	int height = 800;
	//Anzahl der Felder die angezeigt werden koennen
	//int anzahlFelder = 6;
	//Anzahl der Felder die am Anfang angezeigt werden
	//int anzahlFelderAnzeigen = 5;
	//laenge der Eingabefelder
	int textLength = 10;
	//groeese der Felder in Pixel
	Dimension label = new Dimension(80,20);
	
	//Erzeugen von Panels
	JPanel welcomePanel = new JPanel();
	JPanel ergebnisPanel1 = new JPanel();
	JPanel ergebnisse = new JPanel();
	JPanel ergebnisseLinks = new JPanel();
	JPanel ergebnisseRechts = new JPanel();
	JPanel ergebnisseZwei = new JPanel();
	JPanel zahlenReiheAuswahlPanel = new JPanel();
	
	
	//Erzeugen von Arraylists zum dynamischen erzeugen von Felder und Labels
	ArrayList<StandField> fields = new ArrayList<StandField>();
	ArrayList<StandLabel> labels = new ArrayList<StandLabel>();
	ArrayList<JPanel> panels = new ArrayList<JPanel>();
    
    public StatUnab() {
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//Layout der Eingabefelder
		ergebnisse.setLayout(new FlowLayout());
		ergebnisseLinks.setLayout(new BoxLayout(ergebnisseLinks, BoxLayout.Y_AXIS));
		ergebnisseRechts.setLayout(new BoxLayout(ergebnisseRechts, BoxLayout.Y_AXIS));
		ergebnisse.setBackground(Color.green);
		
		ergebnisseZwei.setLayout(new BoxLayout(ergebnisseZwei, BoxLayout.Y_AXIS));
		ergebnisseZwei.setBackground(Color.green);
		ergebnisseZwei.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//erzeuge neues Panel mit Textausgabe und setze es auf nicht editierbar
		//StandTextPanel(längeField, TextimField, ActionListener, ActionCommand, TextvonLabel, Grösse Label)
		welcome = new StandTextPanel(25, "", null, "outText3", "Hier kommen evtl. Fehlermeldungen", new Dimension(250,20));
		welcome.StandField.setEditable(false);
		
		//erzeuge die Ausgabefelder der einzelnen Ergebnisse - gespeichert in ergebnisseLinks
		//StandTextPanel(längeField, TextimField, ActionListener, ActionCommand, TextvonLabel, Grösse Label)
		ergebnisVarianz1 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Varianz", label);
		ergebnisSumme1 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Summe", label);
		ergebnisMittelwert1 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Mittelwert", label);
		ergebnisStaAbw1 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Standardabweichung", label);
		ergebnisMedian1 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Median", label);
		ergebnisSpannweite1 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Spannweite", label);
		
		//erzeuge die Ausgabefelder der einzelnen Ergebnisse - gespeichert in ergebnisseRechts
		//StandTextPanel(längeField, TextimField, ActionListener, ActionCommand, TextvonLabel, Grösse Label)
		ergebnisVarianz2 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Varianz", label);
		ergebnisSumme2 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Summe", label);
		ergebnisMittelwert2 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Mittelwert", label);
		ergebnisStaAbw2 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Standardabweichung", label);
		ergebnisMedian2 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Median", label);
		ergebnisSpannweite2 = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Spannweite", label);
		
		ergebnisKovarianz = new StandTextPanel(textLength, "Ergebnis", null, "outText3", "Kovarianz", label);
		ergebnisRegress = new StandTextPanel(30, "Ergebnis", null, "outText3", "Regressionsgerade", label);

		//StandButton(TextimButton, ActionCommand, ActionListener)
		wechsel = new StandButton("wechsel die Buttons", "wechsel", this);
		rechne = new StandButton("rechne", "rechne", this);
		
		//Radiobuttons zur Auswahl der Rechenoperation
		textFeld1 = new JRadioButton("Linke Zahlen berechnen", false);
		textFeld1.setActionCommand("textFeld1");
		textFeld1.addActionListener(this);
		textFeld2 = new JRadioButton("Rechte Zahlen berechnen", false);
		textFeld2.setActionCommand("textFeld2");
		textFeld2.addActionListener(this);
		beideRadio = new JRadioButton("beide Zahlenreihen berechnen", true);
		beideRadio.setActionCommand("beideRadio");
		beideRadio.addActionListener(this);
		zahlenReihenAuswahlGroup = new ButtonGroup();
		zahlenReihenAuswahlGroup.add(textFeld1);
		zahlenReihenAuswahlGroup.add(textFeld2);
		zahlenReihenAuswahlGroup.add(beideRadio);
		zahlenReiheAuswahlPanel.setLayout( new BoxLayout(zahlenReiheAuswahlPanel , BoxLayout.Y_AXIS));
		zahlenReiheAuswahlPanel.add(textFeld1);
		zahlenReiheAuswahlPanel.add(textFeld2);
		zahlenReiheAuswahlPanel.add(beideRadio);
		zahlenReihenAuswahlGroup.getSelection();
		
		
		//Die Fields,Buttons und Panels den Panels hinzufügen
		welcomePanel.add(welcome);
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
		
		//Die Panels dem Panel hinzufügen
		
		eingabePanel = new EntryFields(3,2);
		
		this.add(welcome);
		this.add(eingabePanel);
		this.add(rechne);
		this.add(ergebnisse);
		this.add(ergebnisseZwei);

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
    public void varianzTextfeld2 (ActionEvent evt){
    		if(evt.getActionCommand().equals("rechne")){
    			try{
    			double varianz = Statistik.varianz(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(1)));
    			String ergebnis = String.valueOf(df.format(varianz));
    			ergebnisVarianz2.StandField.setText(ergebnis);
    			varianz = Statistik.summe(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(1)));
    			ergebnis = String.valueOf(df.format(varianz));
    			ergebnisSumme2.StandField.setText(ergebnis);
    			varianz = Statistik.mittelwert(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(1)));
    			ergebnis = String.valueOf(df.format(varianz));
    			ergebnisMittelwert2.StandField.setText(ergebnis);
    			varianz = Statistik.stabw(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(1)));
    			ergebnis = String.valueOf(df.format(varianz));
    			ergebnisStaAbw2.StandField.setText(ergebnis);
    			varianz = Statistik.median(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(1)));
    			ergebnis = String.valueOf(df.format(varianz));
    			ergebnisMedian2.StandField.setText(ergebnis);
    			varianz = Statistik.spannweite(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(1)));
    			ergebnis = String.valueOf(df.format(varianz));
    			ergebnisSpannweite2.StandField.setText(ergebnis);
    			}
    			catch(ArrayIndexOutOfBoundsException e){
    				welcome.StandField.setText("Die Zahlen muessen gleicher Anzahl sein!");
    			}
    		}
    }
    public void varianzTextfeld1 (ActionEvent evt){
		if(evt.getActionCommand().equals("rechne")){
			try{
			double varianz = Statistik.varianz(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			String ergebnis = String.valueOf(df.format(varianz));
			ergebnisVarianz1.StandField.setText(ergebnis);
			varianz = Statistik.summe(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisSumme1.StandField.setText(ergebnis);
			varianz = Statistik.mittelwert(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisMittelwert1.StandField.setText(ergebnis);
			varianz = Statistik.stabw(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisStaAbw1.StandField.setText(ergebnis);
			varianz = Statistik.median(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisMedian1.StandField.setText(ergebnis);
			varianz = Statistik.spannweite(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			ergebnis = String.valueOf(df.format(varianz));
			ergebnisSpannweite1.StandField.setText(ergebnis);
			}
			catch(ArrayIndexOutOfBoundsException e){
				welcome.StandField.setText("Die Zahlen muessen gleicher Anzahl sein!");
			}	
		}
}
    public void varianzBeide (ActionEvent evt){
		if(evt.getActionCommand().equals("rechne")){
			try{
			double varianz = Statistik.kovarianz(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)),Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			String ergebnis = String.valueOf(df.format(varianz));
			ergebnisKovarianz.StandField.setText(ergebnis);
			ergebnis = Statistik.regress(Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(0)),Statistik.ArrayListTodoubleArray(eingabePanel.felderSpalten.get(1)), felderInhaltAnzahl(eingabePanel.felderSpalten.get(0)));
			ergebnisRegress.StandField.setText(ergebnis);
			}
			catch(ArrayIndexOutOfBoundsException e){
				welcome.StandField.setText("Die Zahlen muessen gleicher Anzahl sein!");
			}
		}
}
    //Eine Reihe von den Eingabefelder Rechts UND Links wird hinzugefügt
public void berechneTextFelder(ActionEvent evt){
	if(textFeld1.isSelected())
		varianzTextfeld1(evt);
	if(textFeld2.isSelected())
		varianzTextfeld2(evt);
	if(beideRadio.isSelected()){
		varianzBeide(evt);
		varianzTextfeld1(evt);
		varianzTextfeld2(evt);
	}
}
public void actionPerformed (ActionEvent evt){
	berechneTextFelder(evt);
}
}
