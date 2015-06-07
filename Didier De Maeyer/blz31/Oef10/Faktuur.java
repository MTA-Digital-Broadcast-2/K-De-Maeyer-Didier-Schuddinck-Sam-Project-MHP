public class Faktuur implements Betaalbaar 
{
	public int faktuurNr;
	public float faktuurBedrag;

	public Faktuur(int faktuurNr, float faktuurBedrag)
	{
		this.faktuurNr = faktuurNr;
		this.faktuurBedrag = faktuurBedrag;
	}

	public void betaal()
	{
		System.out.println("Betaal het faktuur " + faktuurNr + " voor een bedrag van " + faktuurBedrag);
	}
}