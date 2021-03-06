
public class PartTimeWerknemer extends Werknemer {
	
	public int urenGewerkt;
	
	public PartTimeWerknemer(String newVoornaam, String newAchternaam, int newWerknemerNummer,
			double newSalaris, int newUrenGewerkt)
	{
		super(newVoornaam, newAchternaam, newWerknemerNummer, newSalaris);
		this.urenGewerkt = newUrenGewerkt;
	}
	
	public double getWeekLoon()
	{
		return this.salaris * (double) this.urenGewerkt;
	}
	
	public void salarisVerhogen(int percentage)
	{
		if(percentage > 5)
		{
			percentage =0;
			System.out.println("Fout: slechts 5% opslag toegestaan");
		}
		else
		{
			super.salarisVerhogen(percentage);
		}
	}
}
