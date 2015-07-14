import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Statistik {
	//eine Arraylist wird zu einem double Array verŠndert, nur wenn TextField einen Inhalt hat
    public static double[] ArrayListTodoubleArray (ArrayList<StandTextPanel> textPanels){
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
	public static int datenzahl (){
	    Scanner sc = new Scanner(System.in);
		System.out.println("Wie viele Daten haben Sie? ");
		int n = sc.nextInt();
		return n;
	}
	public static double[] dateneingabe (int n){
		double daten1[] = new double[n];
		int zaehlen1 =1;
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<n;i++){
			System.out.println("Geben sie hier Ihre " + zaehlen1 + ". Zahl ein ");
			daten1 [i] = sc.nextDouble();
			zaehlen1++;
		}
		return daten1;
	}
	public static double summe (double daten1[],int n){
		double summe1 = 0;
		for (int i=0; i<n;i++){
			summe1 = daten1[i] + summe1;
		}
		return summe1;
	}
	public static double mittelwert (double daten1[],int n){
		double summe1 = 0;
		for (int i= 0;i<n; i++){
			summe1 = daten1[i] + summe1;
		}
		double mittelwert = summe1/n;
		return mittelwert;
	}
	public static double varianz (double daten1[], int n){
		double zwischenvertvar1 = 0;
		double varianz1 = 0;
		for (int i=0; i<n;i++){
			zwischenvertvar1 = ((daten1[i] - mittelwert(daten1,n)) * (daten1 [i] - mittelwert(daten1,n))) / n;
			varianz1 = zwischenvertvar1 + varianz1;
		}
		return varianz1;
	}
	public static double kovarianz (double daten1[],double daten2[],int n){
		double zwischenvertvar1 = 0;
		double zwischenvertvar2 = 0;
		double zwischenvertkov = 0;
		double varianz1 = 0;
		double varianz2 = 0;
		double kovarianz = 0;
		for (int i=0; i<n;i++){
			zwischenvertvar1 = ((daten1[i] - mittelwert(daten1,n)) * (daten1 [i] - mittelwert(daten1,n))) / n;
			varianz1 = zwischenvertvar1 + varianz1;
			zwischenvertvar2 = ((daten2[i] - mittelwert(daten2,n)) * (daten2 [i] - mittelwert(daten2,n))) / n;
			varianz2 = zwischenvertvar2 + varianz2;
			zwischenvertkov = ((daten2[i] - mittelwert(daten2,n)) * (daten1[i] - mittelwert(daten1,n))) / n;
			kovarianz = zwischenvertkov + kovarianz;
		}
		return kovarianz;
	}
	public static double stabw (double daten1[], int n){
		double varianz1 = varianz(daten1,n);
		return Math.sqrt(varianz1);
		
	}
	public static double korrelation (double daten1[],double daten2[],int n){
		double korr = kovarianz(daten1,daten2,n) / (stabw(daten1,n) * stabw(daten2,n));
		return korr;
	}
	public static double median (double daten1[],int n){
		java.util.Arrays.sort(daten1);
		int median1;
		if (n%2 != 0){
			median1 = (((n+1)/2))-1;
			return daten1[median1];
		}
		else {
			int median1x = (n/2) - 1;
			int median1y = (n/2);
			double median2 = (daten1[median1x] + daten1[median1y]) / 2;
			return median2;
		}
		
	}
	public static String regress (double daten1[],double daten2[],int n){
		double b = kovarianz(daten1,daten2,n) / varianz(daten1,n);
		double a = mittelwert(daten2,n) - b*mittelwert(daten1,n);
		DecimalFormat df = new DecimalFormat("#.##");
		String regress = "yi = " + df.format(a) + " + " + df.format(b) + "xj";
		return regress;
	}
	public static double quartilab (double daten1[],double daten2[],int n){
		if (n>=4){
		if (n%4 == 0){
			 int einviertel = (n/4)-1;
			 int dreiviertel = ((n/4)*3)-1;
			 double quartilabstand1 = daten1[dreiviertel] - daten1[einviertel];
			 return quartilabstand1;
		}
		else {
			int einviertel = (n/4)-1;
			int einviertel1 = n/4;
			int dreiviertel = (n/4*3);
			int dreiviertel1 = (n/4*3)+1;
			double quartilabstand1 = ((daten1[dreiviertel] + daten1[dreiviertel1])/2) - ((daten1[einviertel] + daten1[einviertel1])/2);
			return quartilabstand1;
			
		}
		} return 0;
	}
	public static double spannweite (double daten1[],int n){
		java.util.Arrays.sort(daten1);
		double spannweite1 = daten1[n-1] - daten1[0];
		return spannweite1;
	}
}
