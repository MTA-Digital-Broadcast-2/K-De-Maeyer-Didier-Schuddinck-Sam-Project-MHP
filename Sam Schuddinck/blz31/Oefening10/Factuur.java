
public class Factuur implements Betaalbaar {
	public int factuurNr;
	public double factuurBedrag;
	
	public Factuur(int newNummer, double newBedrag)
	{
		this.factuurNr = newNummer;
		this.factuurBedrag = newBedrag;
	}
	
	public void betaal() {
		System.out.println("Betaal het factuur "+ this.factuurNr+" voor een bedrag van "+this.factuurBedrag);
		
	}
}
