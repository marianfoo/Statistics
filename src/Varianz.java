
public class Varianz {
	public static void main(String[] args) {
		int n = Statistik.datenzahl();
		double daten1[] = Statistik.dateneingabe(n);
		double daten2[] = Statistik.dateneingabe(n);
		double summe1 = Statistik.summe(daten1,n);
		double summe2 = Statistik.summe(daten2,n);
		double mittelwert = Statistik.mittelwert(daten1,n);
		double mittelwert2 = Statistik.mittelwert(daten2,n);
		double kovarianz = Statistik.kovarianz(daten1,daten2,n);
		double varianz1 = Statistik.varianz(daten1,n);
		double varianz2 = Statistik.varianz(daten2,n);
		double stabw1 = Statistik.stabw(daten1,n);
		double stabw2 = Statistik.stabw(daten2,n);
		double korr = Statistik.korrelation(daten1,daten2,n);
		double median1 = Statistik.median(daten1,n);
		double median2 = Statistik.median(daten2,n);
		//Statistik.printregres(daten1,daten2,n);
		double quartilabstand1 = Statistik.quartilab(daten1,daten2,n);
		double quartilabstand2 = Statistik.quartilab(daten1,daten2,n);
		double spannweite1 = Statistik.spannweite(daten1,n);
		double spannweite2 = Statistik.spannweite(daten2,n);
		
		
		System.out.println("Der Quartilsabstand von xj betraegt: " + quartilabstand1);
		System.out.println("Der Quartilsabstand von yj betraegt: " + quartilabstand2);
		System.out.println("Der Median von xj ist: " + median1 + " Der Median von yi ist: " + median2);
		System.out.println("Die Spannweite von xj ist: " + spannweite1 + " von yi ist sie: " + spannweite2);
		System.out.println("Die Kovarianz betraegt: " + kovarianz);
		System.out.println("Die Standardabweichung von xi betraegt: " + stabw1 + " Die von yi ist: " + stabw2);
		System.out.println("Die Varianz von xi betraegt: " + varianz1 + " Die Varianz von yi ist: " + varianz2);
		System.out.println("Der Mittelwert der Daten xi betraegt: " + mittelwert + " Der MW von yi ist: " + mittelwert2);
		System.out.println("Die Summe der Daten xi ist: " + summe1 + " Die Summe von yi ist: " + summe2);
		System.out.println("Die Korrelation zwischen xi und yi ist: " + korr);
		//Statistik.printregres(daten1,daten2,n);

		System.out.println("\nAlle Operationen wurden erfolgreich ausgefuehrt ");
}
}