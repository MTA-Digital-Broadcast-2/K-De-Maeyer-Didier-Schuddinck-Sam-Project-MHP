
public class Werknemer {
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	public double salaris;
	private double RSZPercentage;
	
	public Werknemer(String newVoornaam, String newAchternaam, int newWerknemerNummer,
			double newSalaris)
	{
		this.voornaam = newVoornaam;
		this.achternaam = newAchternaam;
		this.werknemerNummer = newWerknemerNummer;
		this.salaris = newSalaris;
		this.RSZPercentage = 0.33;
	}
	public double getRSZPercentage()
	{
		return this.RSZPercentage *100;
	}
	public void setRSZPercentage(double percentage)
	{
		this.RSZPercentage = percentage/100;
	}
	public void salarisVerhogen(int percentage)
	{
		double verhogingsfactor = (double) percentage/100;
		
		this.salaris = this.salaris * verhogingsfactor;
	}
	
	public double getSalaris()
	{
		return this.salaris;
	}
}
