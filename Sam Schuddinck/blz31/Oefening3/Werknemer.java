
public class Werknemer {
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	public double salaris;
	
	public Werknemer(String newVoornaam, String newAchternaam, int newWerknemerNummer,
			double newSalaris)
	{
		this.voornaam = newVoornaam;
		this.achternaam = newAchternaam;
		this.werknemerNummer = newWerknemerNummer;
		this.salaris = newSalaris;
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
